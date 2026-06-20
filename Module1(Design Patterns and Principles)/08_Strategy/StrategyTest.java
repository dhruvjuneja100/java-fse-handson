public class StrategyTest {
    public static void main(String[] args) {
        PaymentContext context = new PaymentContext(new CreditCardPayment("4111111111111234"));
        context.executePayment(2500.00);

        context.setStrategy(new PayPalPayment("dhruv@example.com"));
        context.executePayment(1500.00);
    }
}
