package polymorphism;

public class PaymentTest {
    public static void main(String[] args) {
        Payment cardPayment = new CardPayment(250.00, "4821");
        Payment cashPayment = new CashPayment(120.00, 150.00);
        Payment shortCashPayment = new CashPayment(200.00, 100.00);

        // I use the Payment type to show polymorphism.
        Payment[] payments = {cardPayment, cashPayment, shortCashPayment};

        for (Payment payment : payments) {
            payment.processPayment();
            payment.printReceipt();
            payment.printReceipt("REF-001");
            System.out.println(payment);
            System.out.println();
        }
    }
}
