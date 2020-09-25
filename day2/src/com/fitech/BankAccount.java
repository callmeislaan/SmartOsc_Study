package com.fitech;

public class BankAccount {

    private double balance;

    public BankAccount() {
    }

    public BankAccount(double balance) {
        this.balance = balance;
    }

    public void deposit() {

    }

    public void withdraw() {

    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "balance=" + balance +
                '}';
    }
}
