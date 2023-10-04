package Advanced_Java.StreamsAndLambdas.AdderSubtractorPackage;

import Advanced_Java.StreamsAndLambdas.AdderSubtractorPackage.Count;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class AdderSubtractor {

    public static void main(String[] args) throws InterruptedException {
        Count count = new Count();
        Lock lock = new ReentrantLock();

        Runnable adder = () -> {
            for (int i = 1; i <= 10000; i++) {
                lock.lock();
                count.value += i;
                lock.unlock();
            }
        };
        Runnable subtractor = () -> {
            for (int i = 1; i <= 10000; i++) {
                lock.lock();
                count.value -= i;
                lock.unlock();
            }
        };
        Thread t1 = new Thread(adder);
        t1.start();

        Thread t2 = new Thread(subtractor);
        t2.start();

        t1.join();
        t2.join();
        System.out.println(count.value);
    }
}
