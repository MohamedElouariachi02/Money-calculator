package software.ulpgc.moneycalculator.swing;

import software.ulpgc.moneycalculator.Model.Money;
import software.ulpgc.moneycalculator.View.MoneyDisplay;

import javax.swing.*;

public class SwingMoneyDisplay extends JLabel implements MoneyDisplay {
    @Override
    public void show(Money money) {
        this.setText(money.toString());
    }
}
