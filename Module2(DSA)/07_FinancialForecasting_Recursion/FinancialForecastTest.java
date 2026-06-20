public class FinancialForecastTest {
    public static void main(String[] args) {
        double presentValue = 100000.00; 
        double growthRate = 0.08;      
        int years = 10;

        double recursiveResult = FinancialForecaster.futureValueRecursive(presentValue, growthRate, years);
        double iterativeResult = FinancialForecaster.futureValueIterative(presentValue, growthRate, years);
        double closedFormResult = FinancialForecaster.futureValueClosedForm(presentValue, growthRate, years);

        System.out.printf("Recursive approach   : Rs. %.2f%n", recursiveResult);
        System.out.printf("Iterative approach    : Rs. %.2f%n", iterativeResult);
        System.out.printf("Closed-form approach  : Rs. %.2f%n", closedFormResult);

        System.out.println("\nAll three approaches should produce (approximately) the same result,");
        System.out.println("since they're just different ways of computing the same compound growth formula.");
    }
}
