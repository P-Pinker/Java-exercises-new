package ex7;

public class LoanMonthly {

    private int month;
    private double rate;
    private double loanLeft;

    public LoanMonthly(int month, double rate, double loanLeft) {
        this.month = month;
        this.rate = rate;
        this.loanLeft = loanLeft;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public double getLoanLeft() {
        return loanLeft;
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
