import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BankAccount {

    //===============Instance Variable===================//

    private int accountNumber;
    private LocalDate accountDate;
    private List<Customer> holders;
    private int accountBalance;
    private List<Transaction> accountTransactions;
//    private HashMap<String,int> accountTransactions;

    //===============Constructors===================//

    public BankAccount(int accountNumber, int accountBalance){

        this.accountNumber = accountNumber;
        this.accountDate = LocalDate.now();
        this.accountBalance = accountBalance;
        this.accountTransactions = new ArrayList<>();
        this.holders = new ArrayList<>();
    }

    //===============Methods===================//

    // Method to add a customer holder to an account
    public void addHolder(Customer holder) {

        if (this.holders.size() == 2) {
            System.out.println("The account has reached the limit of maximum account holders");
            return;

        }

        this.holders.add(holder);
    }

    // Method to add a transaction to a list
    public void addTransaction(Transaction transaction) {

        this.accountTransactions.add(transaction);
    }

    // Method to add get the account transactions
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

