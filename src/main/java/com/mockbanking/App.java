package com.mockbanking;

public class App {
    public static void main(String[] args) {
        
        AccountService accountService = new AccountService();

        accountService.createAccount(1, 1000);
        System.out.println(accountService.checkBalance(1));
        accountService.withdraw(1, 100);
        System.out.println(accountService.checkBalance(1));
        accountService.deposit(1, 300);
        System.out.println(accountService.checkBalance(1));
    
    }
}
