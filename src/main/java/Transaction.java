import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.lang.String;

public class Transaction {

    //===============Instance Variable===================//

    protected LocalDate date;
    protected String transcactionType;
    protected Customer customer;

    //===============Constructors===================//

    public Transaction(Customer customer) {

        this.date = LocalDate.now();
        this.transcactionType = transcactionType;
        this.customer = customer;
    }

    //===============Methods===================//

    // Get the date of when the transaction took place
    public LocalDate getDate() {
        return date;
    }

    // Get the type of the transaction
    public String getTranscactionType() {
        return transcactionType;
    }

    // Get the customer who made the transaction
    public Customer getCustomer() {
        return customer;
    }

    // Select a transaction from a menu
    public static void selectTransaction(Customer customer, BankAccount account, List<BankAccount> listAccounts) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please select a transaction:");
        System.out.println("To withdraw money from an account enter: 1");
        System.out.println("To deposit money to an account enter: 2");
        System.out.println("To transfer money between your accounts enter: 3");

        int input = Integer.valueOf(scanner.nextLine());

        switch (input) {
            case 1:
                System.out.println("Please enter the amount you want to withdraw: ");
                int amountWithdraw = Integer.valueOf(scanner.nextLine());
                try {
                    Withdrawal.withdraw(customer, account, amountWithdraw);

                } catch (ErrorException e) {
                    System.out.println(e.getMessage());
                }
                break;
            case 2:
                System.out.println("Please enter the amount you want to deposit: ");
                int amountDeposit = Integer.valueOf(scanner.nextLine());
                Deposit.deposit(customer, account, amountDeposit);
                break;
            case 3:
                System.out.println("Please select the account to which you want to transfer the money.");

                int counter = 0;
                List<Integer> accountNumbers = new ArrayList<>();
                for (BankAccount acc : listAccounts) {
                    if (acc.getHolders().contains(customer)) {
                        accountNumbers.add(acc.getAccountNumber());
                        System.out.println("To " + acc.getAccountNumber() + ": Enter " + counter);
                        counter++;
                    } else if (accountNumbers.isEmpty()) {
                        System.out.println("One account found. You can only make transfer between your accounts.");
                    }
                }
                int selecetAccount = Integer.valueOf(scanner.nextLine());

                BankAccount toAccount = null;

                for (BankAccount accs : listAccounts) {
                    if (accs.getAccountNumber() == accountNumbers.get(selecetAccount)) {
                        toAccount = accs;
                    }
                }
                System.out.println("Please enter the amount you want to transfer: ");
                int amountTransfer = Integer.valueOf(scanner.nextLine());

                try {
                    Transfer.transfer(amountTransfer, customer, account, toAccount);
                } catch (ErrorException e) {

                    System.out.println(e.getMessage());
                }
                break;
            default:
                System.out.println("Goodbye!");
                break;
        }
    }

}



