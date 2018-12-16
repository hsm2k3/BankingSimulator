import Bank.Bank;
import Bank.Employees.BranchManager;
import Bank.Employees.FinancialAdvisor;
import Bank.Employees.Teller;
import org.joda.time.DateTime;
import sqliteDatabase.SQLiteDatabase;

import java.util.Scanner;

public class Main_1214 {
    public static void main(String args[]) {
        //Setting up the database (I'm not sure how it would work if we had to pull an existing database but
        //Lets assume the following does that
        SQLiteDatabase sqLiteDatabase = new SQLiteDatabase();

        //Should the bank instantiate
        Bank bank = new Bank(sqLiteDatabase);
        BranchManager branchManager = new BranchManager(bank);

        //Here we call the connectToDataBase() from BranchManager and he checks if the branch is open
        //The function included can just be calling .connectToDataBase and swapping it from a void to Boolean
        //-------------if(branchManager.checkIfBankDatabaseLive())
        //-------------     Do all code
        //-------------else
        //-------------     System.out.println("Sorry branch is closed come back another day ¯]_(ツ)_[¯");

        //The following code is if the above IF statement was true
        Teller teller = new Teller(branchManager);
        FinancialAdvisor financialAdvisor = new FinancialAdvisor(branchManager);

        //Here we now take the customer's name and DOB
        String customerName = initialNameMenu();
        DateTime customerDOB = initialDateMenu();

        //Now the teller checks if the customer exists within the database
        if (teller.doesUserAccountExists(customerName, customerDOB.toString())) ;
        //Here we set the customer to the teller's current customer
        teller.getCustomerAccount(customerName, customerDOB.toString());


        //base menu
        //else

        //take initial deposit


    }

    //These two methods take name and date
    public static String initialNameMenu() {
        String name;
        Scanner scanner = new Scanner(System.in);

        System.out.print("Thank you for choosing Braverman-Khalil Bank. Please enter your name: ");
        name = scanner.nextLine();

        scanner.close();
        return name;
    }

    public static DateTime initialDateMenu() {
        //Taking in and setting up the DOB
        Scanner scan = new Scanner(System.in);

        //Taking in date of birth
        Integer birthYear = -1;
        while (((birthYear >= 1920)) && (birthYear <= 2019)) {
            System.out.println("Please enter your birth year: ");
            birthYear = scan.nextInt();
        }

        Integer birthMonth = -1;
        while ((birthMonth >= 1) && (birthMonth <= 12)) {
            System.out.print("Please enter your birth month: ");
            birthMonth = scan.nextInt();
        }

        Integer birthDay = -1;
        while ((birthDay >= 1) && (birthDay <= 31)) {
            System.out.println("Please enter your birth day: ");
            birthDay = scan.nextInt();
        }

        DateTime dob = new DateTime(birthYear, birthMonth, birthDay, 0, 0);
        scan.close();
        return dob;
    }

    public static Double getInitialCheckingAccountDeposit() {
        Scanner scan = new Scanner(System.in);

        Double initialCheckingAccountDeposit = -1.0;

        while (initialCheckingAccountDeposit <= 0) {
            System.out.print("Enter initial Checking Account deposit > $1.00: ");
            initialCheckingAccountDeposit = scan.nextDouble();
        }

        scan.close();
        return initialCheckingAccountDeposit;
    }

    public static Double getInitialSavingsAccountDeposit() {
        Scanner scan = new Scanner(System.in);

        Double initialSavingsAccountDeposit = -1.0;

        while (initialSavingsAccountDeposit <= 0) {
            System.out.print("Enter initial Savings Account deposit > $1.00: ");
            initialSavingsAccountDeposit = scan.nextDouble();
        }

        scan.close();
        return initialSavingsAccountDeposit;
    }

    //public static void fullTellerMenu;

    {
        Scanner scan = new Scanner(System.in);
        int selection = 0;
        boolean validSelection = true;
        do {
            System.out.println("----------------------------------------");
            System.out.println("1. Deposit money into checking account.");
            System.out.println("2. Deposit money into savings account.");
            System.out.println("3. Withdraw money from checking account.");
            System.out.println("4. Generate reports");
            System.out.println("5. Return to main menu.");
            System.out.println("----------------------------------------");
            selection = scan.nextInt();
            if (selection > 7 || selection < 1)
                validSelection = false;
            else
                validSelection = true;
        } while (!validSelection);

        switch (selection) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            default:
                break;
        }

    }


   // public static Boolean depositMoney() {
        //Here a new transaction is made
        //then passed onto the specific account
    //}
}





