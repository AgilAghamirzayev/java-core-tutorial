package oop.abstraction.interfaces;

public class TaxReport {
    private final TaxCalculator calculator;

    public TaxReport(TaxCalculator calculator) {
        this.calculator = calculator;
    }

    public void show() {
        double tax = calculator.calculateTax();
        System.out.println(tax);
    }


}
