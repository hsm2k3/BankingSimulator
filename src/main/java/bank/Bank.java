package bank;

import sqliteDatabase.SQLiteDatabase;

public class Bank {
    private SQLiteDatabase sqliteDatabase;
    //Operation Times
    //Days Open

    //public void Bank()
    public Bank (SQLiteDatabase sqliteDatabase){
        this.sqliteDatabase = sqliteDatabase;
    }

    //this is just a test right now, it's creating the database and tables here
    public void connectToDatabase(){

//        Scanner scan = new Scanner(System.in);
//        System.out.println("Enter checking account ID: ");
//        checkingAccountID = scan.nextInt();
//        System.out.println("Enter checking balance: ");
//        checkingBalance = scan.nextDouble();

        sqliteDatabase.connect();
        sqliteDatabase.createsNewCheckingAccountTable();
        sqliteDatabase.createsNewUserAccountsTable();
        sqliteDatabase.createsNewTransactionsTable();
//        database.insertIntoCheckingAccount(checkingAccountID,checkingBalance);
    }

}