package com.fitech;

public class SavingAccount extends BankAccount{
    private int transactionCount = 3;
    private int count = 10;

    public boolean checkEarnMonthlyInterest() {
        count--;
        return count <= 0;
    }

    public void chargeCount() {
        transactionCount--;
    }

    public boolean deposit(double amount) {
        if (checkEarnMonthlyInterest()) {
            earnMonthlyInterest();
        }
        if (transactionCount != 0) {
            chargeCount();
            return super.deposit(amount);
        } else {
            return super.deposit(amount -1);
        }
    }

    public boolean withdrawal(double amount) {
        if (checkEarnMonthlyInterest()) {
            earnMonthlyInterest();
        }
        if (transactionCount != 0) {
            chargeCount();
            return super.withdrawal(amount);
        } else {
            return super.withdrawal(amount + 1);
        }
    }

    public void updateTransactionCount() {
        transactionCount = 3;
    }

    public void earnMonthlyInterest() {
        double rate = 0.1;
        balance += balance*rate;
        count = 30;
        updateTransactionCount();
    }
}