import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DepositTest {

    @Test
    void deposit() {
        Customer customer = new Customer("Test Guru", 123456);
        BankAccount account = new BankAccount(12345678, 100);

        try {
            Deposit deposit = Deposit.deposit(customer, account,100);
            Assertions.assertInstanceOf(Deposit.class, deposit);
            System.out.println("Deposit was successfull!");
        } catch (Exception e) {

            System.out.println("Error: Deposit was unsuccessfull.");
        }
    }
}