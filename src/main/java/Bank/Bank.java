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
        sqliteDatabase.createsNewUserAccountsTable();
        sqliteDatabase.createsNewCheckingAccountTable();
        sqliteDatabase.createsNewSavingsAccountTable();
        return connectedToDB;
    }


    public void addNewCheckingAccount(String UUID, Double balance, String customerName, String SSN){
        sqliteDatabase.insertIntoNewCheckingAccount(UUID, customerName,SSN, balance);
    }
    public boolean depositToCheckingAccount(String SSN, Double deposit){
        return sqliteDatabase.depositIntoCheckingAccount(SSN,deposit);
    }

    public Boolean withdrawalFromJuniorCheckingAccount(String SSN, Double withdrawal){
        return this.sqliteDatabase.withdrawFromCheckingAccount(SSN, withdrawal);
    }
    public void addUserAccount(String UUID, String customerName, String accountCreationDate, String SSN, String DOB){
        sqliteDatabase.insertIntoUserAccount(UUID,customerName,accountCreationDate,SSN,DOB);
    }
    public boolean isUserAccountInDB(String SSN){
        return sqliteDatabase.isUserAccountInDB(SSN);
    }
    public void displayAccountInformation(String SSN){
        sqliteDatabase.displayAccountInformation(SSN);
    }
}