package software.ulpgc.moneycalculator.fixerws;

import software.ulpgc.moneycalculator.Control.CurrencyLoader;
import software.ulpgc.moneycalculator.Model.Currency;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        CurrencyLoader currencyLoader = new FixerCurrencyLoader();
        List<Currency> currencies = currencyLoader.load();
        for (Currency currency : currencies) {
            System.out.println(currency);
        }
        FixerExchangeRateLoader prueba = new FixerExchangeRateLoader();
        prueba.load(currencies.get(0), currencies.get(1));
    }
}
