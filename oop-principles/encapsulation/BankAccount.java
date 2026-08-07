package encapsulation;

public class BankAccount {
    private String accountHolderName;
    private double balance;

    public BankAccount(String accountHolderName, double openingBalance) {
        this.accountHolderName = accountHolderName;
        if (openingBalance < 0) {
            System.out.println("Opening balance cannot be negative. I will start the account at 0.");
            this.balance = 0;
        } else {
            this.balance = openingBalance;
        }
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Deposit amount must be greater than zero.");
            return;
        }

        balance += amount;
        System.out.println("Deposited: R" + amount);
    }

    public void withdraw(double amount) {
        // I check the amount before changing the balance.
        if (amount <= 0) {
            System.out.println("Withdrawal amount must be greater than zero.");
            return;
        }

        if (amount > balance) {
            System.out.println("Withdrawal declined. The amount is larger than the current balance.");
            return;
        }

        balance -= amount;
        System.out.println("Withdrew: R" + amount);
    }

    @Override
    public String toString() {
        return "BankAccount{accountHolderName='" + accountHolderName + "', balance=R" + balance + "}";
    }
}
