package com.fitech;

public class CheckingAccount extends BankAccount{

    public boolean deposit(double amount) {
        return super.deposit(amount - 1);
    }

    public boolean withdrawal(double amount) {
        return super.withdrawal(amount + 1);
    }

}