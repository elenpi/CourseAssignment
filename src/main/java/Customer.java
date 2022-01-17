import java.util.List;
import java.util.Scanner;

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
    public static Customer registerCustomer(List<Customer> list) {

        Scanner scanner = new Scanner(System.in);

        String name = null;
        int afm=0;
        Customer customer = null;

        System.out.println("Welcome to ABC Bank!");
        System.out.println("To register as a new customer, please enter your first and last name:");

        while (true) {

            for (Customer c : list) {
                int counter=0;
                name = scanner.nextLine();

                if (name.equalsIgnoreCase(c.getCustomerName()) && counter < 3) {
                    System.out.println("The name you have entered is already in use. Please type a different one:");
                    counter++;
                } else
                    break;
            }

            System.out.println("Now please enter your Tax Registration Number:");

            for (Customer c : list) {
                afm = Integer.valueOf(scanner.nextLine());

                int counter = 0;
                if (afm == c.getCustomerAFM() && counter <4) {
                    System.out.println("The Tax Registry Number you have entered is already in use. Please type a different one:");
                    counter++;
                } else
                    break;
            }
            customer = new Customer(name, afm);
            System.out.println("Welcome to ABC Bank " + customer.getCustomerName() + "! " + "Your registration was successfull.");
            return customer;
        }
    }


    @Override
    public String toString() {
        return "Customer{" +
                "customerName='" + customerName + '\'' +
                ", customerAFM=" + customerAFM +
                '}';
    }


}
