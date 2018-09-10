package ex7;

import java.math.BigDecimal;
import java.util.*;

public class LoanMonthlyDao {

    public List<LoanMonthly> getLoanMonthlyParams(BigDecimal loan, double profit, int months) {

        List<LoanMonthly> loanParams = new ArrayList<>();
        double loanDouble = loan.doubleValue();

        for (int i = 0; i < months; i++) {

                double rate = (double) (loanDouble + (loanDouble * profit / 100)) / months;
                double loanLeft = loanDouble - (rate * i);

                if (loanLeft <= 0) {
                    rate = 0.00;
                    loanLeft = 0.00;
                } else if (rate >= loanLeft) {
                    rate = loanLeft;
                }

                LoanMonthly month = new LoanMonthly(i+1, rate, loanLeft);
                loanParams.add(month);

            }

        return loanParams;

    }

}