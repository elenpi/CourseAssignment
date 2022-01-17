import java.time.LocalDate;

public interface Transaction {
    //

    Customer getCustomer();

    LocalDate getDate();

    String getTransactionType();

    // Perform transaction
    void transaction(BankAccount account, int amount, BankAccount toAccount) throws ErrorException;

}



