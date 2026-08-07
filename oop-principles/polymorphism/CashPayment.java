package polymorphism;

public class CashPayment extends Payment {
    private double cashReceived;

    public CashPayment(double amount, double cashReceived) {
        super(amount);
        this.cashReceived = cashReceived;
    }

    public double getCashReceived() {
        return cashReceived;
    }

    public void setCashReceived(double cashReceived) {
        this.cashReceived = cashReceived;
    }

    public double calculateChange() {
        if (cashReceived < getAmount()) {
            return 0;
        }

        return cashReceived - getAmount();
    }

    @Override
    public void processPayment() {
        if (cashReceived < getAmount()) {
            System.out.println("Cash payment declined. The cash received is less than the amount owed.");
            return;
        }

        System.out.println("Processing cash payment of R" + getAmount()
                + ". Change: R" + calculateChange());
    }

    @Override
    public String toString() {
        return "CashPayment{amount=R" + getAmount() + ", cashReceived=R" + cashReceived + "}";
    }
}
