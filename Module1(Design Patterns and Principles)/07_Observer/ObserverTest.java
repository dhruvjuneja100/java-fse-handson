public class ObserverTest {
    public static void main(String[] args) {
        StockMarket stockMarket = new StockMarket();

        Observer mobileApp = new MobileApp();
        Observer webApp = new WebApp();

        stockMarket.registerObserver(mobileApp);
        stockMarket.registerObserver(webApp);

        System.out.println("--- Price update #1 ---");
        stockMarket.setStockPrice("TCS", 3925.50);

        System.out.println("\n--- Deregistering MobileApp ---");
        stockMarket.deregisterObserver(mobileApp);

        System.out.println("\n--- Price update #2 (only WebApp should be notified) ---");
        stockMarket.setStockPrice("TCS", 3940.00);
    }
}
