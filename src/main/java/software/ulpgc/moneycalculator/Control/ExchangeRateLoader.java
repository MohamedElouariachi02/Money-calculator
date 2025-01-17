package software.ulpgc.moneycalculator.Control;

import software.ulpgc.moneycalculator.Model.Currency;
import software.ulpgc.moneycalculator.Model.ExchangeRate;

public interface ExchangeRateLoader {
    ExchangeRate load(Currency from, Currency to);
}
