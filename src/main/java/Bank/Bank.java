package Bank;

import Accounts.CheckingAccount;
import Accounts.JuniorCheckingAccount;
import Accounts.SavingsAccount;
import Accounts.UserAccounts;
import sqliteDatabase.SQLiteDatabase;

public class Bank {
    private SQLiteDatabase sqliteDatabase;
    private static double BANK_FUNDS = 1000000.00;
    private UserAccounts userAccounts = new UserAccounts();;
    private CheckingAccount checkingAccount;
    private SavingsAccount savingsAccount;
    private JuniorCheckingAccount juniorCheckingAccount;
    //Operation Times
    //Days Open

    //public void Bank()
    public Bank (SQLiteDatabase sqliteDatabase){
        this.sqliteDatabase = sqliteDatabase;
//        UserAccounts userAccounts = new UserAccounts();
        CheckingAccount checkingAccount = new CheckingAccount();
        SavingsAccount savingsAccount = new SavingsAccount();
        JuniorCheckingAccount juniorCheckingAccount = new JuniorCheckingAccount();
    }

    //This method will create our database in the local folder
    //--- Set this as a boolean to turn true if connected
    public Boolean connectToDatabase() {
        boolean connectedToDB = false;
        if(sqliteDatabase.connect()) {
            connectedToDB = true;
        }
        sqliteDatabase.createsNewCheckingAccountTable();
        sqliteDatabase.createsNewJuniorCheckingAccountTable();
        sqliteDatabase.createsNewUserAccountsTable();
        sqliteDatabase.createsNewTransactionsTable();
        sqliteDatabase.createsNewSavingsAccount();
        sqliteDatabase.createsNewJuniorSavingsAccount();
        sqliteDatabase.createsNewAvailableFundsTable();
        return connectedToDB;
    }

    public boolean getUserAccounts(){
        if(sqliteDatabase.getUserAccounts())
            return true;
        else
            return false;
    }

    public boolean getCheckingAccounts(){
            if(sqliteDatabase.getCheckingAccounts())
                return true;
            else
                return false;
    }
    public boolean getSavingsAccounts(){
            if(sqliteDatabase.getSavingsAccounts())
                return true;
            else
                return false;
    }

    public boolean getJuniorCheckingAccounts(){
        if(sqliteDatabase.getJuniorCheckingAccount())
            return true;
        else
            return false;
    }

    public boolean getJuniorSavingsAccounts(){
        if(sqliteDatabase.getJuniorSavingsAccount())
            return true;
        else
            return false;
    }

    public void addCheckingAccount(String UUID, Double balance, String customerName, String SSN){
        sqliteDatabase.insertIntoCheckingAccount(UUID, balance, SSN, customerName);
    }

//    public boolean doesUserAccountExist(String customerName, String SSN, String DOB){
//        if(sqliteDatabase.getUserAccounts())
//            return true;
//        else
//            return false;
////        if(userAccounts.doesUserAccountExist(customerName,SSN,DOB))
////            return true;
////        else
////            return false;
//    }

    public void addUserAccount(String UUID, String customerName, String accountCreationDate, String SSN, String DOB){
        sqliteDatabase.insertIntoUserAccount(UUID,customerName,accountCreationDate,SSN,DOB);
    }
}