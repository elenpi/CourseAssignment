import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

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

        List<Customer> allCustomers =  new ArrayList<>();

        Customer customer = new Customer("Testing Master", 987654);
        Customer customer2 = new Customer("Testing Guru", 1234567);
        allCustomers.add(customer);
        allCustomers.add(customer2);

        ByteArrayInputStream in = new ByteArrayInputStream("Testing Guru".getBytes());
        System.setIn(in);

        BankAccount account1 = BankAccount.createAccount(allCustomers);
        Assertions.assertInstanceOf(BankAccount.class, account1);

    }

    @Test
    void addTransaction() {
        try {
            BankAccount account = new BankAccount(12344578, 0);
            Customer customer = new Customer("Testing Master", 987654);

            Deposit deposit = Deposit.deposit(customer, account, 100);
            account.addTransaction(deposit);
            assert (account.getAccountTransactions() != null);

            System.out.println("It works!");
        } catch (Exception e) {
            System.out.println("Error: Transaction not added in the account");
        }

    }
}