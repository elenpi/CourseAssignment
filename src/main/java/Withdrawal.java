import java.time.LocalDate;

public class Withdrawal implements Transaction {

    private Customer customer;
    private String transactionType;
    private LocalDate date;


    //===============Constructors===================//

    public Withdrawal(Customer customer) {

        this.customer = customer;
        this.transactionType = "Withdraw";
        this.date = LocalDate.now();
    }

    //===============Methods===================//

    @Override
    public Customer getCustomer() {
        return customer;
    }

    @Override
    public LocalDate getDate() {
        return date;
    }

    @Override
    public String getTransactionType() {
        return transactionType;
    }

    // Withdraw money from account
    @Override
    public void transaction( BankAccount account, int amount, BankAccount toAccount) throws ErrorException {

        if (account.getAccountBalance() > amount) {
            account.deductBalance(amount);
            System.out.println("You have successfully withdraw " + amount + ". Your new account balance is: " + account.getAccountBalance() + "$.");
            Withdrawal withdrawal = new Withdrawal(customer);
            account.addTransaction(withdrawal);
            account.addTransaction(this);

        } else {
            System.out.println("You account balance doesn't have sufficient funds.");

            throw new ErrorException("Error: The amount you entered exceeds your account balance.");
        }
    }

    @Override
    public String toString() {
        return "Withdrawal{" +
                "date=" + this.date +
                ", customer=" + customer.getCustomerName() +
                ", transactionType='" + this.transactionType + '\'' +
                '}';
    }
}
