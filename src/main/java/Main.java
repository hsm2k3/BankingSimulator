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


import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.Scanner;
//import bank.Bank;
import sqliteDatabase.SQLiteDatabase;

public class Main {
    private static final int EXIT = 3;
    private static final int TELLER = 1;
    private static final int FINANCIAL_ADVISOR = 2;
    private static final int TELLER_MAKE_ACCOUNT = 1;
    private static final int TELLER_DEPOSIT_ACCOUNT = 2;
    private static final int TELLER_WITHDRAW_ACCOUNT = 3;
    private static final int TELLER_CHECK_BALANCE_ACCOUNT = 4;
    private static final int LEAVE_TELLER = 5;
    private static final int FINANCIAL_ADVISOR_NEW_ACCOUNT = 1;
    private static final int FINANCIAL_ADVISOR_INVEST_MONEY = 2;
    private static final int LEAVE_FINANCIAL_ADVISOR = 3;

    private static String CUSTOMER_NAME = null;
    private static String CUSTOMER_DOB = null;
    private static String CUSTOMER_SSN = null;
    private static Double CUSTOMER_BALANCE = null;

    public static void main(String args[]) throws ParseException {
        int selection = 0, tellerSelection = 0, financialAdvisorSelection = 0;
        SQLiteDatabase sqLiteDatabase = new SQLiteDatabase();
        Bank bank = new Bank(sqLiteDatabase);
        BranchManager branchManager = new BranchManager(bank);
        Teller teller = new Teller(branchManager);
        FinancialAdvisor financialAdvisor = new FinancialAdvisor(branchManager);
        Customer customer = new Customer();
        Scanner scanner = new Scanner(System.in);
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###.00");



        CUSTOMER_NAME = getCustomerName(scanner);
        CUSTOMER_DOB = getCustomerDOB(scanner);
        CUSTOMER_SSN = getCustomerSSN(scanner);
        CUSTOMER_BALANCE = getCustomerBalance(scanner);
        customer.setCustomerName(CUSTOMER_NAME);
        customer.setCustomerDOB(CUSTOMER_DOB);
        customer.setCustomerSNN(CUSTOMER_SSN);
//        System.out.println(decimalFormat.format(CUSTOMER_BALANCE));
        customer.setCustomerBalance(Double.valueOf(decimalFormat.format(CUSTOMER_BALANCE)));
        if(branchManager.isBankOpen()) {
            do {
                selection = displayMenu(scanner);
                switch (selection) {
                    case TELLER:
                        displayTellerMenu(scanner, teller, customer);
                        break;
                    case FINANCIAL_ADVISOR:
                        System.out.println("Sorry we fired this guy");
                        displayMenu(scanner);
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

    public static int displayTellerMenu(Scanner scanner, Teller teller, Customer customer) throws ParseException {
        int selection = 0;
        boolean validSelection = true;
        do {
            System.out.println("Welcome, " + CUSTOMER_NAME + ", how may I help you today?");
            System.out.println("----------------------------------------");
            System.out.println("1. Make a new checking account.");
            System.out.println("2. Deposit money into account.");
            System.out.println("3. Withdraw money from account.");
            System.out.println("4. Check account Balance.");
            System.out.println("5. Return to main menu.");
            System.out.println("----------------------------------------");
            selection = scanner.nextInt();
            if(selection > 5 || selection < 1)
                validSelection = false;
            else
                validSelection = true;
        }while (!validSelection);
        teller.setUUID();
        switch(selection){
            case TELLER_MAKE_ACCOUNT:
                if(!customer.isMinor(CUSTOMER_DOB)) {
                    if (!teller.isUserAccountInDB(CUSTOMER_SSN)) {
                        teller.addUserAccount(CUSTOMER_NAME, CUSTOMER_SSN, CUSTOMER_DOB);
                        teller.addNewCheckingAccount(CUSTOMER_NAME, CUSTOMER_SSN, CUSTOMER_BALANCE);
                        System.out.println(CUSTOMER_NAME + " your account has been created.");
                        displayTellerMenu(scanner, teller, customer);
                    }
                    else
                        System.out.println("You already have an account! Choose something else. ");
                }
                else
                {
                    System.out.println("Sorry you're too young. Come back when you're older and have a JOB!");
                }
                break;
            case TELLER_DEPOSIT_ACCOUNT:
                Double deposit;
                if(!customer.isMinor(CUSTOMER_DOB)) {
                    if(teller.isUserAccountInDB(CUSTOMER_SSN)) {
                        System.out.println("How much would you like to deposit?");
                        deposit = scanner.nextDouble();
                        teller.depositToAccount(CUSTOMER_SSN, deposit);
                        System.out.println(CUSTOMER_NAME + " we deposited $" + deposit + " into a checking account.");
                        displayTellerMenu(scanner, teller, customer);
                    }
                    else
                        System.out.println("Sorry I couldn't find your account in the system.");
                }
                else
                {
                System.out.println("You're a minor, come back when you're older");
                displayTellerMenu(scanner, teller,customer);
                }
                break;
            case TELLER_WITHDRAW_ACCOUNT:
                Double withdrawal;
                if(!customer.isMinor(CUSTOMER_DOB)) {
                    if (teller.isUserAccountInDB(CUSTOMER_SSN)) {
                        System.out.println("How much would like to withdraw?");
                        withdrawal = scanner.nextDouble();
                        teller.withdrawFromAccount(CUSTOMER_SSN, withdrawal);
                        System.out.println("Withdrawal: $" + withdrawal + " don't spend it all in one place.");
                    }
                    else
                        System.out.println("Sorry I couldn't find your account in the system.");
                }
                else
                    System.out.println("Sorry your too young. Come back when you're older and have a JOB!");
                break;
            case TELLER_CHECK_BALANCE_ACCOUNT:
                if(!customer.isMinor(CUSTOMER_DOB)) {
                    if (teller.isUserAccountInDB(CUSTOMER_SSN)) {
                        teller.displayAccountInformation(CUSTOMER_SSN);
                    }
                    else
                        System.out.println("Sorry I couldn't find your account in the system.");
                }
                else
                    System.out.println("Sorry your too young. Come back when you're older and have a JOB!");
            case LEAVE_TELLER:
                break;
            default:
                break;
        }

        return selection;
    }
    //this is a work in progress
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
        customerName = "test1";/*scanner.nextLine();*/
        System.out.println();
        return customerName;
    }

    public static String getCustomerDOB(Scanner scanner){
        String DOB;
        System.out.println("Please provide your DOB (MM/DD/YYYY): ");
        DOB = "1/1/1950";/*scanner.nextLine();*/
        System.out.println();
        return DOB;

    }

    public static String getCustomerSSN(Scanner scanner){
        String SSN;
        System.out.println("Please provide your SSN : ");
        SSN = "12-34-5678";/*scanner.nextLine();*/
        String cleanSSN = SSN.replaceAll("[\\s\\-()]", "");
        System.out.println();
        return cleanSSN;

    }

    public static Double getCustomerBalance(Scanner scanner){
        Double balance;
        System.out.println("How much do you have? ");
        balance = 500.01;/*scanner.nextDouble();*/
        System.out.println();
        return balance;
    }




}
