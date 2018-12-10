package BankOfficers;

import java.util.Scanner;

public class FinancialAdvisor {

    public int displayFinancialAdvisorMenu(Scanner scanner, String customerName){
        int selection = 0;

        System.out.println("Welcome, " + customerName + ", how may I help you today?");
        System.out.println("----------------------------------------");
        System.out.println("1. Apply for a loan.");
        System.out.println("2. Invest into money market.");
        System.out.println("3. Leave financial advisor.");
        System.out.println("----------------------------------------");

        selection = scanner.nextInt();

        return selection;

    }
}
