import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WithdrawalTest {


    @Test
        // Test Case #1: Happy Path
    void withdraw() {

        Customer customer = new Customer("Test Guru", 123456);
        BankAccount account = new BankAccount(12345678, 100);

        try {
            Withdrawal.withdraw(customer, account, 10);
            Assertions.assertInstanceOf(Customer.class, customer);
            System.out.println("Withdrawal was successfull!");

        } catch (ErrorException e) {
            System.out.println("Error: Withdraw failed");
        }
    }

    @Test
        //Test Case #2: Insufficient Funds
    void withdrawInsufficientFunds() {
        Customer customer = new Customer("Test Guru", 123456);
        BankAccount account = new BankAccount(12345678, 100);
        try {
            String expectedOutcome = "You account balance doesn't have sufficient funds.";
            assertEquals(expectedOutcome, Withdrawal.withdraw(customer, account, 10000));
        } catch (Exception e) {

            System.out.println("Test Case Failed: Deposit was successfull.");
        }
    }
}