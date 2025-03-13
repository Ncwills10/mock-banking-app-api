package com.mockbanking;

public class CurrentAccount implements Account {

    private int id;
    private int balance;

    public CurrentAccount(int id, int initialBalance) {
        
        this.id = id;
        this.balance = initialBalance;

    } 

    @Override
    public int getBalance() {

        return this.balance;

    }

    @Override
    public int getId() {

        return this.id;

    }

    @Override
    public void withdraw(int amount) {

        if (amount > this.balance) throw new IllegalArgumentException("Balance not enough");
        else this.balance -= amount;

    }

    @Override
    public void deposit(int amount) {

        this.balance += amount;

    }
}
