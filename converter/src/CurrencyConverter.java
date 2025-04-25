import java.util.Scanner;

public class CurrencyConverter {
    public static void main(String[] args) {
        ValueConsult newConsult = new ValueConsult();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nCURRENCY CONVERTER:");

            System.out.println("1 - BRL > USD");
            System.out.println("2 - USD > BRL");
            System.out.println("3 - Close");
            System.out.println("Choose an option:");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    doConvertion(newConsult, "USD");
                    break;
                case 2:
                    doConvertion(newConsult, "BRL");
                    break;
                case 3:
                    System.out.println("Closing program...");
                    return;
                default:
                    System.out.println("Invalid option! Try again.");
            }
        }
    }

    private static void doConvertion(ValueConsult consult, String consultDestination) {
        ExchangeRateApi currencyConsult = consult.valueConsult("BRL");

        if (currencyConsult != null && currencyConsult.conversionRates() != null) {
            Double exchangeRate = (Double) currencyConsult.conversionRates().get(consultDestination);

            if (exchangeRate != null) {
                double brlValue;
                Scanner scanner = new Scanner(System.in);

                System.out.println("Value to convert: ");
                brlValue = scanner.nextDouble();

                double valueConverted = brlValue * exchangeRate;
                System.out.println("The value of " + String.format("%.2f", brlValue) + " BRL" + " converted to " + consultDestination +
                        " with an Exchange rate of: " + exchangeRate + " is: " + String.format("%.2f", valueConverted));
                System.out.println("\n");
            } else {
                System.out.println("Exchange rate for " + consultDestination + " not available.");
                System.out.println("\n");
            }
        } else {
            System.out.println("Error getting exchange rates.");
            System.out.println("\n");
        }
    }
}