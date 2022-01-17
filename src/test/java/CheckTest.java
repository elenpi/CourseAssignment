import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CheckTest {

    @Test
    void draftCheck() {
        Customer customer = new Customer("Testing Guru", 123456);
        BankAccount account = new BankAccount(12345678, 1000);

        Check check = Check.draftCheck(customer, account, 100, "Testing Guy", "Thanks Bro!");
        Assertions.assertInstanceOf(Check.class, check);
    }
}