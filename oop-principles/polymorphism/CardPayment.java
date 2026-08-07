package polymorphism;

public class CardPayment extends Payment {
    private String cardLastFourDigits;

    public CardPayment(double amount, String cardLastFourDigits) {
        super(amount);
        this.cardLastFourDigits = cardLastFourDigits;
    }

    public String getCardLastFourDigits() {
        return cardLastFourDigits;
    }

    public void setCardLastFourDigits(String cardLastFourDigits) {
        this.cardLastFourDigits = cardLastFourDigits;
    }

    @Override
    public void processPayment() {
        System.out.println("Processing card payment of R" + getAmount()
                + " using card ending in " + cardLastFourDigits + ".");
    }

    @Override
    public String toString() {
        return "CardPayment{amount=R" + getAmount() + ", cardLastFourDigits='" + cardLastFourDigits + "'}";
    }
}
