package BankAppTest;

import BankApp.Account;
import exceptions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AccountTest {
    private Account johnAccount;

    @BeforeEach
    public void doTheseFirst() {
        johnAccount = new Account("firstName", "lastName", "correct");
    }

    @AfterEach
    public void doTheseLast() {
        Account.resetAccountNumber();
    }

    @Test
    public void testDeposit() {
        assertEquals(0, johnAccount.checkBalance(1000000001,"correct"));

        johnAccount.deposit(1000000001, 5000);
        assertEquals(5000, johnAccount.checkBalance(1000000001, "correct"));
    }

    @Test
    public void testCanDeposit5kTwice_AndHaveCorrectBalance() {
        johnAccount.deposit(1000000001, 5000);
        assertEquals(5000, johnAccount.checkBalance(1000000001, "correct"));

        johnAccount.deposit(1000000001, 5000);
        assertEquals(10000, johnAccount.checkBalance(1000000001, "correct"));
    }

    @Test
    public void testCanWithdraw() {
        johnAccount.deposit(1000000001, 5000);
        assertEquals(5000, johnAccount.checkBalance(1000000001, "correct"));

        johnAccount.withdraw(1000000001, 2000, "correct");
        assertEquals(3000, johnAccount.checkBalance(1000000001, "correct"));
    }

    @Test
    public void testWithdrawal() {
        johnAccount.deposit(1000000001, 5000);
        assertEquals(5000, johnAccount.checkBalance(1000000001, "correct"));

        johnAccount.withdraw(1000000001, 2000, "correct");
        assertEquals(3000, johnAccount.checkBalance(1000000001, "correct"));
    }

    @Test
    public void testDepositNegativeAmount_throwsException() {
        johnAccount.deposit(1000000001, 5000);
        assertEquals(5000, johnAccount.checkBalance(1000000001, "correct"));

        assertThrows(NegativeAmountException.class, () -> johnAccount.deposit(1000000001, -3400));
    }

    @Test
    public void testWithdrawalAmountGreaterThanBalance_throwsException() {
        johnAccount.deposit(1000000001, 5000);
        assertEquals(5000, johnAccount.checkBalance(1000000001, "correct"));

        assertThrows(InsufficientFundsException.class, () -> johnAccount.withdraw(1000000001, 7000, "Incorrect"));
    }

    @Test
    public void testIncorrectPin_throwsException() {
        johnAccount.deposit(1000000001, 5000);
        assertEquals(5000, johnAccount.checkBalance(1000000001, "correct"));

        assertThrows(IncorrectPinException.class, () -> johnAccount.withdraw(1000000001, 5000, "Incorrect"));
    }

    @Test
    public void testAccountNameIsCorrect() {
        assertEquals("firstName lastName", johnAccount.getName());
    }

    @Test
    public void testAccountNumberIsCorrect() {
//        johnAccount.setNumber(1000000001);
        assertEquals(1000000001, johnAccount.getNumber());
        Account.resetAccountNumber();
    }
}
