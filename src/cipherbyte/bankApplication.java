package cipherbyte;

import java.util.ArrayList;
import java.util.Scanner;

class Account 
{
    private String accountNumber;
    private String accountHolder;
    private double balance;

    public Account(String accountNumber, String accountHolder) 
    {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = 0.0;
    }

    public String getAccountNumber() 
    {
        return accountNumber;
    }

    public String getAccountHolder() 
    {
        return accountHolder;
    }

    public double getBalance() 
    {
        return balance;
    }

    public void deposit(double amount) 
    {
        if (amount > 0) 
        {
            balance += amount;
            System.out.println("Deposited: $" + amount);
        } 
        else 
        {
            System.out.println("Deposit amount must be positive.");
        }
    }

    public boolean withdraw(double amount) 
    {
        if (amount > 0 && amount <= balance) 
        {
            balance -= amount;
            System.out.println("Withdrew: $" + amount);
            return true;
        } 
        else 
        {
            System.out.println("Insufficient funds or invalid amount.");
            return false;
        }
    }

    public void transfer(Account targetAccount, double amount) 
    {
        if (withdraw(amount)) 
        {
            targetAccount.deposit(amount);
            System.out.println("Transferred: $" + amount + " to " + targetAccount.getAccountHolder());
        }
    }
}

class Bank 
{
    private ArrayList<Account> accounts;

    public Bank() 
    {
        accounts = new ArrayList<>();
    }

    public void createAccount(String accountNumber, String accountHolder) 
    {
        accounts.add(new Account(accountNumber, accountHolder));
        System.out.println("Account created for " + accountHolder + " with account number: " + accountNumber);
    }

    public Account findAccount(String accountNumber) 
    {
        for (Account account : accounts) 
        {
            if (account.getAccountNumber().equals(accountNumber)) 
            {
                return account;
            }
        }
        return null;
    }

    public void listAccounts() 
    {
        if (accounts.isEmpty()) 
        {
            System.out.println("No accounts available.");
        } 
        else 
        {
            System.out.println("Listing all accounts:");
            for (Account account : accounts) 
            {
                System.out.println("Account Holder: " + account.getAccountHolder() + ", Account Number: " + account.getAccountNumber() + ", Balance: $" + account.getBalance());
            }
        }
    }
}

public class bankApplication 
{
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        Bank bank = new Bank();
        int choice;

        do {
            System.out.println("\nBankY - Banking System");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit Funds");
            System.out.println("3. Withdraw Funds");
            System.out.println("4. Transfer Funds");
            System.out.println("5. List Accounts");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) 
            {
                case 1:
                    System.out.print("Enter account number: ");
                    String accountNumber = scanner.nextLine();
                    System.out.print("Enter account holder name: ");
                    String accountHolder = scanner.nextLine();
                    bank.createAccount(accountNumber, accountHolder);
                    break;

                case 2:
                    System.out.print("Enter account number: ");
                    String depositAccountNumber = scanner.nextLine();
                    Account depositAccount = bank.findAccount(depositAccountNumber);
                    if (depositAccount != null) 
                    {
                        System.out.print("Enter amount to deposit: ");
                        double depositAmount = scanner.nextDouble();
                        depositAccount.deposit(depositAmount);
                    } 
                    else 
                    {
                        System.out.println("Account not found.");
                    }
                    break;

                case 3:
                    System.out.print("Enter account number: ");
                    String withdrawAccountNumber = scanner.nextLine();
                    Account withdrawAccount = bank.findAccount(withdrawAccountNumber);
                    if (withdrawAccount != null) 
                    {
                        System.out.print("Enter amount to withdraw: ");
                        double withdrawAmount = scanner.nextDouble();
                        withdrawAccount.withdraw(withdrawAmount);
                    } 
                    else 
                    {
                        System.out.println("Account not found.");
                    }
                    break;

                case 4:
                    System.out.print("Enter your account number: ");
                    String fromAccountNumber = scanner.nextLine();
                    Account fromAccount = bank.findAccount(fromAccountNumber);
                    if (fromAccount != null) 
                    {
                        System.out.print("Enter target account number: ");
                        String toAccountNumber = scanner.nextLine();
                        Account toAccount = bank.findAccount(toAccountNumber);
                    if (toAccount != null) 
                    {
                        System.out.print("Enter amount to transfer: ");
                        double transferAmount = scanner.nextDouble();
                        fromAccount.transfer(toAccount, transferAmount);
                    } 
                    else 
                    {
                        System.out.println("Target account not found.");
                    }
                } 
                    else 
                    {
                    System.out.println("Your account not found.");
                    }
                break;

            case 5:
                bank.listAccounts();
                break;

            case 6:
                System.out.println("Exiting the system. Thank you for using BankY!");
                break;

            default:
                System.out.println("Invalid choice. Please try again.");
        }
    } 
    while (choice != 6);

    scanner.close();
}
}
