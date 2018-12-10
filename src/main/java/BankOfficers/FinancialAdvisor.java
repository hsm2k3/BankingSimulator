package BankOfficers;

import java.util.Scanner;

public class FinancialAdvisor {

    public static int displayFinancialAdvisorMenu(Scanner scanner, String customerName){
        int selection = 0;

        System.out.println("Welcome, " + customerName + ", how may I help you today?");
        System.out.println("----------------------------------------");
        System.out.println("1. Make a new checking account.");
        System.out.println("2. Make a new savings account.");
        System.out.println("3. Leave teller.");
        System.out.println("----------------------------------------");

        selection = scanner.nextInt();

        return selection;

    }
}
