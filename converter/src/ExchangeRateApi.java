import java.util.Map;

public record ExchangeRateApi(String base_code, Map<String, Double> conversion_rates) {
    @Override
    public String toString() {
        return  "Currency Code: " + base_code +
                "\nValue Conversions: " + conversion_rates;
    }

    public Map<String, Double> conversionRates() {
        return conversion_rates;
    }
}