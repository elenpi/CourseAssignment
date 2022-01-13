public class Check {

    private BankAccount accountHolder;
    private BankAccount accountNumber;
    private int amount;
    private String recipient;
    private String description;

    public Check(BankAccount accountHolder, BankAccount accountNumber, int amount, String recipient, String description) {
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.amount = amount;
        this.recipient = recipient;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Check{" +
                "accountHolder=" + accountHolder.getHolders() +
                ", accountNumber=" + accountNumber.getAccountNumber() +
                ", amount=" + amount +
                ", recipient='" + recipient + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
