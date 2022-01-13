import java.time.LocalDate;

public class Transfer extends Transaction {

    public Transfer(Customer customer) {

        super(customer);

    }

    public static void transfer(int amount, BankAccount sender, BankAccount receiver){


        if (sender.getHolders() == receiver.getHolders()){
            int senderBalance =  sender.getAccountBalance();
            int receiverBalance = receiver.getAccountBalance() + amount;
            System.out.println(amount + "$ were transfered to your account. Your new balance is " + receiverBalance + "$.");
            senderBalance = senderBalance - amount;
            receiver.setAccountBalance(receiverBalance);
            sender.setAccountBalance(senderBalance);
        } else {
            System.out.println("Money transfer can only occur between a customer's accounts.");

        }
    }

}
