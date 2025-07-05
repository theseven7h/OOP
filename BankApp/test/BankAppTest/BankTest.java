package BankAppTest;

import BankApp.Account;
import BankApp.Bank;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BankTest {
    private Bank bank;
    private Account myAccount;

    @BeforeEach
    public void setUp() {
        bank = new Bank();
        myAccount = bank.createAccount("firstName", "lastName", "1234");
    }

    @AfterEach
    public void tearDown() {
        Account.resetAccountNumber();
    }

    @Test
    public void testBankCreateAccount_setsAccountNumber() {
        assertEquals(1000000001, bank.getAccountNumber(myAccount));
    }

    @Test
    public void testBankCanGetCustomerBalance() {
        assertEquals(0, bank.getBalance(1000000001, "1234"));
    }

    @Test
    public void testBankCanDeposit_forAccount() {
        assertEquals(0, bank.getBalance(1000000001, "1234"));

        bank.deposit(1000000001, 5000);
        assertEquals(5000, bank.getBalance(1000000001, "1234"));
    }

    @Test
    public void testBankCanWithdraw_forAccount() {
        assertEquals(0, bank.getBalance(1000000001, "1234"));

        bank.deposit(1000000001, 5000);
        assertEquals(5000, bank.getBalance(1000000001, "1234"));

        bank.withdraw(1000000001, 2000, "1234");
        assertEquals(3000, bank.getBalance(1000000001, "1234"));
        assertEquals(1000000001, myAccount.getNumber());
    }

    @Test
    public void testBankCanTransfer_betweenAccounts_andBalancesAreCorrect() {
        Account myAccount2 = bank.createAccount("james", "tauri", "1234");
        Account myAccount3 = bank.createAccount("tauri", "m", "1234");

        bank.deposit(1000000002, 2_000_000);
        assertEquals(2_000_000, bank.getBalance(1000000002, "1234"));
        assertEquals(0, bank.getBalance(1000000003, "1234"));

        bank.transfer(1000000002, 1000000003, 1_300_000, "1234");

        assertEquals(1_300_000, bank.getBalance(1000000003, "1234"));
        assertEquals(700_000, bank.getBalance(1000000002, "1234"));
    }
}
