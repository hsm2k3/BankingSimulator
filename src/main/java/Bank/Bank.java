package Bank;

import sqliteDatabase.SQLiteDatabase;

public class Bank {
    private SQLiteDatabase sqliteDatabase;
    private static double BANK_FUNDS = 1000000.00;

    //Operation Times
    //Days Open

    //public void Bank()
    public Bank (SQLiteDatabase sqliteDatabase){
        this.sqliteDatabase = sqliteDatabase;
//        UserAccounts userAccounts = new UserAccounts();

    }

    //This method will create our database in the local folder
    //--- Set this as a boolean to turn true if connected
    public Boolean connectToDatabase() {
        boolean connectedToDB = false;
        if(sqliteDatabase.connect()) {
            connectedToDB = true;
        }
        sqliteDatabase.createsNewAccountTable();
        sqliteDatabase.createsNewUserAccountsTable();
        return connectedToDB;
    }


    public void addToAccount(String UUID, Double balance, String customerName, String SSN){
        sqliteDatabase.insertIntoAccount(SSN, balance);
    }
    public void depositToAccount(String SSN, Double deposit){
        sqliteDatabase.insertIntoAccount(SSN,deposit);
    }

    public Boolean withdrawalFromJuniorCheckingAccount(String SSN, Double withdrawal){
        return this.sqliteDatabase.withdrawFromAccount(SSN, withdrawal);
    }
    public void addUserAccount(String UUID, String customerName, String accountCreationDate, String SSN, String DOB){
        sqliteDatabase.insertIntoUserAccount(UUID,customerName,accountCreationDate,SSN,DOB);
    }
    public boolean checkUserAccount(String SSN){
        if(sqliteDatabase.checkUserAccount(SSN))
            return true;
        else
            return false;
    }
    public void displayAccountInformation(String SSN){
        sqliteDatabase.displayAccountInformation(SSN);
    }
}