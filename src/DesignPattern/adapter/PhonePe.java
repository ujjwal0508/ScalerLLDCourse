package DesignPattern.adapter;

import DesignPattern.adapter.thirdparty.yesbank.YesBankAPI;

public class PhonePe {

//    YesBankAPI yesBankAPI = new YesBankAPI();
    private BankAPIAdapter bankAPI;

    public PhonePe(BankAPIAdapter bankAPI) {
        this.bankAPI = bankAPI;
    }

    double doSomething() throws InterruptedException {
        double currentBalance = bankAPI.getBalance("accountNumber");
        return currentBalance * 2;
    }
}
