package Concurrency.Concurrency_2.ExecutorIntro;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(10);

        for(int i = 1;i <=100;i++) {

            if(i == 5 || i == 11 || i == 20){
                System.out.println("wait");
            }

            PrintNumber pn = new PrintNumber(i);
            executorService.execute(pn);
        }

        executorService.shutdown();



    }
}
