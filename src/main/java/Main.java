//Authors:
//Alex Braverman
//Muhammad Khalil
//

import bank.employees.BranchManager;
import bank.employees.FinancialAdvisor;
import bank.employees.Teller;
import customer.Customer;
import org.joda.time.*;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import bank.Bank;
import sqliteDatabase.SQLiteDatabase;

public class Main {
    private static final int EXIT = 0;
    private static final int TELLER = 1;
    private static final int FINANCIAL_ADVISOR = 2;
    private static final int MAKE_CHECKING_ACCOUNT = 1;
    private static final int MAKE_SAVINGS_ACCOUNT = 2;
    private static final int DEPOSIT_CHECKING = 3;
    private static final int DEPOSIT_SAVINGS = 4;
    private static final int WITHDRAW_CHECKING = 5;
    private static final int WITHDRAW_SAVINGS = 6;
    private static final int LEAVE_TELLER = 7;

    //we might need to have other classes access these data types
    protected static String CUSTOMER_NAME = null;
    protected static String CUSTOMER_DOB = null;

    public static void main(String args[]) throws ParseException {
        int selection = 0, tellerSelection = 0, financialAdvisorSelection = 0;
        SQLiteDatabase sqLiteDatabase = new SQLiteDatabase();
        Bank bank = new Bank(sqLiteDatabase);
        BranchManager branchManager = new BranchManager(bank);
        Teller teller = new Teller(branchManager);
        FinancialAdvisor financialAdvisor = new FinancialAdvisor(branchManager);
        Customer customer = new Customer();
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        LocalDate todaysDate = new LocalDate();
        DateTime firstDate = new DateTime(1996, 4, 9, 0, 0);
        DateTime secondDate = new DateTime();
        Scanner scanner = new Scanner(System.in);
        secondDate.getChronology();

        LocalDateTime currentTime = new LocalDateTime();



        Period period = new Period(firstDate, secondDate);
//        System.out.println(currentTime);
//        System.out.println(secondDate.getDayOfMonth());
//        System.out.println(period.getYears());
        bank.connectToDatabase();
        CUSTOMER_NAME = customer.setCustomerName(scanner);
        CUSTOMER_DOB = customer.setCustomerDOB(scanner,dateFormat);
        selection = displayMenu(scanner);

        switch (selection) {
            case TELLER:
                tellerSelection = teller.displayTellerMenu(scanner, CUSTOMER_NAME);
                switch(tellerSelection) {
                    case MAKE_CHECKING_ACCOUNT:
                        //call on the bank manager to make a new account
                        break;
                    case MAKE_SAVINGS_ACCOUNT:
                        //call on the bank manager to make a new account
                        break;
                    case DEPOSIT_CHECKING:
                        //call on bank manager to deposit
                        break;
                    case DEPOSIT_SAVINGS:
                        //call on bank manager to deposit
                        break;
                    case WITHDRAW_CHECKING:
                        break;
                    case WITHDRAW_SAVINGS:
                        break;
                    case LEAVE_TELLER:
                        break;
                    default:
                        break;
                }
                break;
            case FINANCIAL_ADVISOR:
                financialAdvisorSelection = financialAdvisor.displayFinancialAdvisorMenu(scanner,CUSTOMER_NAME);
                switch(financialAdvisorSelection){
                    //Financial advisor methods used here
                }
                break;
            case EXIT:
                System.exit(0);
                break;
            default:
                System.out.println("oops something went wrong!");
                break;
        }
    }

    //display main menu when user enters the bank
    public static int displayMenu(Scanner scanner){
        int selection = 0;
        boolean validEntry = true;

        do {
            //user is prompted to visit the teller or financial advisor
            System.out.println("Welcome, " + CUSTOMER_NAME + ", to CSI bank simulator.");
            System.out.println("----------------------------------------");
            System.out.println("Please make a selection from the menu:");
            System.out.println("1. Go to teller.");
            System.out.println("2. Go to financial advisor.");
            System.out.println("3. Exit simulator.");
            System.out.println("----------------------------------------");
            System.out.println();
            try {
                selection = scanner.nextInt();
            } catch (Exception e) {
                selection = EXIT;
            }
            scanner.nextLine(); // Clear the input buffer of the extra new line
            System.out.println();
            if(selection > 3 || selection < 1){
                System.out.println("Invalid entry, try again.");
                System.out.println();
                validEntry = false;
            }
            else
                validEntry = true;

        }while(!validEntry);
        return selection;
    }

}
