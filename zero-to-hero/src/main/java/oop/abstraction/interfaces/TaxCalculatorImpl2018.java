package oop.abstraction.interfaces;

public class TaxCalculatorImpl2018 implements TaxCalculator {
    private double taxableIncome;

    public TaxCalculatorImpl2018(double taxableIncome) {
        this.taxableIncome = taxableIncome;
    }

    @Override
    public double calculateTax(){
        return taxableIncome * 0.3;
    }
}
