import java.time.LocalDate;

public class Deposit implements Transaction {

    private Customer customer;
    private String transactionType;
    private LocalDate date;

    //===============Constructors===================//

    public Deposit(Customer customer) {

        this.customer = customer;
        this.transactionType = "Deposit";
        this.date = LocalDate.now();
    }
    //===============Methods===================//

    // Deposit Money to an account
    @Override
    public void transaction(BankAccount account, int amount, BankAccount toAccount) {

        account.addBalance(amount);
        System.out.println("You deposit " + amount + "$ in your " + account.getAccountNumber() + " account. Your new balance is " + account.getAccountBalance()
                + "$.");
        account.addTransaction(this);
    }

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

    @Override
    public String toString() {
        return "Deposit{" +
                "date=" + this.date +
                ", customer=" + customer.getCustomerName() +
                ", transactionType='" + transactionType + '\'' +
                '}';
    }

}
