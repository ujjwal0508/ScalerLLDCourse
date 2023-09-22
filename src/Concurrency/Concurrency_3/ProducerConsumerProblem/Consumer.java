package Concurrency.Concurrency_3.ProducerConsumerProblem;

import java.util.Queue;

public class Consumer implements Runnable {

    private Queue<Object> queue;
    private int maxSize;

    private String name;

    Consumer(Queue<Object> queue, int maxSize, String name) {
        this.queue = queue;
        this.maxSize = maxSize;
        this.name = name;
    }

    //PROBLEM STATEMENT

//    @Override
//    public void run() {
//        while (true) {
//            if (queue.size() < maxSize) {
//                System.out.println("Consumer - " + this.name + " with size " + this.queue.size());
//                queue.remove();
//            }
//        }
//    }

    //SOLN WITH SYNCHRONIZED - NOT SATISFYING
    @Override
    public void run() {
        while (true) {
            synchronized (queue) {
                if (queue.size() > 0) {
                    System.out.println("Consumer - " + this.name + " with size " + this.queue.size());
                    queue.remove();
                }
            }
        }
    }
}
