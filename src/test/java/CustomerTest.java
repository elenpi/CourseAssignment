import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;


class CustomerTest {
    @Test
    void registration() {
       try { List<Customer> allCustomers = new ArrayList<>();

            Customer newCustomer = Customer.registration("Testing Guru", 12345678, allCustomers);
            allCustomers.add(newCustomer);

            Assertions.assertInstanceOf(Customer.class, newCustomer);

            System.out.println("User is registered.");
        } catch (Exception e) {
            System.out.println("Error: Customer not created.");
        }

    }

}