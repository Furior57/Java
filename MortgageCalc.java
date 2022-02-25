package com.java.calc;

import java.util.Scanner;

public class MortgageCalc {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("Введите количество членов семьи: ");
        int familyCount = scan.nextInt();

        System.out.println("Введите месячный доход семьи: ");
        int familyIncome = scan.nextInt();

        System.out.println("Введите желаемый размер кредита: ");
        int creditAmount = scan.nextInt();

        System.out.println("Введите процентную ставку: ");
        int creditPercent = scan.nextInt();

        System.out.println("Введите количество лет на которое берете кредит: ");
        int creditYears = scan.nextInt();

        Calculator c = new Calculator(creditAmount, creditPercent, creditYears);


        double incomeBarrier = switch (familyCount) {
            case 1 -> 0.5;
            case 2 -> 0.45;
            case 3 -> 0.35;
            case 4 -> 0.3;
            case 5 -> 0.25;
            default -> 0.0;
        };

        if (c.payment() / familyIncome >= incomeBarrier) {
            System.out.println("Выш уровень дохода не позволяет взять кредит на такой срок,\n" +
                    "пожалуйста, увеличьте срок или увеличьте уровень дохода.");
            System.exit(0);
        } else {
            System.out.println("Вам одобрен кредит, график платежей: \n");
            c.calculatedAndPrint();
        }


    }


}