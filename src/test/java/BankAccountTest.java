import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BankAccountTest {

    @Test
    void addHolder() {
        try {

            // Test Case #1: Happy Path
            Customer customer1 = new Customer("Testing Guru", 123456);
            Customer customer2 = new Customer("Testing Master", 987654);

            BankAccount account = new BankAccount(12344578, 0);
            account.addHolder(customer1);

            assert (account.getHolders().contains(customer1));
            System.out.println("Holder Added");
        } catch (Exception e) {
            System.out.println("Holder not added");
        }

    }

    @Test
    void createAccount() {

        BankAccount account1 = BankAccount.openAccount();
        Assertions.assertInstanceOf(BankAccount.class, account1);
        System.out.println("Account was created successfully");

    }

    @Test
    void addTransaction() {
        try {
            BankAccount account = new BankAccount(12344578, 0);
            Customer customer = new Customer("Testing Master", 987654);

            Deposit deposit = new Deposit(customer);
            deposit.transaction(account, 100, null);
            assertFalse(account.getAccountTransactions().isEmpty());

            System.out.println("It works!");
        } catch (Exception e) {
            System.out.println("Error: Transaction not added in the account");
        }

    }
}