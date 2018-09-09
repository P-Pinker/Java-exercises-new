package ex7;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class LoanMonthly {

    private int month;
    private double rate;
    private double loanLeft;

    public LoanMonthly(int month, double rate, double loanLeft) {
        this.month = month;
        this.rate = rate;
        this.loanLeft = loanLeft;
    }

    public List<Integer> getMonth (int numberOfMonths) {
        List<Integer> months = new ArrayList<>();
        for (int i = 1; i <= numberOfMonths; i++){
            months.add(i);
        }
        return months;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public List<Double> getRate (BigDecimal loan, int numberOfMonths, double profit) {
        double loanDouble = loan.doubleValue();
        double rate = (double) (loanDouble + (loanDouble * profit / 100)) / numberOfMonths;
        List<Double> rates = new ArrayList<>();

        for (int i = 0; i < numberOfMonths; i++) {
            double remainingAmount = loanDouble - (rate * i);
            if (remainingAmount <= 0) {
                rates.add(0.00);
            } else if (rate >= remainingAmount) {
                rates.add(remainingAmount);
            } else {
                rates.add(rate);
            }
        }
        return rates;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public List<Double> getLoanLeft (BigDecimal loan, int numberOfMonths, double profit) {
        double loanDouble = loan.doubleValue();
        double rate = (double) (loanDouble + (loanDouble * profit / 100)) / numberOfMonths;
        double remainingAmount;
        List<Double> RemainingAmountToPayBackMonthly = new ArrayList<>();

        for (int i = 0; i < numberOfMonths; i++) {
            remainingAmount = loanDouble - (rate * i);
            if (remainingAmount <= 0){
                RemainingAmountToPayBackMonthly.add(0.00);
            } else {
                RemainingAmountToPayBackMonthly.add(remainingAmount);
            }
        }

        return RemainingAmountToPayBackMonthly;
    }

    public void setLoanLeft(double loanLeft) {
        this.loanLeft = loanLeft;
    }

    @Override
    public String toString() {
        return "LoanMonthly{" +
                "month=" + month +
                ", rate=" + rate +
                ", loanLeft=" + loanLeft +
                '}';
    }

}
