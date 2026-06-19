public class ForecastingTest {
    public static void main(String[] args) {
        double initialValue = 1000.0;
        double growthRate = 0.05;
        int targetYears = 10;

        System.out.println("=================================================");
        System.out.println("   Financial Forecasting Tool - Testing Suite    ");
        System.out.println("=================================================");
        System.out.printf("Initial Value (PV): $%,.2f\n", initialValue);
        System.out.printf("Annual Growth Rate: %.1f%%\n", growthRate * 100);
        System.out.printf("Forecasting Horizon: %d years\n", targetYears);
        System.out.println("=================================================");

        System.out.println("\n1. Naive Recursive Approach Output:");
        System.out.println("-------------------------------------------------");
        System.out.printf("%-6s | %-15s\n", "Year", "Future Value");
        System.out.println("-------------------------------------------------");
        for (int y = 0; y <= targetYears; y++) {
            double fv = FinancialForecasting.calculateFutureValue(initialValue, growthRate, y);
            System.out.printf("Year %-2d | $%,.2f\n", y, fv);
        }

        System.out.println("\n2. Memoized Recursive Approach Output:");
        System.out.println("-------------------------------------------------");
        System.out.printf("%-6s | %-15s\n", "Year", "Future Value");
        System.out.println("-------------------------------------------------");
        double[] memo = new double[targetYears + 1];
        for (int y = 0; y <= targetYears; y++) {
            double fv = FinancialForecasting.calculateFutureValueMemoized(initialValue, growthRate, y, memo);
            System.out.printf("Year %-2d | $%,.2f\n", y, fv);
        }

        System.out.println("\n3. Iterative Approach Output:");
        System.out.println("-------------------------------------------------");
        System.out.printf("%-6s | %-15s\n", "Year", "Future Value");
        System.out.println("-------------------------------------------------");
        for (int y = 0; y <= targetYears; y++) {
            double fv = FinancialForecasting.calculateFutureValueIterative(initialValue, growthRate, y);
            System.out.printf("Year %-2d | $%,.2f\n", y, fv);
        }

        System.out.println("\n4. Prediction Based on Varying Annual Growth Rates:");
        System.out.println("-------------------------------------------------");
        double[] pastGrowthRates = {0.03, 0.045, -0.012, 0.058, 0.062};
        
        System.out.printf("Initial investment: $%,.2f\n", initialValue);
        System.out.print("Simulated Annual Rates: ");
        for (int i = 0; i < pastGrowthRates.length; i++) {
            System.out.printf("Yr %d: %.1f%%  ", i + 1, pastGrowthRates[i] * 100);
        }
        System.out.println("\n-------------------------------------------------");
        System.out.printf("%-6s | %-12s | %-15s\n", "Year", "Growth Rate", "Future Value");
        System.out.println("-------------------------------------------------");
        System.out.printf("Year 0 | %-12s | $%,.2f\n", "Starting", initialValue);
        for (int y = 1; y <= pastGrowthRates.length; y++) {
            double fv = FinancialForecasting.calculateFutureValueWithRates(initialValue, pastGrowthRates, y);
            System.out.printf("Year %-2d | %+.1f%%       | $%,.2f\n", y, pastGrowthRates[y - 1] * 100, fv);
        }
        System.out.println("=================================================");
    }
}
