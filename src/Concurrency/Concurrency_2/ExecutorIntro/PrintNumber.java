package Concurrency.Concurrency_2.ExecutorIntro;

public class PrintNumber implements Runnable{
    int numToPrint;

    PrintNumber(int num){
        this.numToPrint = num;
    }

    public void run() {
        System.out.println("I am printing number " + numToPrint + " by thread- " + Thread.currentThread().getName());
    }
}
