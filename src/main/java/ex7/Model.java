package ex7;

import java.math.BigDecimal;

public class Model {

    private BigDecimal loan;
    private Integer months;
    private Double profit;
    private Double commission;

    public Model(BigDecimal loan, Integer months, Double profit, Double commission) {
        this.loan = loan;
        this.months = months;
        this.profit = profit;
        this.commission = commission;
    }

    public BigDecimal getLoan() {
        return loan;
    }

    public void setLoan(BigDecimal loan) {
        this.loan = loan;
    }

    public Integer getMonths() {
        return months;
    }

    public void setMonths(Integer months) {
        this.months = months;
    }

    public Double getProfit() {
        return profit;
    }

    public void setProfit(Double profit) {
        this.profit = profit;
    }

    public Double getCommission() {
        return commission;
    }

    public void setCommission(Double commission) {
        this.commission = commission;
    }
}
