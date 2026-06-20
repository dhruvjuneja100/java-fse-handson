public class FinancialForecaster {

    public static double futureValueRecursive(double presentValue, double growthRate, int years) {
        if (years < 0) {
            throw new IllegalArgumentException("years must be >= 0");
        }
        if (years == 0) {
            return presentValue; 
        }
        return futureValueRecursive(presentValue, growthRate, years - 1) * (1 + growthRate);
    }

   
    public static double futureValueIterative(double presentValue, double growthRate, int years) {
        double value = presentValue;
        for (int i = 0; i < years; i++) {
            value *= (1 + growthRate);
        }
        return value;
    }

    public static double futureValueClosedForm(double presentValue, double growthRate, int years) {
        return presentValue * Math.pow(1 + growthRate, years);
    }
}
