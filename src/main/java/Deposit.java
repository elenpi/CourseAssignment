import java.time.LocalDate;

public class Deposit extends Transaction {

    public Deposit(Customer customer){

        super(customer);
    }

    public void deposit(BankAccount account, int amount) {
        int balance = account.getAccountBalance();
        int newBalance = balance + amount;
        account.setAccountBalance(newBalance);
        System.out.println("You deposit " + amount + "$ in your " + account.getAccountNumber() + " acount. Your new balance is " + newBalance + "$.");

    }
}
