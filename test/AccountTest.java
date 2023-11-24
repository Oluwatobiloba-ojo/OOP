import Account.Account;
import Account.exceptions.IncorrectPinExceptions;
import Account.exceptions.InsufficientAmountException;
import Account.exceptions.InvalidAmountException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AccountTest {
    Account account;
    @BeforeEach
    public void startAllTestWithThis(){
        account = new Account("AccountName", "AccountNumber", "correctPin");
    }

    @Test
    public void testThatAccountCanDeposit1kAndCheckBalance1K(){
        account.deposit(1000);
        assertEquals(1000,account.checkBalanceWith("correctPin"));
    }  @Test
    public void testThatICanDeposit1k_2kAndCheckBalance3K(){
        account.deposit(1000);
        account.deposit(2000);
        assertEquals(3000,account.checkBalanceWith("correctPin"));
    }  @Test
    public void testThatWhenIDepositMinus500ThrowAnExceptionInvalidAmount(){
        assertThrows(InvalidAmountException.class, () -> account.deposit(-500));
        assertEquals(0,account.checkBalanceWith("correctPin"));
    } @Test
    public void testThatWhenIDeposit1000AndCheckBalanceWithAWrongPinExceptionIsThrown(){
        account.deposit(1000);
        assertThrows(IncorrectPinExceptions.class, () -> account.checkBalanceWith("wrongPin"));
    } @Test
    public void testThatWhenIDeposit1000AndWithdraw500WithACorrectPinCheckBalanceIs500(){
        account.deposit(1000);
        account.withdraw(500, "correctPin");
       assertEquals(500, account.checkBalanceWith("correctPin"));
    } @Test
    public void testThatWhenIDeposit1000AndWantToWithdraw_Minus500ThrowsInvalidAmountException(){
        account.deposit(1000);
        assertThrows(InvalidAmountException.class, ()-> account.withdraw(-500, "correctPin"));
        assertEquals(1000, account.checkBalanceWith("correctPin"));
    }@Test
    public void testThatWhenIDeposit1000AndWantToWithdraw500WithAnIncorrectPin(){
        account.deposit(1000);
        assertThrows(IncorrectPinExceptions.class, ()-> account.withdraw(500, "wrongPin"));
        assertEquals(1000, account.checkBalanceWith("correctPin"));
    }@Test
    public void testThatWhenIDeposit1000AndWantToWithdraw1500WithACorrectPinThrowsInsufficientAmountException(){
        account.deposit(1000);
        assertThrows(InsufficientAmountException.class, ()-> account.withdraw(1500, "correctPin"));
        assertEquals(1000, account.checkBalanceWith("correctPin"));
    }

}
