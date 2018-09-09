package ex7;

import java.math.BigDecimal;

public class LoanDao {

    public Double getAnnualPercentageRate (double profit) {
        return profit * 12;
    }

    public Double getTotalCostOfCredit (BigDecimal loan, double profit, double markup) {
        double loanDouble = loan.doubleValue();
        return loanDouble + (loanDouble * profit / 100) + (loanDouble * markup / 100);
    }

}
