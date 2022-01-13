import java.time.LocalDate;

public class Transaction {

    protected LocalDate date;
    protected Customer customer;

    public Transaction(Customer customer) {

        this.customer = customer;
        this.date = LocalDate.now();
    }
}
