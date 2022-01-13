import java.util.ArrayList;

public class BankingApp {

    public static void main(String[] args) {

        //===============Register a New Customer===================//

        Customer papadopoulosI = new Customer("Ioannis Papadopoulos", 123456);

        Customer pippaN = new Customer("Nefeli Pippa", 56789);

        Customer doeJ = Customer.createCustomer("John Doe", 890874);

        System.out.println(doeJ.toString());

        //===============Open a New Bank Account===================//

        BankAccount account1 = new BankAccount(12345,400);
        account1.addHolder(papadopoulosI);
        account1.addHolder(pippaN);

        BankAccount account3 = new BankAccount(12334567, 1000);
        account3.addHolder(pippaN);

        System.out.println(account1.toString());


        //===============Withdraw===================//
        int amount = 100;
        Withdrawal withdrawal = new Withdrawal(papadopoulosI);
        withdrawal.withdraw(account1, amount);
        System.out.println(withdrawal);
        account1.addTransaction(withdrawal);
        System.out.println(account1.getAccountTransactions());
        System.out.println(account1);

        amount = 50;
        Withdrawal withdrawalN = new Withdrawal(pippaN);
        withdrawalN.withdraw(account1, amount);
        account1.addTransaction(withdrawalN);


        //===============Withdraw===================//

//        BankAccount account2 = new BankAccount(67891,100122);
//
//
//        Check check1 = new Check(account1,account1,100,"Nefeli Pippa","Pay rent");
//        System.out.println(check1.toString());

        //===============Deposit===================//

        amount = 20;
        Deposit deposit = new Deposit(papadopoulosI);
        deposit.deposit(account1, amount);
        account1.addTransaction(deposit);

        //===============Transfer===================//

        amount = 10;
        Transfer transfer = new Transfer(papadopoulosI);
        transfer.transfer(amount, account1, account3);
        account1.addTransaction(transfer);


    }

//    private static void withdraw(Customer customer, BankAccount bankAccount, int amount) {
//
//        Withdrawal withdrawal = new Withdrawal(customer);
//        withdrawal.transaction(bankAccount, amount);


}
