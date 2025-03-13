package com.mockbanking;

public interface Account {
    
    int getBalance();
    int getId();
    void withdraw(int amount);
    void deposit(int amount);

}