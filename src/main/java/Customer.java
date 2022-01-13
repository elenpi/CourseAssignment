import java.util.List;

public class Customer {

    //===============Instance Variable===================//

    private String customerName;
    private int customerAFM;
    private List<Customer> allCustomers;

    //===============Constructors===================//

    public Customer(String name, int afm) {

        this.customerName = name;
        this.customerAFM = afm;
    }

    //===============Methods===================//

    //Method to get customer's name
    public String getCustomerName() {
        return customerName;
    }

    //Method to set customer's name
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    //Method to create a new customer
    public static Customer createCustomer(String name, int afm) {

        Customer customer = new Customer(name, afm);
        return customer;

    }

    //Method to add a new customer to the list of all customers
//    public void addCustomer(Customer customer) {
//
//        this.allCustomers.add(customer);
//
//    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerName='" + customerName + '\'' +
                ", customerAFM=" + customerAFM +
                '}';
    }

    //
//    public Check draftCheck () {
//
//        Check newCheck = new Check()
//    }

}
