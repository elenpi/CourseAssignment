import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;


class CustomerTest {


    @Test
    void registerCustomer() {

        // Test Case #1: Happy Path
        try {
            InputStream sysInBackup = System.in;
            ByteArrayInputStream in = new ByteArrayInputStream("My Name".getBytes());
            System.setIn(in);
            System.setIn(sysInBackup);
            ByteArrayInputStream in2 = new ByteArrayInputStream("12345".getBytes());
            System.setIn(in2);


            List<Customer> allCustomers = new ArrayList<>();

            Customer newCustomer = Customer.registerCustomer(allCustomers);
            allCustomers.add(newCustomer);

            Assertions.assertInstanceOf(Customer.class, newCustomer);

            System.out.println("User is registered");
        } catch (Exception e) {
            System.out.println("Error: Customer not created.");
        }
//
//        // Test Case #2: User already registered
//        try {
//            Customer newCustomer = new Customer("Testing Guy", 123456);
//            Assertions.assertInstanceOf(Customer.class, newCustomer);
//        } catch (Exception e) {
//            System.out.println("Error: User already registered.");
//        }
    }

}