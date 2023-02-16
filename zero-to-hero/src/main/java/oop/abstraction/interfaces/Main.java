package oop.abstraction.interfaces;

public class Main {
    public static void main(String[] args) {
        TaxCalculator calculator = new TaxCalculatorImpl2018(100_000);
        TaxReport taxReport = new TaxReport(calculator);
        taxReport.show();
    }

}
