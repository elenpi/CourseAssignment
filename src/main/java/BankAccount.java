import java.time.LocalDate;
import java.util.*;

public class BankAccount {

    //===============Instance Variable===================//

    private int accountNumber;
    private LocalDate accountDate;
    private List<Customer> holders;
    private int accountBalance;
    private List<Transaction> accountTransactions;

    //===============Constructors===================//

    public BankAccount(int accountNumber, int accountBalance) {

        this.accountNumber = accountNumber;
        this.accountDate = LocalDate.now();
        this.accountBalance = accountBalance;
        this.accountTransactions = new ArrayList<>();
        this.holders = new ArrayList<>();
    }


    //===============Methods===================//


    // Method to add the date of account's opening
    public LocalDate getAccountDate() {
        return accountDate;
    }

    // Method to add a customer holder to an account
    public void addHolder(Customer holder) {

        if (this.holders.size() == 2) {
            System.out.println("The account has reached the limit of maximum account holders");
            return;
        }
        this.holders.add(holder);
    }

    public static BankAccount createAccount() {

        Random rand = new Random();

        int randomNumber = new Random().nextInt(900000) + 100000;

        BankAccount account = new BankAccount(randomNumber, 0);

        return account;


    }


    // Method to add a transaction to a list
    public void addTransaction(Transaction transaction) {

        this.accountTransactions.add(transaction);
    }

    public void addAccount() {

    }

    // Method to get the account transactions
    public List<Transaction> getAccountTransactions() {
        return accountTransactions;
    }

    // Method to add get the account number
    public int getAccountNumber() {
        return accountNumber;
    }

    // Method to add get the account holder(s)
    public List<Customer> getHolders() {
        return holders;
    }

    // Method to add get the account balance
    public int getAccountBalance() {
        return accountBalance;
    }

    // Method to add set the account balance
    public void setAccountBalance(int accountBalance) {
        this.accountBalance = accountBalance;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "accountNumber=" + accountNumber +
                ", accountDate=" + accountDate +
                ", holders=" + holders +
                ", accountBalance=" + accountBalance +
                ", accountTransactions=" + accountTransactions.toString() +
                '}';
    }
}
