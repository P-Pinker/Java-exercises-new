package ex7;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ModelDao {

    public List<Integer> getMonth (int numberOfMonths) {
        List<Integer> months = new ArrayList<>();
        for (int i = 1; i <= numberOfMonths; i++){
            months.add(i);
        }
        return months;
    }

    public Double getRate (BigDecimal loan, int numberOfMonths, double profit) {
        double loanDouble = loan.doubleValue();
        return (double) (loanDouble + (loanDouble * profit / 100)) / numberOfMonths;
    }

    public List<Double> getRemainingAmmountToPaybackMonthly (BigDecimal loan, int numberOfMonths, double profit) {
        double loanDouble = loan.doubleValue();
        double rate = (double) (loanDouble + (loanDouble * profit / 100)) / numberOfMonths;
        double remainingAmount;
        List<Double> RemainingAmountToPayBackMonthly = new ArrayList<>();

        for (int i = 1; i <= numberOfMonths; i++) {
            remainingAmount = loanDouble - rate;
            RemainingAmountToPayBackMonthly.add(remainingAmount);
        }

        return RemainingAmountToPayBackMonthly;
    }

    public Double getAnnualPercentageRate (double profit) {
        return profit * 12;
    }

    public Double getTotalCostOfCredit (BigDecimal loan, double profit, double markup) {
        double loanDouble = loan.doubleValue();
        return loanDouble + (loanDouble * profit / 100) + (loanDouble * markup / 100);
    }

}
