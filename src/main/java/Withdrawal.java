public class Withdrawal extends Transaction {

    //===============Constructors===================//

    public Withdrawal(Customer customer) {

        super(customer);
        this.transcactionType = "Withdraw";
    }

    //===============Methods===================//

    // Withdraw money from account
    public static Withdrawal withdraw(Customer customer, BankAccount account, int amount) throws ErrorException {

        if (account.getAccountBalance() > 0) {
            int newBalance = account.getAccountBalance() - amount;
            account.setAccountBalance(newBalance);
            System.out.println("You have successfully withdraw " + amount + ". Your new account balance is: " + newBalance + "$.");

            Withdrawal withdrawal = new Withdrawal(customer);
            account.addTransaction(withdrawal);
        } else {
            System.out.println("You account balance doesn't have sufficient funds.");
            Withdrawal nonWithdrawal = null;
            throw new ErrorException("Error: Your account balance should be >0 to make a withdraw");
        }

        return null;
    }

    @Override
    public String toString() {
        return "Withdrawal{" +
                "date=" + this.date +
                ", customer=" + customer.getCustomerName() +
                ", transcactionType='" + this.transcactionType + '\'' +
                '}';
    }
}
