import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Report {

    //===============Methods===================//

    // Print a report for all customer names, their Tax Registry Number and their accounts
    public static void printCustomers(List<Customer> listCustomers, List<BankAccount> listAccounts) {

        System.out.println("Customers Report:");
        System.out.println("=================");

        int counter = 0;
        String customerName = null;
        int customerAFM = 0;

        for (Customer customer : listCustomers) {

            List<Integer> accounts = new ArrayList<>();

            for (BankAccount account : listAccounts) {
                if (account.getHolders().contains(customer)) {
                    accounts.add(account.getAccountNumber());
                    counter++;
                }
            }

            customerName = customer.getCustomerName();

            customerAFM = customer.getCustomerAFM();

            if (accounts.size() == 1) {
                System.out.println("+ Customer Name: " + customerName + "; AFM: " + customerAFM + "; Account " + accounts.get(0));
            } else {
                System.out.print("+ Customer Name: " + customerName + "; AFM: " + customerAFM + "; Accounts: ");
                for (int i = 0; i < accounts.size(); i++) {
                    System.out.print(accounts.get(i) + " ");
                }
                System.out.println(" ");
            }
        }
    }

    // Print a report with all the bank accounts and their details
    public static void printBankAccountReport(List<BankAccount> list, List<Customer> listCustomers) {
        int accNumber = 0;
        LocalDate date = null;
        int balance = 0;
        List<String> names = null;

        System.out.println("Bank Accounts Report:");
        System.out.println("=====================");

        for (BankAccount account : list) {
            List holder = account.getHolders();
            names = new ArrayList<>();
            for (Customer customer : listCustomers) {
                if (holder.contains(customer)) {
                    names.add(customer.getCustomerName());
                }
            }
            accNumber = account.getAccountNumber();
            date = account.getAccountDate();
            balance = account.getAccountBalance();
            if (names.size() > 1) {
                System.out.println("+ Account Number: " + accNumber + "; Opening Date: " + date + "; Holders: " + names.get(0) + " ; " + names.get(1) + "; Current Balance: " + balance);
            } else {
                System.out.println("+ Account Number: " + accNumber + "; Opening Date: " + date + "; Holder: " + names.get(0) + "; Current Balance: " + balance);

            }

        }
    }

    // Print a report with all the transaction made for a particular account
    public static void printTransactionsReport(BankAccount account) {

        System.out.println("Transactions History Report for the Account " + account.getAccountNumber() + ":");
        System.out.println("=====================================================");

        for (Transaction transaction : account.getAccountTransactions()) {
            Customer customer = transaction.getCustomer();
            String name = customer.getCustomerName();

            System.out.println("+ Transaction Type: " + transaction.getTranscactionType() + "; Preformed by: " + name + "; Date: " + transaction.getDate());
        }
    }

}



