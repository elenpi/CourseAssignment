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
            Withdrawal withdrawal = new Withdrawal(customer);
            withdrawal.transaction(account,50,null);
            assert(account.getAccountBalance() == 50);
            System.out.println("Withdrawal was successfull!");

        } catch (ErrorException e) {
            System.out.println("Error: Withdraw failed");
        }
    }

}