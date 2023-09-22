package Concurrency.Concurrency_3.SynchronizedMethod;

public class Count {

    int value;

    synchronized void incrementValue(int offset){
        this.value += offset;
    }

    int getValue(){
        return this.value;
    }
}
