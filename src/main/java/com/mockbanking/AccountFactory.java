package com.mockbanking;

public interface AccountFactory {

    Account createAccount(int id, int initialBalance);

}