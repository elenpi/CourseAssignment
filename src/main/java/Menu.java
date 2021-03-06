import java.util.*;

public class Menu {

    // Check if customer's name is already registered
    public static boolean isNameRegistered(String name, List<Customer> listCustomers) {

        for (Customer c : listCustomers) {
            if (name.equalsIgnoreCase(c.getCustomerName())) {
                return true;
            }
        }

        return false;
    }

    // Check if customer's afm is already registered
    public static boolean isAfmRegistered(int afm, List<Customer> listCustomers) {

        for (Customer c : listCustomers) {
            if (afm == c.getCustomerAFM()) {
                return true;
            }
        }

        return false;
    }

    // Method to search for an existing customer by name
    public static Customer lookUpCustomer(String name, List<Customer> listCustomers) {

        for (Customer c : listCustomers) {
            if (name.equalsIgnoreCase(c.getCustomerName())) {
                return c;
            }
        }

        return null;
    }

    // Register a new customer
    public static Customer registerNewCustomer(List<Customer> listCustomers) {

        Scanner scanner = new Scanner(System.in);

        String name = null;
        int afm = 0;
        int counter = 0;

        System.out.println("To register as a new customer, please enter your first and last name:");

        while (counter < 2) {

            name = scanner.nextLine();

            if (isNameRegistered(name, listCustomers)) {
                System.out.println("You have entered an already registered name. Please try a different one:");
                counter++;
                name = null;
                continue;
            }
            break;
        }
        if (name == null) {
            System.out.println("Sorry, you have reached your tries limit. Goodbye!");
            return null;
        }

        counter = 0;

        while (counter < 2) {
            System.out.println("Now please enter your Tax Registration Number:");
            afm = Integer.valueOf(scanner.nextLine());

            if (isAfmRegistered(afm, listCustomers)) {
                System.out.println("The Tax Registry Number you have entered is already in use. Please type a different one:");
                counter++;
                afm = 0;
                continue;
            }
            break;
        }
        if (afm == 0) {
            System.out.println("Sorry, you have reached your tries limit. Goodbye!");
            return null;
        }

        Customer newCustomer = Customer.registerCustomer(name, afm);
        listCustomers.add(newCustomer);
        return newCustomer;

    }

    // Open a new account
    public static BankAccount createNewAccount(List<Customer> listCustomers, List<BankAccount> listAccounts) {

        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();
        BankAccount newAccount = null;

        System.out.println("Since you are an existing customer, to open a new account, please enter you first and last name: ");
        String input = scanner.nextLine();

        Customer customer = Menu.lookUpCustomer(input, listCustomers);

        int randomNumber = new Random().nextInt(900000) + 100000;

        if (customer != null) {
            newAccount = new BankAccount(randomNumber, 0, customer);
            listAccounts.add(newAccount);

            System.out.println(input + " you have successfully created a new account with Account Number: " + randomNumber + " and Balance: " + newAccount.getAccountBalance());
            return newAccount;
        } else {
            System.out.println("Unfortunately, to open a new account you have to be an existing customer. Please register first. Goodbye!");
        }
        return null;
    }

    // Select a transaction from a menu
    public static void selectTransaction(Customer customer, BankAccount account, List<BankAccount> listAccounts) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Please select a transaction:");
        System.out.println("To withdraw money from an account enter: 1");
        System.out.println("To deposit money to an account enter: 2");
        System.out.println("To transfer money between your accounts enter: 3");
        System.out.println("To draft a check to another person: 4");

        int input = Integer.valueOf(scanner.nextLine());

        switch (input) {
            case 1:
                System.out.println("Please enter the amount you want to withdraw: ");
                int amountWithdraw = Integer.valueOf(scanner.nextLine());
                try {
                    Withdrawal withdraw = new Withdrawal(customer);
                    withdraw.transaction(account, amountWithdraw, null);

                } catch (ErrorException e) {
                    System.out.println(e.getMessage());
                }
                break;
            case 2:
                System.out.println("Please enter the amount you want to deposit: ");
                int amountDeposit = Integer.valueOf(scanner.nextLine());
                Deposit deposit = new Deposit(customer);
                deposit.transaction(account, amountDeposit,null);
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
                    }
                }

                if (accountNumbers.isEmpty()) {
                    System.out.println("One account found. You can only make transfer between your accounts.");
                    System.exit(0);
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
                    Transfer transfer = new Transfer(customer);
                    transfer.transaction(account, amountTransfer, toAccount);
                } catch (ErrorException e) {

                    System.out.println(e.getMessage());
                }
                break;
            case 4:
                System.out.println("Please enter recipients name:");
                String recipient = scanner.nextLine();

                System.out.println("Please enter the amount:");
                int amount = Integer.valueOf(scanner.nextLine());

                System.out.println("Please write a memo:");
                String memo = scanner.nextLine();
                Check check = new Check(customer, account, amount, recipient, memo);
                check.draftCheck();
            default:
                System.out.println("Goodbye!");
                break;
        }
    }
}