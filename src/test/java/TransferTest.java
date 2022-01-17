import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TransferTest {

    @Test
    void transfer() {
        Customer customer = new Customer("Testing Guru", 123456);
        BankAccount fromAccount = new BankAccount(12345678, 1000);
        BankAccount toAccount = new BankAccount(98765432, 100);
        fromAccount.addHolder(customer);
        toAccount.addHolder(customer);

        try {
            Transfer transfer = Transfer.transfer(100, customer, fromAccount, toAccount);
            Assertions.assertInstanceOf(Transfer.class, transfer);
        } catch (Exception e) {
            System.out.println("Error: Transfer failed.");
        }
    }
}