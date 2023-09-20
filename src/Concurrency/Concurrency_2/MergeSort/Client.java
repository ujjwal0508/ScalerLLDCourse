package Concurrency.Concurrency_2.MergeSort;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Client {

    public static void main(String[] args) throws Exception {

        List<Integer> list = List.of(7, 3, 4, 1, 9, 8, 2, 6);

        // THIS CODE IS NOT MULTITHREADED

//        MergeSorter sorter = new MergeSorter(list);
//        List<Integer> sortedList = sorter.call();
//        System.out.println(sortedList);


        //CANT WORK WITHOUT FUTURE

        //WORKING CODE
        ExecutorService executorService = Executors.newCachedThreadPool();
        MergeSorter sorter = new MergeSorter(list, executorService);
        Future<List<Integer>> sortedListFuture = executorService.submit(sorter);

        List<Integer> sortedList = sortedListFuture.get();
        System.out.println(sortedList);

        executorService.close();

    }
}
