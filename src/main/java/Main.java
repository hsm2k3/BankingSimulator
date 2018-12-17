//Authors:
//Alex Braverman
//Muhammad Khalil
//

import Bank.Bank;
import Bank.Employees.BranchManager;
import Bank.Employees.FinancialAdvisor;
import Bank.Employees.Teller;
//import bank.employees.BranchManager;
//import bank.employees.FinancialAdvisor;
//import bank.employees.Teller;
import customer.Customer;


import java.text.ParseException;
import java.util.Scanner;
//import bank.Bank;
import sqliteDatabase.SQLiteDatabase;

public class Main {
    private static final int EXIT = 3;
    private static final int TELLER = 1;
    private static final int FINANCIAL_ADVISOR = 2;
    private static final int TELLER_MAKE_CHECKING_ACCOUNT = 1;
    private static final int TELLER_MAKE_SAVINGS_ACCOUNT = 2;
    private static final int TELLER_DEPOSIT_CHECKING = 3;
    private static final int TELLER_DEPOSIT_SAVINGS = 4;
    private static final int TELLER_WITHDRAW_CHECKING = 5;
    private static final int TELLER_WITHDRAW_SAVINGS = 6;
    private static final int TELLER_CHECK_TRANSACTIONS = 7;
    private static final int LEAVE_TELLER = 8;
    private static final int FINANCIAL_ADVISOR_NEW_ACCOUNT = 1;
    private static final int FINANCIAL_ADVISOR_INVEST_MONEY = 2;
    private static final int LEAVE_FINANCIAL_ADVISOR = 3;

    //we might need to have other classes access these data types
    protected static String CUSTOMER_NAME = null;
    protected static String CUSTOMER_DOB = null;
    protected static String CUSTOMER_SSN = null;
    protected static Double CUSTOMER_BALANCE = null;

    public static void main(String args[]) throws ParseException {
        int selection = 0, tellerSelection = 0, financialAdvisorSelection = 0;
        SQLiteDatabase sqLiteDatabase = new SQLiteDatabase();
        Bank bank = new Bank(sqLiteDatabase);
        BranchManager branchManager = new BranchManager(bank);
        Teller teller = new Teller(branchManager);
        FinancialAdvisor financialAdvisor = new FinancialAdvisor(branchManager);
        Customer customer = new Customer();
        Scanner scanner = new Scanner(System.in);



        CUSTOMER_NAME = getCustomerName(scanner);
        CUSTOMER_DOB = getCustomerDOB(scanner);
        CUSTOMER_SSN = getCustomerSSN(scanner);
        CUSTOMER_BALANCE = getCustomerBalance(scanner);
        customer.setCustomerName(CUSTOMER_NAME);
        customer.setCustomerDOB(CUSTOMER_DOB);
        customer.setCustomerSNN(CUSTOMER_SSN);
        customer.setCustomerBalance(CUSTOMER_BALANCE);
        if(branchManager.isBankOpen()) {
            do {
                selection = displayMenu(scanner);
                switch (selection) {
                    case TELLER:
                        displayTellerMenu(scanner, teller);
                        break;
                    case FINANCIAL_ADVISOR:
                        displayFinancialAdvisorMenu(scanner);
                        break;
                    case EXIT:
                        break;
                    default:
                        System.out.println("Oops! Something went wrong.");
                        break;
                }
            } while (selection != EXIT);
        }
        else
            System.out.println("The bank is closed. Come back next time.");


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

    public static int displayTellerMenu(Scanner scanner, Teller teller){
        int selection = 0;
        boolean validSelection = true;
        do {
            System.out.println("Welcome, " + CUSTOMER_NAME + ", how may I help you today?");
            System.out.println("----------------------------------------");
            System.out.println("1. Make a new checking account.");
            System.out.println("2. Make a new savings account.");
            System.out.println("3. Deposit money into checking account.");
            System.out.println("4. Deposit money into savings account.");
            System.out.println("5. Withdraw money from checking account.");
            System.out.println("6. Withdraw money from savings account.");
            System.out.println("7. Check account transactions.");
            System.out.println("8. Return to main menu.");
            System.out.println("----------------------------------------");
            selection = scanner.nextInt();
            if(selection > 8 || selection < 1)
                validSelection = false;
            else
                validSelection = true;
        }while (!validSelection);
        teller.addUserAccount(CUSTOMER_NAME, CUSTOMER_SSN, CUSTOMER_DOB);
        teller.setUUID();
        switch(selection){
            case TELLER_MAKE_CHECKING_ACCOUNT:
                    teller.addCheckingAccount(CUSTOMER_NAME, CUSTOMER_SSN,CUSTOMER_BALANCE);
                    System.out.println(CUSTOMER_NAME+ " your account has been created.");
                    displayTellerMenu(scanner, teller);
                break;
            case TELLER_MAKE_SAVINGS_ACCOUNT:
                teller.addSavingsAccount(CUSTOMER_NAME, CUSTOMER_SSN, CUSTOMER_DOB,CUSTOMER_BALANCE);
                System.out.println(CUSTOMER_NAME+ " your account has been created.");
                displayTellerMenu(scanner, teller);
                break;
            case TELLER_DEPOSIT_CHECKING:
                System.out.println("How much would you like to deposit?");
                Double deposit;
                deposit = scanner.nextDouble();
                teller.depositToCheckingAccount(CUSTOMER_NAME, CUSTOMER_SSN,deposit);
                System.out.println(CUSTOMER_NAME+ " we deposited $" +deposit+ " into your account.");
                displayTellerMenu(scanner, teller);
                break;
            case TELLER_DEPOSIT_SAVINGS:
                break;
            case TELLER_WITHDRAW_CHECKING:
                break;
            case TELLER_WITHDRAW_SAVINGS:
                break;
            case TELLER_CHECK_TRANSACTIONS:
                break;
            case LEAVE_TELLER:
                break;
            default:
                break;
        }

        return selection;
    }

    public static int displayFinancialAdvisorMenu(Scanner scanner){
        int selection = 0;
        boolean validSelection = true;
        do{
        System.out.println("Welcome, " + CUSTOMER_NAME + ", how may I help you today?");
        System.out.println("----------------------------------------");
        System.out.println("1. Create an account.");
        System.out.println("2. Invest into money market.");
        System.out.println("3. Return to main menu.");
        System.out.println("----------------------------------------");
        selection = scanner.nextInt();
        if(selection > 7 || selection < 1)
            validSelection = false;
        else
            validSelection = true;
    }while (!validSelection);

        switch(selection){
            case FINANCIAL_ADVISOR_NEW_ACCOUNT:
                break;
            case FINANCIAL_ADVISOR_INVEST_MONEY:
                break;
            case LEAVE_FINANCIAL_ADVISOR:
                break;
            default:
                break;
        }
        return selection;
    }

    public static String getCustomerName(Scanner scanner){
        String customerName;
        System.out.println("Please provide your name: " );
        customerName ="test2"/* scanner.nextLine()*/;
        System.out.println();
        return customerName;
    }

    public static String getCustomerDOB(Scanner scanner){
        String DOB;
        System.out.println("Please provide your DOB (MM/DD/YYYY): ");
        DOB = "1/1/1920"/*scanner.nextLine()*/;
        System.out.println();
        return DOB;

    }

    public static String getCustomerSSN(Scanner scanner){
        String SSN;
        System.out.println("Please provide your SSN : ");
        SSN = "11-22-3333"/*scanner.nextLine()*/;
        String cleanSSN = SSN.replaceAll("[\\s\\-()]", "");
        System.out.println();
        return cleanSSN;

    }

    public static Double getCustomerBalance(Scanner scanner){
        Double balance;
        System.out.println("Please provide your SSN : ");
        balance = 500.01/*scanner.nextDouble()*/;
        System.out.println();
        return balance;
    }




}
