package bank.employees;

import java.util.Scanner;

public class Teller {
    private BranchManager branchManager;
    public Teller(BranchManager branchManager){
        this.branchManager = branchManager;
    }
    //display menu when user visits the teller
    //we should make some methods that will check if a customer exist
    //if they are already in the system we give them one type of menu
    //if they don't exist we give them another type of menu
    public int displayTellerMenu(Scanner scanner, String customerName){
        int selection = 0;
        boolean validSelection = true;
        do {
            System.out.println("Welcome, " + customerName + ", how may I help you today?");
            System.out.println("----------------------------------------");
            System.out.println("1. Make a new checking account.");
            System.out.println("2. Make a new savings account.");
            System.out.println("3. Deposit money into checking account.");
            System.out.println("4. Deposit money into savings account.");
            System.out.println("5. Withdraw money from checking account.");
            System.out.println("6. Withdraw money from savings account.");
            System.out.println("7. Leave teller.");
            System.out.println("----------------------------------------");
            selection = scanner.nextInt();
            if(selection > 7 || selection < 1)
                validSelection = false;
            else
                validSelection = true;
        }while (!validSelection);
        return selection;
    }

    public void createsNewCheckingAccount(){

    }
}
