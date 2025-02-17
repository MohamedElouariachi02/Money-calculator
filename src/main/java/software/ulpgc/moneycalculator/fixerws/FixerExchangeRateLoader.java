package software.ulpgc.moneycalculator.fixerws;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import software.ulpgc.moneycalculator.Model.Currency;
import software.ulpgc.moneycalculator.Model.ExchangeRate;
import software.ulpgc.moneycalculator.Control.ExchangeRateLoader;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.time.LocalDate;

public class FixerExchangeRateLoader implements ExchangeRateLoader {
    @Override
    public ExchangeRate load(Currency from, Currency to) {
        try {
            return createRate(from, to);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private ExchangeRate createRate(Currency from, Currency to) throws IOException {
        URL url = new URL("https://data.fixer.io/api/latest?access_key=" + FixerAPI.key);
        try (InputStream is = url.openStream()) {
            JsonObject rates = getRates(is);
            return new ExchangeRate(from, to, LocalDate.now(), calculateRate(rates.get(from.code()).getAsString(), rates.get(to.code()).getAsString()));
        }
    }

    private static JsonObject getRates(InputStream is) throws IOException {
        String result = new String(is.readAllBytes());
        JsonObject asJsonObject = JsonParser.parseString(result).getAsJsonObject();
        JsonObject rates = asJsonObject.get("rates").getAsJsonObject();
        return rates;
    }

    private double calculateRate(String from, String to) {
        return Double.parseDouble(to)/Double.parseDouble(from);
    }
}
