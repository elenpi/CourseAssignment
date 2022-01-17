public class Deposit extends Transaction {

    //===============Constructors===================//

    public Deposit(Customer customer) {

        super(customer);
        this.transcactionType = "Deposit";
    }

    //===============Methods===================//

    // Deposit Money to an account
    public static Deposit deposit(Customer customer, BankAccount account, int amount) {

        int balance = account.getAccountBalance();
        int newBalance = balance + amount;
        account.setAccountBalance(newBalance);

        System.out.println("You deposit " + amount + "$ in your " + account.getAccountNumber() + " acount. Your new balance is " + newBalance + "$.");

        Deposit deposit = new Deposit(customer);
        account.addTransaction(deposit);

        return deposit;
    }

    @Override
    public String toString() {
        return "Withdrawal{" +
                "date=" + this.date +
                ", customer=" + customer.getCustomerName() +
                ", transcactionType='" + transcactionType + '\'' +
                '}';
    }

}
