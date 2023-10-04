package Advanced_Java.StreamsAndLambdas.Lambda;

public class Client {
    public static void main(String[] args) {

//        PrintHi printHi = new PrintHi();
//        Thread t = new Thread(printHi);
//        t.start();

//        Runnable r = () -> {
//            System.out.println("printing from lambda");
//        };
//        Thread t = new Thread(r);
//        t.start();

//        Thread t = new Thread(() -> {
//            System.out.println("printing from lambda 2");
//        });
//        t.start();

        Thread t = new Thread(() -> System.out.println("printing from lambda 3"));
        t.start();

    }
}
