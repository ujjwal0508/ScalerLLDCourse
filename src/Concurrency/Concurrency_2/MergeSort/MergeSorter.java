package Concurrency.Concurrency_2.MergeSort;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MergeSorter implements Callable<List<Integer>> {

    private List<Integer> arrayToSort;

    //ADD THIS LATER
    private ExecutorService executorService;

    //DRAFT 1

//    public MergeSorter(List<Integer> arrayToSort) {
//        this.arrayToSort = arrayToSort;
//    }

    public MergeSorter(List<Integer> arrayToSort, ExecutorService executorService) {
        this.arrayToSort = arrayToSort;
        this.executorService = executorService;
    }
    //DRAFT 1 - WITH NO THREADS

//    @Override
//    public List<Integer> call() throws Exception {
//
//        //base case
//        if (arrayToSort.size() <= 1)
//            return arrayToSort;
//
//        int mid = arrayToSort.size() / 2;
//        List<Integer> leftArray = new ArrayList<>();
//
//        for (int i = 0; i < mid; i++) {
//            leftArray.add(arrayToSort.get(i));
//        }
//
//        List<Integer> rightArray = new ArrayList<>();
//
//        for (int i = mid; i < arrayToSort.size(); i++) {
//            rightArray.add(arrayToSort.get(i));
//        }
//
//        MergeSorter leftMs = new MergeSorter(leftArray);
//        MergeSorter rightMs = new MergeSorter(rightArray);
//
//        List<Integer> leftSortedArray = leftMs.call();
//        List<Integer> rightSortedArray = rightMs.call();
//
//        List<Integer> sortedArray = new ArrayList<>();
//
//        int leftPtr = 0;
//        int rightPtr = 0;
//
//        while (leftPtr < leftSortedArray.size() && rightPtr < rightSortedArray.size()) {
//            if (leftSortedArray.get(leftPtr) < rightSortedArray.get(rightPtr)) {
//                sortedArray.add(leftSortedArray.get(leftPtr));
//                leftPtr++;
//            } else {
//                sortedArray.add(rightSortedArray.get(rightPtr));
//                rightPtr++;
//            }
//        }
//
//        while (leftPtr < leftSortedArray.size()) {
//            sortedArray.add(leftSortedArray.get(leftPtr));
//            leftPtr++;
//        }
//
//        while (rightPtr < rightSortedArray.size()) {
//            sortedArray.add(rightSortedArray.get(rightPtr));
//            rightPtr++;
//        }
//
//        return sortedArray;
//
//    }

    //DRAFT 2 - WITH NEW EXECUTORS

//    @Override
//    public List<Integer> call() throws Exception {
//
//        System.out.println("Called by thread - " + Thread.currentThread().getName());
//        //base case
//        if (arrayToSort.size() <= 1)
//            return arrayToSort;
//
//        int mid = arrayToSort.size() / 2;
//        List<Integer> leftArray = new ArrayList<>();
//
//        for (int i = 0; i < mid; i++) {
//            leftArray.add(arrayToSort.get(i));
//        }
//
//        List<Integer> rightArray = new ArrayList<>();
//
//        for (int i = mid; i < arrayToSort.size(); i++) {
//            rightArray.add(arrayToSort.get(i));
//        }
//
//        MergeSorter leftMs = new MergeSorter(leftArray);
//        MergeSorter rightMs = new MergeSorter(rightArray);
//
//        ExecutorService executorService = Executors.newCachedThreadPool();
//
//        Future<List<Integer>> leftSortedArrayFuture = executorService.submit(leftMs);
//        Future<List<Integer>> rightSortedArrayFuture = executorService.submit(rightMs);
//
//        List<Integer> sortedArray = new ArrayList<>();
//
//        int leftPtr = 0;
//        int rightPtr = 0;
//
//        List<Integer> leftSortedArray = leftSortedArrayFuture.get(); //code will not go further till i have the final result here from this thread
//        List<Integer> rightSortedArray = rightSortedArrayFuture.get();
//
//        //before this line we need them both
//        while (leftPtr < leftSortedArray.size() && rightPtr < rightSortedArray.size()) {
//            if (leftSortedArray.get(leftPtr) < rightSortedArray.get(rightPtr)) {
//                sortedArray.add(leftSortedArray.get(leftPtr));
//                leftPtr++;
//            } else {
//                sortedArray.add(rightSortedArray.get(rightPtr));
//                rightPtr++;
//            }
//        }
//
//        while (leftPtr < leftSortedArray.size()) {
//            sortedArray.add(leftSortedArray.get(leftPtr));
//            leftPtr++;
//        }
//
//        while (rightPtr < rightSortedArray.size()) {
//            sortedArray.add(rightSortedArray.get(rightPtr));
//            rightPtr++;
//        }
//
//        return sortedArray;
//
//    }

    //FINAL DRAFT

    @Override
    public List<Integer> call() throws Exception {

        System.out.println("Called by thread - " + Thread.currentThread().getName());
        //base case
        if (arrayToSort.size() <= 1)
            return arrayToSort;

        int mid = arrayToSort.size() / 2;
        List<Integer> leftArray = new ArrayList<>();

        for (int i = 0; i < mid; i++) {
            leftArray.add(arrayToSort.get(i));
        }

        List<Integer> rightArray = new ArrayList<>();

        for (int i = mid; i < arrayToSort.size(); i++) {
            rightArray.add(arrayToSort.get(i));
        }

        MergeSorter leftMs = new MergeSorter(leftArray, executorService);
        MergeSorter rightMs = new MergeSorter(rightArray, executorService);

        Future<List<Integer>> leftSortedArrayFuture = executorService.submit(leftMs);
        Future<List<Integer>> rightSortedArrayFuture = executorService.submit(rightMs);

        List<Integer> sortedArray = new ArrayList<>();

        int leftPtr = 0;
        int rightPtr = 0;

        List<Integer> leftSortedArray = leftSortedArrayFuture.get(); //code will not go further till i have the final result here from this thread
        List<Integer> rightSortedArray = rightSortedArrayFuture.get();

        //before this line we need them both
        while (leftPtr < leftSortedArray.size() && rightPtr < rightSortedArray.size()) {
            if (leftSortedArray.get(leftPtr) < rightSortedArray.get(rightPtr)) {
                sortedArray.add(leftSortedArray.get(leftPtr));
                leftPtr++;
            } else {
                sortedArray.add(rightSortedArray.get(rightPtr));
                rightPtr++;
            }
        }

        while (leftPtr < leftSortedArray.size()) {
            sortedArray.add(leftSortedArray.get(leftPtr));
            leftPtr++;
        }

        while (rightPtr < rightSortedArray.size()) {
            sortedArray.add(rightSortedArray.get(rightPtr));
            rightPtr++;
        }

        return sortedArray;

    }
}
