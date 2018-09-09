package ex7;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class LoanMonthlyDao {

    public List<LoanMonthly> getLoanMonthlyParams (BigDecimal loan, double profit, int months) {
        int month = 0;
        double rate = 0;
        double loanLeft = 0;
        LoanMonthly data = new LoanMonthly(month, rate, loanLeft);
        List<LoanMonthly> loanParams = new ArrayList<>();

        for (int i = 1; i <= months; i++){
            data.getMonth(months);
            data.getRate(loan, months, profit);
            data.getLoanLeft(loan, months, profit);
        }

        loanParams.add(data);
        return loanParams;
    }

}
