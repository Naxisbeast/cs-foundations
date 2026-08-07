package encapsulation;

public class BankAccountTest {
    public static void main(String[] args) {
        BankAccount account = new BankAccount("Mpho Dlamini", 500.00);

        System.out.println(account);
        account.deposit(250.00);
        account.deposit(0);
        account.withdraw(100.00);
        account.withdraw(1000.00);
        account.withdraw(-50.00);

        System.out.println("Final account state: " + account);
    }
}
