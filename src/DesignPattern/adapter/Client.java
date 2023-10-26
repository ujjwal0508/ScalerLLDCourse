package DesignPattern.adapter;

public class Client {
    public static void main(String[] args ) throws Exception {
        PhonePe phonePe = new PhonePe(new ICICIBankAPIAdapter());
        System.out.println(phonePe.doSomething());
    }
}
