package software.ulpgc.moneycalculator.Model;

public record Money(Double amount, Currency currency) {
    @Override
    public String toString() {
        return String.format("%.2f", amount) + " " + currency;
    }
}
