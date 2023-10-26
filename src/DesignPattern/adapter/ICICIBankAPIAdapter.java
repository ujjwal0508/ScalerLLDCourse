package DesignPattern.adapter;


import DesignPattern.adapter.thirdparty.icicibank.IciciBankAPI;

public class ICICIBankAPIAdapter implements BankAPIAdapter {
    private IciciBankAPI iciciBankAPI = new IciciBankAPI();

    @Override
    public double getBalance(String accountNumber) {
        return 20;
    }

    @Override
    public boolean sendMoney(String fromAccount, String toAccount, double amount) {
        return false;
    }
}
