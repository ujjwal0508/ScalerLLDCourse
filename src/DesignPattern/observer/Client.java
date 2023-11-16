package DesignPattern.observer;

public class Client {

    public static void main(String[] args) {
        Flipkart flipkart = Flipkart.getInstance();
        EmailSender emailSender = new EmailSender();
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        AnalyticsSender analyticsSender = new AnalyticsSender();
        InventoryManagement inventoryManagement = new InventoryManagement();

        flipkart.orderPlaced();
    }
}
