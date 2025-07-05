package BankApp;

import exceptions.*;

public class Account {
    private static int nextAccountNumber = 1000000000;

    private int balance;
    private String pin;
    private String name;
    private int number;

    public Account(String firstName, String lastName, String pin) {
        this.pin = pin;
        name =  firstName + " " + lastName;
        number = ++nextAccountNumber;
    }

    public int checkBalance(int accountNumber, String pin) {
        validateAccountNumber(accountNumber);
        validatePin(pin);
        return balance;
    }

    public void deposit(int accountNumber, int amount) {
        validateAccountNumber(accountNumber);
        validateDepositAmount(amount);
        balance = balance + amount;
    }

    public void withdraw(int accountNumber, int amount, String pin) {
        validateAccountNumber(accountNumber);
        validateWithdrawalAmount(amount);
        validatePin(pin);
        balance =  balance - amount;
    }

    private void validateAccountNumber(int accountNumber) {
        boolean accountIsInvalid = accountNumber != number;
        if(accountIsInvalid) throw new InvalidAccountException();
    }

    private void validatePin(String pin) {
        boolean pinIsIncorrect = !this.pin.equals(pin);
        if(pinIsIncorrect) throw new IncorrectPinException();
    }

    private void validateWithdrawalAmount(int amount) {
        boolean amountGreaterThanBalance = amount > balance;
        if (amountGreaterThanBalance) throw new InsufficientFundsException();
    }

    private void validateDepositAmount(int amount) {
        boolean amountLessThanZero = amount < 0;
        if (amountLessThanZero) throw new NegativeAmountException();
    }
    
    public String getName() {
        return name;
    }

    public void setNumber(int accountNumber) {
        number = accountNumber;
    }

    public int getNumber() {
        return number;
    }

    public static void resetAccountNumber() {
        nextAccountNumber = 1000000000;
    }
}
