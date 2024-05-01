package montgageCalculator;

import java.text.NumberFormat;
import java.util.Scanner;

public class calculator {
    public static int principal;
    public static double annualInterest;
    public static int period;



    public static String currencyBalance;

    public calculator(int principal, double annualInterest, int period, String currencyBalance) {
        calculator.principal = principal;
        calculator.annualInterest = annualInterest;
        calculator.period = period;
        calculator.currencyBalance = currencyBalance;

    }
    @Override
    public String toString() {
        return "calculator{}";
    }


    public static void main(String[] args) {



        principal = (int)readValue("principal :", 1000, 1000000);
        annualInterest = readValue("Annual Interest :", 1, 30);
        period = (int)readValue("Period(Years) :", 1, 30);
        final byte percentage = 100;
        final byte annualMonths = 12;
        double monthlyInterest = annualInterest/percentage/annualMonths;
        int numberofPayments = period*annualMonths;


        printMontgage(principal, annualInterest, period, monthlyInterest, numberofPayments);

        printPaymentSchedule(principal, annualInterest, period, monthlyInterest, numberofPayments);


    }
    public static void printPaymentSchedule(int principal, double annualInterest, int period, double monthlyInterest,
                                            int numberofPayments) {
        System.out.println("\nPAYMENT SCHEDULE\n----------------");
        for (short month=1; month<=numberofPayments; month++) {
            double balance = balanceAmount(principal, annualInterest, period, month, monthlyInterest,numberofPayments );
            currencyBalance = NumberFormat.getCurrencyInstance().format(balance);
            System.out.println(currencyBalance);
        }
    }
    private static void printMontgage(int principal, double annualInterest, int period, double monthlyInterest,
                                      int numberofPayments) {
        double mortgage = calculateMortgage(principal, annualInterest, period, monthlyInterest,numberofPayments);

        String currency = NumberFormat.getCurrencyInstance().format(mortgage);

        System.out.println("\nMORTGAGE\n--------");
        System.out.println("Monthly Payments: " + currency);
    }
    public static double readValue(String prompt , double min, double max) {
        Scanner scanner = new Scanner(System.in);
        double value;
        while(true) {
            System.out.print(prompt);
            value = scanner.nextDouble();

            if(value>=min && value<=max)
                break;
            System.out.println("Enter the number between" + min + " and " + max);


        }
        return value;

    }


    public static double calculateMortgage(int principal,
                                           double annualInterest,
                                           int period, double monthlyInterest,int numberofPayments ) {

        double mortgage = principal*((monthlyInterest*Math.pow(1+ monthlyInterest, numberofPayments))/(Math.pow(1+ monthlyInterest, numberofPayments)-1));
        return mortgage;
    }
    public static double balanceAmount(
            int principal,
            double annualInterest,
            int period,
            int numofPaymade, double monthlyInterest,int numberofPayments ) {


        double balance = (principal*((Math.pow(1+monthlyInterest, numberofPayments))-(Math.pow(1+monthlyInterest, numofPaymade))))/(Math.pow(1+monthlyInterest, numberofPayments)-1);
        return balance;

    }

}
