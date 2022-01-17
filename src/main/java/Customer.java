import java.util.List;

public class Customer {

    //===============Instance Variable===================//

    private String customerName;
    private int customerAFM;

    //===============Constructors===================//

    public Customer(String name, int afm) {

        this.customerName = name;
        this.customerAFM = afm;
    }

    //===============Methods===================//

    //Method to get customer's afm
    public int getCustomerAFM() {
        return customerAFM;
    }


    //Method to get customer's name
    public String getCustomerName() {
        return customerName;
    }

    //Method to set customer's name
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    //Method to create a new customer
    public static Customer registration(String name, int afm, List<Customer> list) {

        Customer customer = new Customer(name, afm);
        System.out.println("Welcome to ABC Bank " + customer.getCustomerName() + "! " + "Your registration was successfull.");
        return customer;
    }


    @Override
    public String toString() {
        return "Customer{" +
                "customerName='" + customerName + '\'' +
                ", customerAFM=" + customerAFM +
                '}';
    }


}
