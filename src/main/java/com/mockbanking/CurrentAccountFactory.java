package com.mockbanking;

public class CurrentAccountFactory implements AccountFactory {
    
    @Override
    public Account createAccount(int id, int initialBalance) {

        return new CurrentAccount(id, initialBalance);

    }
}
