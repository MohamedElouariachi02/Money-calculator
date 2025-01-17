package software.ulpgc.moneycalculator.fixerws;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import software.ulpgc.moneycalculator.Control.ExchangeRateLoader;
import software.ulpgc.moneycalculator.Model.Currency;
import software.ulpgc.moneycalculator.Model.ExchangeRate;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.time.LocalDate;

public class FixerExchangeRateLoader implements ExchangeRateLoader {
    @Override
    public ExchangeRate load(Currency from, Currency to) {
        return null;
    }
}
