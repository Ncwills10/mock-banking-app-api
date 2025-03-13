package com.mockbanking;

import java.sql.SQLException;

public class AccountService {
    
    private CurrentAccountFactory currentAccountFactory = new CurrentAccountFactory();
    private AccountDAO accountDAO = new AccountDAO();

    public void createAccount(int id, int initialBalance) {

        Account currentAccount = null;

        currentAccount = currentAccountFactory.createAccount(id, initialBalance);

        try {
            
            accountDAO.save(currentAccount);

        } catch (SQLException e) {

            // Error must be caught. Leaving empty because the error message was generated in a lower layer.

        }

        System.out.println("Account created successfully!");

    }

    public void withdraw(int id, int amount) {

        Account currentAccount = null;

        try {
            
            currentAccount = accountDAO.getById(id);

        } catch (SQLException e) {

        }

        try {
            
            currentAccount.withdraw(amount);

        } catch (IllegalArgumentException e) {

        }

        try {
            
            accountDAO.updateBalance(currentAccount);

        } catch (SQLException e) {

        }

        System.out.println("Withdrawal successful. New balance: " + currentAccount.getBalance());

    }

    public void deposit(int id, int amount) {

        Account currentAccount = null;

        try {
            
            currentAccount = accountDAO.getById(id);

        } catch (SQLException e) {

        }
            
        currentAccount.deposit(amount);

        try {
            
            accountDAO.updateBalance(currentAccount);

        } catch (SQLException e) {

        }

        System.out.println("Deposit successful. New balance: " + currentAccount.getBalance());
        
    }

    public int checkBalance(int id) {

        Account currentAccount = null;

        try {
            
            currentAccount = accountDAO.getById(id);

        } catch (SQLException e) {

        }

        return currentAccount.getBalance();

    }
}