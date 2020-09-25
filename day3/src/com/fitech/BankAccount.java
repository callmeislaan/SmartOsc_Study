package com.fitech;

public class BankAccount {
    protected double balance;

    public boolean deposit(double amount) {
        balance += amount;
        return true;
    }

    public boolean withdrawal(double amount) {
        if (amount > balance) {
            return false;
        } else {
            balance -= amount;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "balance=" + balance +
                '}';
    }
}
