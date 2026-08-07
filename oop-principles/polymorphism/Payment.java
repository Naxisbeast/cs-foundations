package polymorphism;

public abstract class Payment {
    private double amount;

    public Payment(double amount) {
        if (amount < 0) {
            System.out.println("Payment amount cannot be negative. I will store it as 0.");
            this.amount = 0;
        } else {
            this.amount = amount;
        }
    }

    public double getAmount() {
        return amount;
    }

    public void printReceipt() {
        System.out.println("Receipt amount: R" + amount);
    }

    public void printReceipt(String referenceNumber) {
        System.out.println("Receipt " + referenceNumber + " amount: R" + amount);
    }

    public abstract void processPayment();

    @Override
    public String toString() {
        return "Payment{amount=R" + amount + "}";
    }
}
