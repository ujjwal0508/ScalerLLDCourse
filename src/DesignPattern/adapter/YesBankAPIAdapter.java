package DesignPattern.adapter;


import DesignPattern.adapter.thirdparty.yesbank.YesBankAPI;

public class YesBankAPIAdapter implements BankAPIAdapter {
    private YesBankAPI yesBankAPI = new YesBankAPI();

    @Override
    public double getBalance(String accountNumber) {
        return 10;
    }

    @Override
    public boolean sendMoney(String fromAccount, String toAccount, double amount) {
        return false;
    }
}
