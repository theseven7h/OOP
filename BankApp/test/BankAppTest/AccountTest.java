package BankAppTest;

import BankApp.Account;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AccountTest {
    private Account johnAccount;

    @BeforeEach
    public void doTheseFirst() {
        johnAccount = new Account("correct");
    }

    @Test
    public void testDeposit() {
        assertEquals(0, johnAccount.getBalance());

        johnAccount.deposit(5000);
        assertEquals(5000, johnAccount.getBalance());
    }

    @Test
    public void testCanDeposit5kTwice_AndHaveCorrectBalance() {
        johnAccount.deposit(5000);
        assertEquals(5000, johnAccount.getBalance());

        johnAccount.deposit(5000);
        assertEquals(10000, johnAccount.getBalance());
    }

    @Test
    public void testNegativeDepositDoesNotChangeBalance() {
        johnAccount.deposit(5000);
        assertEquals(5000, johnAccount.getBalance());

        johnAccount.deposit(-2000);
        assertEquals(5000, johnAccount.getBalance());
    }

    @Test
    public void testCanWithdraw() {
        johnAccount.deposit(5000);
        assertEquals(5000, johnAccount.getBalance());

        johnAccount.withdraw(2000, "correct");
        assertEquals(3000, johnAccount.getBalance());
    }

    @Test
    public void testWithdrawNegativeAmount_DoesNotChangeBalance() {
        johnAccount.deposit(5000);
        assertEquals(5000, johnAccount.getBalance());

        johnAccount.withdraw(-2000, "correct");
        assertEquals(5000, johnAccount.getBalance());
    }

    @Test
    public void testWithdrawAmountGreaterThanBalance_DoesNotChangeBalance() {
        johnAccount.deposit(5000);
        assertEquals(5000, johnAccount.getBalance());

        johnAccount.withdraw(7000, "correct");
        assertEquals(5000, johnAccount.getBalance());
    }

    @Test
    public void testWithdrawWithIncorrectPin_DoesNotChangeBalance() {
        johnAccount.deposit(5000);
        assertEquals(5000, johnAccount.getBalance());

        johnAccount.withdraw(7000, "Incorrect");
        assertEquals(5000, johnAccount.getBalance());
    }

    @Test
    public void testWithdrawal() {
        johnAccount.deposit(5000);
        assertEquals(5000, johnAccount.getBalance());

        johnAccount.withdraw(2000, "correct");
        assertEquals(3000, johnAccount.getBalance());
    }
}
