import java.util.Scanner;

public class StockValuationCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input: Enter stock information
        System.out.print("Enter the expected annual free cash flow (FCF) for the company: $");
        double expectedFCF = scanner.nextDouble();

        System.out.print("Enter the expected growth rate of FCF (as a decimal, e.g., 0.05 for 5%): ");
        double growthRate = scanner.nextDouble();

        System.out.print("Enter the discount rate (as a decimal, e.g., 0.10 for 10%): ");
        double discountRate = scanner.nextDouble();

        // Calculate the intrinsic value using DCF analysis
        double intrinsicValue = calculateIntrinsicValue(expectedFCF, growthRate, discountRate);

        // Output: Display the result
        System.out.println("The intrinsic value of the stock is $" + intrinsicValue);

        // Determine if the stock is overvalued or undervalued
        double currentStockPrice = getCurrentStockPriceFromUser();

        if (currentStockPrice > intrinsicValue) {
            System.out.println("The stock is overvalued.");
        } else if (currentStockPrice < intrinsicValue) {
            System.out.println("The stock is undervalued.");
        } else {
            System.out.println("The stock is fairly valued.");
        }
    }

    public static double calculateIntrinsicValue(double expectedFCF, double growthRate, double discountRate) {
        // DCF formula: Intrinsic Value = FCF / (discount rate - growth rate)
        return expectedFCF / (discountRate - growthRate);
    }

    public static double getCurrentStockPriceFromUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the current stock price: $");
        return scanner.nextDouble();
    }
}

