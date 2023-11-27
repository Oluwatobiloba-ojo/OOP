package Account;

import java.util.Scanner;

public class BankApp {
    static Bank bank = new Bank();

    public static void main(String[] args) {
        bankMain();
    }

    private static void bankMain() {
        String main = """
                ==================================
                1 -> Create Account
                2 -> Deposit Account
                3 -> Transfer Account
                4 -> Check Balance
                5 -> Withdraw
                ===================================
                """;
        String response = input(main);
        bankOperation(response);
    }

    private static void bankOperation(String response) {
        switch (response){
            case "1" -> createAccount();
            case "2" -> depositTo();
            case "3" -> transferTo();
            case "4" -> getBalance();
            case "5" -> withdraw();
        }
    }

    private static void withdraw() {
        String accountNumber = input("Enter your account number ");
        String pin = input("Enter your pin");
        int amount = Integer.parseInt(input("Enter the amount you want to withdraw"));
        try {
            bank.withdraw(amount, accountNumber, pin);
            System.out.println(bank.findAccount(accountNumber));
            bankMain();
        }catch (Exception exception){
            System.out.println(exception.getMessage());
            bankMain();
        }
    }

    private static void getBalance() {
        String pin = input("Enter your pin ");
        String accountNumber = input("Enter your account number ");
        try{
            Account account = bank.findAccount(accountNumber);
            System.out.println(account.checkBalanceWith(pin));
            bankMain();
        }catch (Exception exception){
            System.out.println(exception.getMessage());
            bankMain();
        }
    }

    private static void transferTo() {
        String senderAccount = input("Enter your account number");
        String receiverAccount = input("Enter the receiver account number");
        int amount = Integer.parseInt(input("Enter the amount you want to transfer"));
        String pin = input("Enter your pin");
        try {
            bank.transfer(senderAccount, receiverAccount,pin, amount);
            System.out.println("Transfer Successfully done");
            System.out.println(bank.findAccount(senderAccount));
            bankMain();
        }catch (Exception exception){
            System.out.println(exception.getMessage());
            bankMain();
        }
    }

    private static void depositTo() {
        String accountNumber = input("Enter your account number");
        int amount = Integer.parseInt(input("Enter the amount to deposit into"));
        try {
            bank.deposit(amount, accountNumber);
            System.out.println(bank.findAccount(accountNumber));
            System.out.println("Deposit Successfully done");
            bankMain();
        }catch (Exception exception){
            System.out.println(exception.getMessage());
            bankMain();
        }
    }

    private static void createAccount() {
        String firstName = input("Enter your first name");
        String lastName = input("Enter your last name");
        String pin = input("Enter your pin");
        Account account = bank.createAccountFor(firstName, lastName, pin);
        System.out.println(account);
        bankMain();
    }

    public static String input(String main) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(main);
        return scanner.nextLine();
    }
}
