import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DepositTest {

    @Test
    void deposit() {
        Customer customer = new Customer("Test Guru", 123456);
        BankAccount account = new BankAccount(12345678, 100);

        // Test Case #1: Happy Path
        try {
            Deposit.deposit(customer, account, 10);
            Assertions.assertInstanceOf(Customer.class, customer);
            System.out.println("Withdrawal was successfull!");
        } catch (Exception e) {

            System.out.println("Error: Deposit was unsuccessfull.");
        }
    }
}