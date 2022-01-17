import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DepositTest {

    @Test
    void deposit() {
        Customer customer = new Customer("Test Guru", 123456);
        BankAccount account = new BankAccount(12345678, 100);

        try {
            Deposit deposit = new Deposit(customer);
            deposit.transaction(account, 100, null);
            assert (account.getAccountBalance() == 200);
            System.out.println("Deposit was successful!");
        } catch (Exception e) {

            System.out.println("Error: Deposit was unsuccessful.");
        }
    }
}