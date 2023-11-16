package DesignPattern.observer;

public class InventoryManagement implements OrderPlacedSubscriber{

    InventoryManagement(){
        Flipkart flipkart = Flipkart.getInstance();
        flipkart.registerSubscriber(this);
    }

    @Override
    public void announceOrderPlaced() {
        System.out.println("inventory managed");
    }
}
