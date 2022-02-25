package com.java.calc;

public class Calculator {
    private static final int MONTH = 12;
    private final float LOAN_AMOUNT;
    private final int YEARS;
    private final float EXTRA_PAYMENT;
    private final float STARTING_BALANCE;
    private final double MONTHLY_PERCENT;

    public Calculator(float loanAmount, float interestRate, int YEARS) {
        this(loanAmount, interestRate, YEARS, 0);
    }

    public Calculator(float LOAN_AMOUNT, float interestRate, int YEARS, float EXTRA_PAYMENT) {
        this.LOAN_AMOUNT = LOAN_AMOUNT;
        this.YEARS = YEARS;
        this.EXTRA_PAYMENT = EXTRA_PAYMENT;
        this.MONTHLY_PERCENT = interestRate / MONTH / 100;
        this.STARTING_BALANCE = LOAN_AMOUNT;

    }

    public double payment() {
        return ((LOAN_AMOUNT * MONTHLY_PERCENT /
                (1 - Math.pow((1 + MONTHLY_PERCENT), -1 * MONTH * YEARS))));
    }

    public void calculatedAndPrint() {
        int periodCount = 1;
        double monthStartBalance = STARTING_BALANCE;
        double payment = payment();
        double monthEndBalance = monthStartBalance;
        double interestAmount = 0;


        System.out.println("МЕСЯЦ,  БАЛАНС НА НАЧАЛО,  ПЛАТЕЖ,  ПРОЦЕНТНАЯ СТАВКА,  ТЕЛО ПЛАТЕЖА,  БАЛАНС НА КОНЕЦ,  ОБЩАЯ ПЕРЕПЛАТА");

        while (periodCount <= YEARS * MONTH && monthEndBalance>0) {

            double monthlyInterest = monthStartBalance*MONTHLY_PERCENT;
            double monthlyPrincipal = EXTRA_PAYMENT + payment()-monthlyInterest;
            monthEndBalance = monthStartBalance - monthlyPrincipal;

            if (monthStartBalance < payment) {
                payment = monthStartBalance;
                monthlyPrincipal = payment-monthlyInterest;
                monthEndBalance = monthStartBalance - payment;
            }

            if (periodCount > 9 && periodCount<=99) {
                System.out.printf("%d, %14.2f, %13.2f, %12.2f, %16.2f, %15.2f, %15.2f%n", periodCount, monthStartBalance,
                        payment, monthlyInterest, monthlyPrincipal, monthEndBalance, interestAmount = interestAmount + monthlyInterest);
            } else if (periodCount > 99) {
                System.out.printf("%d, %13.2f, %13.2f, %12.2f, %16.2f, %15.2f, %15.2f%n", periodCount, monthStartBalance,
                        payment, monthlyInterest, monthlyPrincipal, monthEndBalance, interestAmount = interestAmount + monthlyInterest);
            }else {
                System.out.printf("%d, %15.2f, %13.2f, %12.2f, %16.2f, %15.2f, %15.2f%n", periodCount, monthStartBalance,
                        payment, monthlyInterest, monthlyPrincipal, monthEndBalance, interestAmount = interestAmount + monthlyInterest);
            }
            monthStartBalance = monthEndBalance;
            ++periodCount;
        }

    }

}

