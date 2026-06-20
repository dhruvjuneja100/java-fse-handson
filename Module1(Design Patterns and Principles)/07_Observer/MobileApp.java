public class MobileApp implements Observer {
    @Override
    public void update(String stockSymbol, double price) {
        System.out.println("[MobileApp] Alert: " + stockSymbol + " is now $" + price);
    }
}
