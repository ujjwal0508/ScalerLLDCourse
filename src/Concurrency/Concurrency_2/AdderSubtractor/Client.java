package Concurrency.Concurrency_2.AdderSubtractor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Client {
    public static void main(String[] args) {
        Count count = new Count();

        Adder adder = new Adder(count);
        Subtractor subtractor = new Subtractor(count);
        ExecutorService executorService = Executors.newCachedThreadPool();

        executorService.execute(adder);
        executorService.execute(subtractor);

        executorService.close();

        System.out.println(count.value);
    }



}
