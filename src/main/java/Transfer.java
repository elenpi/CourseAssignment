import java.time.LocalDate;

public class Transfer implements Transaction {

    private Customer customer;
    private String transactionType;
    private LocalDate date;

    //===============Constructors===================//

    public Transfer(Customer customer) {

        this.customer = customer;
        this.transactionType = "Transfer";
        this.date = LocalDate.now();

    }

    //===============Methods===================//

    // Transfer money between two accounts with the same holder

    public void transaction( BankAccount account, int amount, BankAccount toAccount) throws ErrorException {

        if (account.getHolders().contains(customer) && account.getAccountBalance() > amount) {
            account.deductBalance(amount);

            System.out.println(amount + "$ were transferred to your account. Your new balance is " + account.getAccountBalance() + "$.");

            account.addTransaction(this);

            Deposit deposit = new Deposit(customer);
            deposit.transaction(toAccount,amount,null);
            toAccount.addTransaction(deposit);

        } else if (account.getHolders().contains(customer) && account.getAccountBalance() <= amount){
            System.out.println("Your account balance doesn't have sufficient funds.");
            throw new ErrorException("Error: Amount exceeds acount balance");
        } else {
            System.out.println("Money transfer can only occur between a customer's accounts.");
            throw new ErrorException("Error: You have only one account registered to your name.");
        }
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
        return "Transfer{" +
                "date=" + this.date +
                ", customer=" + customer.getCustomerName() +
                ", transactionType='" + this.transactionType + '\'' +
                '}';
    }


}
