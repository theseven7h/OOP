package BankApp;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private List<Account> accounts = new ArrayList<>();

    public Account createAccount(String firstName, String lastName, String pin) {
        Account account = new Account(firstName, lastName, pin);
        accounts.add(account);
        return account;
    }

    public Account findAccountBy(int accountNumber) {
        for(Account account: accounts)
            if(accountNumber == getAccountNumber(account))
                return account;
        return null;
    }

    public int getBalance(int accountNumber, String pin) {
        Account account = findAccountBy(accountNumber);
        return account.checkBalance(accountNumber, pin);
    }

    public void deposit(int accountNumber, int amount) {
        Account account = findAccountBy(accountNumber);
        account.deposit(accountNumber, amount);
    }

    public void withdraw(int accountNumber, int amount, String pin) {
        Account account = findAccountBy(accountNumber);
        account.withdraw(accountNumber, amount, pin);
    }

    public void transfer(int fromAccountNumber, int toAccountNumber, int amount, String pin) {
        findAccountBy(fromAccountNumber).withdraw(fromAccountNumber, amount, pin);
        findAccountBy(toAccountNumber).deposit(toAccountNumber, amount);
    }

    public int getAccountNumber(Account account) {
        return account.getNumber();
    }
}
