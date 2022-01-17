public class Transfer extends Transaction {

    //===============Constructors===================//

    public Transfer(Customer customer) {

        super(customer);
        this.transcactionType = "Transfrer";

    }

    //===============Methods===================//

    // Transfer money between two accounts with the same holder
    public static Transfer transfer(int amount, Customer customer, BankAccount fromAccount, BankAccount toAccount) throws ErrorException {

        if (fromAccount.getHolders().contains(customer)) {
            int fromAccountBalance = fromAccount.getAccountBalance();
            int toAccountBalance = toAccount.getAccountBalance() + amount;
            System.out.println(amount + "$ were transferred to your account. Your new balance is " + toAccountBalance + "$.");
            fromAccountBalance = fromAccountBalance - amount;
            toAccount.setAccountBalance(toAccountBalance);
            fromAccount.setAccountBalance(fromAccountBalance);

            Transfer transfer = new Transfer(customer);
            fromAccount.addTransaction(transfer);

            return transfer;

        } else {
            System.out.println("Money transfer can only occur between a customer's accounts.");
            throw new ErrorException("Error: You have only one account registered to your name.");
        }
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
