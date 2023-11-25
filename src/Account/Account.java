package Account;

import Account.exceptions.IncorrectPinExceptions;
import Account.exceptions.InsufficientAmountException;
import Account.exceptions.InvalidAmountException;

public class Account {
    private int balance;
    private String pin;
    private String accountNumber;
    private String name;


    public Account(String name, String accountNumber, String pin) {
        this.name = name;
        this.pin = pin;
        this.accountNumber = accountNumber;
    }

    public void deposit(int amount) {
        validate(amount);
        balance += amount;
    }

    private void validate(int amount) {
        if (amount < 0) throw new InvalidAmountException("Negative amount can not be deposited");
    }

    public int checkBalanceWith(String pin) {
        validate(pin);
        return balance;
    }
    public void validate(String pin){
        if (!pin.equals(this.pin)) throw new IncorrectPinExceptions("Wrong pin");
    }

    public void withdraw(int amount, String pin) {
        validate(amount);
        validate(pin);
        checkInsufficientOf(amount);
        balance -= amount;
    }

    private void checkInsufficientOf(int amount) {
        if (amount > balance) throw new InsufficientAmountException("Amount too high");
    }

    public String getAccountNumber() {
        return accountNumber;
    }
    public String toString(){
        return String.format("""
                ====================================
                Account Name: %s
                Account Number: %s
                Account Balance: %s
                Account pin: Unavailable
                ====================================
                """,name, accountNumber, balance);
    }
}
