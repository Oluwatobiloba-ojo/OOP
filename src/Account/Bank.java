package Account;

import Account.exceptions.InvalidAccount;

import java.util.ArrayList;

public class Bank {

    private ArrayList<Account> accounts = new ArrayList<>();
    private int totalNumberOfAccount;
    public Account createAccountFor(String firstName, String lastName, String correctPin) {
        totalNumberOfAccount++;
        String fullName = concatenateName(firstName, lastName);
        String accountNumber = generateAccounts();
        Account account = new Account(fullName, accountNumber, correctPin);
        accounts.add(account);
        return account;
    }

    private String generateAccounts() {
        return "104567" + totalNumberOfAccount;
    }

    private String concatenateName(String firstName, String lastName) {
        return firstName + " " + lastName;
    }

    public int getTotalNumberOfAccounts() {
        return totalNumberOfAccount;
    }

    public Account findAccount(String number) {
        for (Account account : accounts){
            if (account.getAccountNumber().equals(number)) return account;
        }
        throw new InvalidAccount("Account does not exists");
    }

    public void deposit(int amount, String accountNumber) {
        Account account = findAccount(accountNumber);
        account.deposit(amount);
    }

    public void withdraw(int amount, String number, String pin) {
        Account account = findAccount(number);
        account.withdraw(amount, pin);
    }

    public void transfer(String sender, String receiver, String pin, int amount) {
        Account senderAccount = findAccount(sender);
        Account receiverAccount = findAccount(receiver);
        senderAccount.withdraw(amount, pin);
        receiverAccount.deposit(amount);
    }
}
