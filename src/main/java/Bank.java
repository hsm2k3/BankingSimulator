import SQLiteDatabase.sqliteDatabase;

import java.util.Scanner;

public class Bank {
    //these variables are just for testing the insertIntoCheckingAccount method for the database
    private static Integer checkingAccountID = 1;
    private static Double checkingBalance = 500.00;
    Double balance = 5000000.0;
    Integer numberOfPatrons;
    Integer numberOfTransactions;
    //Operation Times
    //Days Open

    //public void Bank()
    //Initialize branch manager
    public Bank (){
    }

    //this is just a test right now, it's creating the database and tables here
    public void connectToDatabase(){
        sqliteDatabase database = new sqliteDatabase();
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter checking account ID: ");
        checkingAccountID = scan.nextInt();
        System.out.println("Enter checking balance: ");
        checkingBalance = scan.nextDouble();

        database.connect();
        database.createsNewCheckingAccountTable();
        database.createsNewUserAccountsTable();
        database.createsNewTransactionsTable();
        database.insertIntoCheckingAccount(checkingAccountID,checkingBalance);
    }

}
