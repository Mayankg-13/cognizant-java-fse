public class FinancialForecasting {

    public static double calculateFutureValue(double presentValue, double growthRate, int years) {
        if (years == 0) {
            return presentValue;
        }
        if (years < 0) {
            throw new IllegalArgumentException("Years cannot be negative");
        }
        return calculateFutureValue(presentValue, growthRate, years - 1) * (1 + growthRate);
    }

    public static double calculateFutureValueMemoized(double presentValue, double growthRate, int years, double[] memo) {
        if (years < 0) {
            throw new IllegalArgumentException("Years cannot be negative");
        }
        if (years == 0) {
            return presentValue;
        }
        if (memo[years] != 0.0) {
            return memo[years];
        }
        memo[years] = calculateFutureValueMemoized(presentValue, growthRate, years - 1, memo) * (1 + growthRate);
        return memo[years];
    }

    public static double calculateFutureValueIterative(double presentValue, double growthRate, int years) {
        if (years < 0) {
            throw new IllegalArgumentException("Years cannot be negative");
        }
        double futureValue = presentValue;
        for (int i = 0; i < years; i++) {
            futureValue *= (1 + growthRate);
        }
        return futureValue;
    }

    public static double calculateFutureValueWithRates(double presentValue, double[] growthRates, int years) {
        if (years < 0 || years > growthRates.length) {
            throw new IllegalArgumentException("Invalid year target");
        }
        if (years == 0) {
            return presentValue;
        }
        return calculateFutureValueWithRates(presentValue, growthRates, years - 1) * (1 + growthRates[years - 1]);
    }
}
