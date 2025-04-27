//import java.util.Scanner;
//
//public class CurrencyConverter {
//    public static void main(String[] args) {
//        ValueConsult newConsult = new ValueConsult();
//        Scanner scanner = new Scanner(System.in);
//
//        while (true) {
//            System.out.println("\nCURRENCY CONVERTER:");
//
//            System.out.println("1 - BRL > USD");
//            System.out.println("2 - USD > BRL");
//            System.out.println("3 - Close");
//            System.out.println("Choose an option:");
//
//            int choice = scanner.nextInt();
//            scanner.nextLine();
//
//            switch (choice) {
//                case 1:
//                    doConvertion(newConsult, "USD");
//                    break;
//                case 2:
//                    doConvertion(newConsult, "BRL");
//                    break;
//                case 3:
//                    System.out.println("Closing program...");
//                    return;
//                default:
//                    System.out.println("Invalid option! Try again.");
//            }
//        }
//    }
//
//    private static void doConvertion(ValueConsult consult, String consultDestination) {
//        ExchangeRateApi currencyConsult = consult.valueConsult("BRL");
//
//        if (currencyConsult != null && currencyConsult.conversionRates() != null) {
//            Double exchangeRate = (Double) currencyConsult.conversionRates().get(consultDestination);
//
//            if (exchangeRate != null) {
//                double brlValue;
//                double usdValue;
//
//                Scanner scanner = new Scanner(System.in);
//
//                System.out.println("Value to convert: ");
//
//                if (consultDestination.equals("USD")) {
//                    brlValue = scanner.nextDouble();
//                    double valueConverted = brlValue * exchangeRate;
//                    System.out.println("The value of " + String.format("%.2f", brlValue) + " BRL" + " converted to " + consultDestination +
//                            " with an Exchange rate of: " + exchangeRate + " is: " + String.format("%.2f", valueConverted));
//                    System.out.println("\n");
//                }
//
//                if (consultDestination.equals("BRL")) {
//                    usdValue = scanner.nextDouble();
//                    double valueConverted2 = usdValue * exchangeRate;
//                    System.out.println("The value of " + String.format("%.2f", usdValue) + " USD" + " converted to " + consultDestination +
//                            " with an Exchange rate of: " + exchangeRate + " is: " + String.format("%.2f", valueConverted2));
//                    System.out.println("\n");
//                }
//
//            } else {
//                System.out.println("Exchange rate for " + consultDestination + " not available.");
//                System.out.println("\n");
//            }
//        } else {
//            System.out.println("Error getting exchange rates.");
//            System.out.println("\n");
//        }
//    }
//}

import java.util.Map;
import java.util.Scanner;

public class CurrencyConverter {

    // Define currency codes as constants
    private static final String USD = "USD";
    private static final String BRL = "BRL";

    public static void main(String[] args) {
        ValueConsult newConsult = new ValueConsult();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nCURRENCY CONVERTER:");

            System.out.println("1 - BRL > USD");
            System.out.println("2 - USD > BRL");
            System.out.println("3 - Close");
            System.out.println("Choose an option:");

            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // Clear invalid input
                continue;
            }

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline left-over

            switch (choice) {
                case 1:
                    doConversion(newConsult, scanner, BRL, USD);
                    break;
                case 2:
                    doConversion(newConsult, scanner, USD, BRL);
                    break;
                case 3:
                    System.out.println("Closing program...");
                    scanner.close(); // Close the scanner to prevent resource leak
                    return;
                default:
                    System.out.println("Invalid option! Try again.");
            }
        }
    }

    private static void doConversion(ValueConsult consult, Scanner scanner, String sourceCurrency, String targetCurrency) {
        ExchangeRateApi currencyConsult = consult.valueConsult(sourceCurrency);

        if (currencyConsult != null && currencyConsult.conversionRates() != null) {
            Double exchangeRate = (Double) currencyConsult.conversionRates().get(targetCurrency);

            if (exchangeRate != null) {
                System.out.println("Value to convert from " + sourceCurrency + ": ");

                if (!scanner.hasNextDouble()) {
                    System.out.println("Invalid input. Please enter a valid number.");
                    scanner.next(); // Clear invalid input
                    return;
                }

                double valueToConvert = scanner.nextDouble();
                scanner.nextLine(); // Consume newline left-over

                double convertedValue = valueToConvert * exchangeRate;
                System.out.printf("The value of %.2f %s converted to %s with an exchange rate of %.2f is: %.2f%n",
                        valueToConvert, sourceCurrency, targetCurrency, exchangeRate, convertedValue);
                System.out.println();
            } else {
                System.out.println("Exchange rate for " + targetCurrency + " not available.");
                System.out.println();
            }
        } else {
            System.out.println("Error getting exchange rates.");
            System.out.println();
        }
    }
}1