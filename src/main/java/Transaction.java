import java.time.LocalDate;
import java.lang.String;

public class Transaction {

    //===============Instance Variable===================//

    protected LocalDate date;
    protected String transcactionType;
    protected Customer customer;

    //===============Constructors===================//

    public Transaction(Customer customer) {

        this.date = LocalDate.now();
        this.transcactionType = transcactionType;
        this.customer = customer;
    }

    //===============Methods===================//

    // Get the date of when the transaction took place
    public LocalDate getDate() {
        return date;
    }

    // Get the type of the transaction
    public String getTranscactionType() {
        return transcactionType;
    }

    // Get the customer who made the transaction
    public Customer getCustomer() {
        return customer;
    }

}



