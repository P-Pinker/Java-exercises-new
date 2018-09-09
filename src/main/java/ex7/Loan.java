package ex7;

import java.math.BigDecimal;

public class Loan {

    private BigDecimal loan;
    private double profit;
    private double markup;
    private int months;

    public Loan(BigDecimal loan, double profit, double markup, int months) {
        this.loan = loan;
        this.profit = profit;
        this.markup = markup;
        this.months = months;
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

    public void setMonths(int months) {
        this.months = months;
    }

    public Double getProfit() {
        return profit;
    }

    public void setProfit(double profit) {
        this.profit = profit;
    }

    public Double getMarkup() {
        return markup;
    }

    public void setMarkup(double markup) { this.markup = markup; }

    @Override
    public String toString() {
        return "Loan{" +
                "loan=" + loan +
                ", profit=" + profit +
                ", markup=" + markup +
                ", months=" + months +
                '}';
    }

}