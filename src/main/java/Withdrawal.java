public class Withdrawal extends Transaction {

    public Withdrawal(Customer customer) {

        super(customer);
    }

    public void withdraw(BankAccount account, int amount) {

        if ( account.getAccountBalance() > 0){
            int newBalance = account.getAccountBalance() - amount;
            account.setAccountBalance(newBalance);
            System.out.println("You account balance is: " + newBalance + "$.");
        } else {
            System.out.println("You account balance doesn't have sufficient funds.");
        }
    }

    @Override
    public String toString() {
        return "Withdrawal{" +
                "date=" + date +
                ", customer=" + customer +
                '}';
    }
}
