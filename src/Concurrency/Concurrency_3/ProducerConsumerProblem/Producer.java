package Concurrency.Concurrency_3.ProducerConsumerProblem;

import java.util.Queue;

public class Producer implements Runnable{

    private Queue<Object> queue;
    private int maxSize;
    private String name;

    Producer(Queue<Object> queue, int maxSize, String name) {
        this.queue = queue;
        this.maxSize = maxSize;
        this.name = name;
    }

    //PROBLEM STATEMENT

//    @Override
//    public void run() {
//        while (true) {
//            if (queue.size() < maxSize) {
//                System.out.println("Producer - " + this.name + " with size " + this.queue.size());
//                queue.add(new Object());
//            }
//        }
//    }

    //soln with synchronzied - not required
    @Override
    public void run() {
        while (true) {
            synchronized (queue) {
                if (queue.size() < maxSize) {
                    System.out.println("Producer - " + this.name + " with size " + this.queue.size());
                    queue.add(new Object());
                }
            }
        }
    }
}
