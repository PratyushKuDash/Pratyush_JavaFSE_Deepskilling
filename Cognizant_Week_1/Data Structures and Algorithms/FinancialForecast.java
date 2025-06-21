public class FinancialForecast {

    public static double futureValueRecursive(double principal, double rate, int years) {
        if (years == 0) {
            return principal;
        }
        return futureValueRecursive(principal, rate, years - 1) * (1 + rate);
    }

    public static double futureValueMemoized(double principal, double rate, int years, Double[] memo) {
        if (years == 0) return principal;

        if (memo[years] != null) {
            return memo[years];
        }

        memo[years] = futureValueMemoized(principal, rate, years - 1, memo) * (1 + rate);
        return memo[years];
    }

    public static void main(String[] args) {
        double principal = 10000; 
        double rate = 0.10;       
        int years = 5;

        System.out.println("---- Financial Forecasting ----");
        System.out.println("Principal: ₹" + principal);
        System.out.println("Growth Rate: " + (rate * 100) + "% per year");
        System.out.println("Years: " + years);

        double futureValueRec = futureValueRecursive(principal, rate, years);
        System.out.printf("\nFuture Value (Recursive): ₹%.2f\n", futureValueRec);

        Double[] memo = new Double[years + 1];
        double futureValueMemo = futureValueMemoized(principal, rate, years, memo);
        System.out.printf("Future Value (Memoized): ₹%.2f\n", futureValueMemo);
    }
}
