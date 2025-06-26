package BankApp;

public class Account {
    private int balance;
    private String userPin;

    public Account(String userPin) {
        this.userPin = userPin;
    }

    public int getBalance() {
        return balance;
    }

    public void deposit(int amount) {
        boolean amountGreaterThanZero = amount > 0;
        if (amountGreaterThanZero) balance = balance + amount;
    }

    public void withdraw(int amount, String pin) {
        boolean amountGreaterThanZero = amount > 0, balanceGreaterThanOrEqualsAmount = balance >= amount, pinIsCorrect = pin.equals(userPin);
        if(amountGreaterThanZero && balanceGreaterThanOrEqualsAmount && pinIsCorrect) balance =  balance - amount;
    }
}
