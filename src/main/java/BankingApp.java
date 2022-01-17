import java.util.ArrayList;
import java.util.List;

public class BankingApp {

    public static void main(String[] args) {

        //===============Register a New Customer===================//

        // Create a list for all customers
        List<Customer> allCustomer = new ArrayList<>();

        // Existing Customers
        Customer customer1 = new Customer("John Doe", 10203040);
        allCustomer.add(customer1);

        Customer customer2 = new Customer("Jane Smith", 10305070);
        allCustomer.add(customer2);

        Customer customer3 = new Customer("Jane Doe", 98765432);
        allCustomer.add(customer3);

        Customer customer4 = new Customer("Tim Brown", 82307451);
        allCustomer.add(customer4);


        //===============Create Account===================//

//        System.out.println(" ");
//        System.out.println("===============Create Account=================");
//        System.out.println(" ");

        // Create a list for all bank accounts
        List<BankAccount> allBankAccounts = new ArrayList<>();

        //Create a new bank account
        BankAccount account1 = new BankAccount(10987654, 1000);
        BankAccount account2 = new BankAccount(20123456, 0);
        BankAccount account3 = new BankAccount(30564738, 5000);
        BankAccount account4 = BankAccount.openAccount();

        // Adding existing customers to accounts
        account1.addHolder(customer1);
        account1.addHolder(customer2);
        account2.addHolder(customer2);
        account3.addHolder(customer1);
        account4.addHolder(customer4);

        // Adding account to the list of all accounts
        allBankAccounts.add(account1);
        allBankAccounts.add(account2);
        allBankAccounts.add(account3);
        allBankAccounts.add(account4);

        //===============Menu===================//

        System.out.println(" ");
        System.out.println("===============Welcome to ABC Bank=================");
        System.out.println(" ");


        // Register a customer
        Customer newCustomer = Menu.registerNewCustomer(allCustomer);

        System.out.println(" ");
        System.out.println("===============Create Account=================");
        System.out.println(" ");

        // Open an account
        BankAccount newBankAccount = Menu.createNewAccount(allCustomer, allBankAccounts);
        newBankAccount.addHolder(newCustomer);

        System.out.println(" ");
        System.out.println("===============Select Transaction=================");
        System.out.println(" ");

        // Perform a transaction
        Menu.selectTransaction(customer2, account1, allBankAccounts);

        //===============Check===================//

        Check.draftCheck(customer1, account1, 100, "Ken Lee", "Pay rent");

        System.out.println("");
        System.out.println("==============Check==================");
        System.out.println("");

        //Check check1 = Check.draftCheck(customer1, account3);

        //===============Withdraw===================//

        System.out.println(" ");
        System.out.println("===============Withdraw=================");
        System.out.println(" ");

        // Make a withdraw
        try {
            Withdrawal withdraw = Withdrawal.withdraw(customer2, account2, 100000);
        } catch (ErrorException e) {
            System.out.println(e.getMessage());
        }

        //===============Deposit===================//

        System.out.println("");
        System.out.println("==============Deposit==================");
        System.out.println("");

        // Make a deposit
        Deposit deposit = Deposit.deposit(customer1, account1, 100);

        //===============Transfer===================//

        System.out.println("");
        System.out.println("==============Transfer==================");
        System.out.println("");

        // Make a transfer
        try {
            Transfer transfer = Transfer.transfer(10, customer1, account1, account3);
        } catch (ErrorException e) {
            System.out.println(e.getMessage());
        }

        //===============Reports===================//

        System.out.println("");
        System.out.println("==============Reports==================");
        System.out.println("");

        // Print a report with all registered customers
        Report.printCustomers(allCustomer, allBankAccounts);
        System.out.println(" ");

        // Print a report with all accounts
        Report.printBankAccountReport(allBankAccounts, allCustomer);
        System.out.println(" ");

        // Print a report with the transaction history of a specific account
        Report.printTransactionsReport(account1);

    }
}