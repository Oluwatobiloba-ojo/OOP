import Account.Account;
import Account.Bank;
import Account.exceptions.InvalidAccount;
import Account.exceptions.IncorrectPinExceptions;
import Account.exceptions.InsufficientAmountException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BankTest {

    @Test
    public void testThatBankCanCreateAccountForOneAndTotalAccount_BeOne(){
        Bank bank = new Bank();
        Account account1 = bank.createAccountFor("FirstName", "LastName", "correctPin");
        assertEquals(1, bank.getTotalNumberOfAccounts());
        assertEquals("1045671", account1.getAccountNumber());
    } @Test
    public void testThatBankCanCreateTwoAccountForTwoCustomerAndTotalAccount_BeTwo(){
        Bank bank = new Bank();
        Account account1 = bank.createAccountFor("FirstName", "LastName", "correctPin");
        Account account2 = bank.createAccountFor("FirstName", "LastName", "correctPin");
        assertEquals(2, bank.getTotalNumberOfAccounts());
        assertEquals("1045671", account1.getAccountNumber());
        assertEquals("1045672", account2.getAccountNumber());
    }@Test
    public void testThatBankCanCreateTwoAccountAndFindCustomerAccount(){
        Bank bank = new Bank();
        Account account1 = bank.createAccountFor("FirstName", "LastName", "correctPin");
        Account account2 = bank.createAccountFor("FirstName", "LastName", "correctPin");
        assertEquals(2, bank.getTotalNumberOfAccounts());
        assertEquals(account1, bank.findAccount("1045671"));
        assertEquals(account2, bank.findAccount("1045672"));
    }@Test
    public void testThatBankCanCreateTwoAccountAndFindCustomerAccountWithWrongAccountNumberThrowsException(){
        Bank bank = new Bank();
        Account account1 = bank.createAccountFor("FirstName", "LastName", "correctPin");
        Account account2 = bank.createAccountFor("FirstName", "LastName", "correctPin");
        assertEquals(2, bank.getTotalNumberOfAccounts());
        assertEquals(account1, bank.findAccount("1045671"));
        assertThrows(InvalidAccount.class, ()-> bank.findAccount("1045675"));
    }@Test
    public void testThatBankCanCreateTwoAccountAndFindCustomerOneAccountCanDeposit1kIntoItCustomerAccountAndBalanceIs1k(){
        Bank bank = new Bank();
        Account account1 = bank.createAccountFor("FirstName", "LastName", "correctPin");
        Account account2 = bank.createAccountFor("FirstName", "LastName", "correctPin");
        assertEquals(2, bank.getTotalNumberOfAccounts());
        bank.deposit(1000, "1045671");
        assertEquals(1000, account1.checkBalanceWith("correctPin"));
    }@Test
    public void testThatBankCanCreateTwoAccountAndFindCustomerOneAccountCanDeposit1kIntoItCustomerAccountAndBalanceIs1kWithWrongPin() {
    Bank bank = new Bank();
    Account account1 = bank.createAccountFor("FirstName", "LastName", "correctPin");
    Account account2 = bank.createAccountFor("FirstName", "LastName", "correctPin");
    assertEquals(2, bank.getTotalNumberOfAccounts());
    assertThrows(InvalidAccount.class, () -> bank.deposit(1000, "1"));
    }@Test
    public void testThatBankCanCreateOneAccountAndDeposit1kToAccountAndWithdraw5h() {
    Bank bank = new Bank();
    Account account1 = bank.createAccountFor("FirstName", "LastName", "correctPin");
    assertEquals(1, bank.getTotalNumberOfAccounts());
    bank.deposit(1000, "1045671");
    bank.withdraw(500, "1045671", "correctPin");
    assertEquals(500, account1.checkBalanceWith("correctPin"));
    }@Test
    public void testThatBankCanCreateOneAccountAndDeposit1kToAccountAndWithdraw5hWithIncorrectPinThrowsException() {
    Bank bank = new Bank();
    Account account1 = bank.createAccountFor("FirstName", "LastName", "correctPin");
    assertEquals(1, bank.getTotalNumberOfAccounts());
    bank.deposit(1000, "1045671");
    assertThrows(IncorrectPinExceptions.class, () -> bank.withdraw(500, "1045671", "wrongPin"));
    }@Test
    public void testThatBankCanCreateTwoAccountAndDeposit1kToAccountOneAndTransfer500hToSecondAccount() {
    Bank bank = new Bank();
    Account account1 = bank.createAccountFor("FirstName", "LastName", "correctPin");
    Account account2 = bank.createAccountFor("FirstName", "LastName", "correctPin");
    bank.deposit(1000, "1045671");
    bank.transfer("1045671", "1045672", "correctPin", 500);
    assertEquals(2, bank.getTotalNumberOfAccounts());
    assertEquals(500, account1.checkBalanceWith("correctPin"));
    assertEquals(500, account2.checkBalanceWith("correctPin"));
    }@Test
    public void testThatBankCanCreateTwoAccountAndDeposit2kToAccountOneAndTransfer2500hToSecondAccountToThrowInsufficient() {
    Bank bank = new Bank();
    Account account1 = bank.createAccountFor("FirstName", "LastName", "correctPin");
    Account account2 = bank.createAccountFor("FirstName", "LastName", "correctPin");
    bank.deposit(2000, "1045671");
    assertThrows(InsufficientAmountException.class,() -> bank.transfer("1045671", "1045672", "correctPin", 2500));
    assertEquals(2, bank.getTotalNumberOfAccounts());
    }

}
