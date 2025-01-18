package software.ulpgc.moneycalculator.Control;

import software.ulpgc.moneycalculator.Model.Currency;
import software.ulpgc.moneycalculator.Model.ExchangeRate;
import software.ulpgc.moneycalculator.Model.Money;
import software.ulpgc.moneycalculator.View.CurrencyDialog;
import software.ulpgc.moneycalculator.View.MoneyDialog;
import software.ulpgc.moneycalculator.View.MoneyDisplay;

public class ExchangeMoneyCommand implements Command{
    private final MoneyDialog moneyDialog;
    private final CurrencyDialog currencyDialog;
    private final ExchangeRateLoader exchangeRateLoader;
    private final MoneyDisplay moneyDisplay;

    public ExchangeMoneyCommand(MoneyDialog moneyDialog, CurrencyDialog currencyDialog, ExchangeRateLoader exchangeRateLoader, MoneyDisplay moneyDisplay) {
        this.moneyDialog = moneyDialog;
        this.currencyDialog = currencyDialog;
        this.exchangeRateLoader = exchangeRateLoader;
        this.moneyDisplay = moneyDisplay;
    }

    @Override
    public void execute() {
        try
            {
                Money money = moneyDialog.get();
                Currency currency = currencyDialog.get();
                ExchangeRate exchangeRate = exchangeRateLoader.load(money.currency(), currency);
                Money result = new Money(money.amount() * exchangeRate.rate(), currency);
                moneyDisplay.show(result);
            }
        catch (Exception e)
        {
            moneyDisplay.show(null);
        }


    }
}
