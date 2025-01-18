package software.ulpgc.moneycalculator.swing;

import software.ulpgc.moneycalculator.Model.Money;
import software.ulpgc.moneycalculator.View.MoneyDisplay;

import javax.swing.*;

public class SwingMoneyDisplay extends JLabel implements MoneyDisplay {
    @Override
    public void show(Money money) {
        try {
            this.setText(money.toString());
        }
        catch (Exception e)
        {
            this.setText("Inserte un valor correcto");
        }
    }
}
