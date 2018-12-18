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
        sqliteDatabase.createsNewCheckingAccountTable();
        sqliteDatabase.createsNewJuniorCheckingAccountTable();
        sqliteDatabase.createsNewUserAccountsTable();
        sqliteDatabase.createsNewTransactionsTable();
        sqliteDatabase.createsNewSavingsAccount();
        sqliteDatabase.createsNewJuniorSavingsAccount();
        sqliteDatabase.createsNewAvailableFundsTable();
        sqliteDatabase.insertIntoAvailableFunds(BANK_FUNDS);
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

    public void addSavingsAccount(String UUID, Double balance, String customerName, String SSN){
        sqliteDatabase.insertIntoSavingsAccount(UUID, balance, SSN, customerName);
    }
    public void addJuniorCheckingAccount(String UUID, Double balance, String customerName, String SSN){
        sqliteDatabase.insertIntoJuniorCheckingAccount(SSN, balance);
    }
//    public void addJuniorSavingsAccount(String UUID, Double balance, String customerName, String SSN){
//        sqliteDatabase.insertIntoJuniorSavingsAccount(UUID, balance, SSN, customerName);
//    }

    public void depositToCheckingAccount(String UUID, String customerName, String SSN, Double deposit){
        sqliteDatabase.insertIntoCheckingAccount(UUID, deposit,SSN,customerName);
    }

    public void depositToSavingsAccount(String UUID, String customerName, String SSN, Double deposit){
        sqliteDatabase.insertIntoSavingsAccount(UUID, deposit,SSN,customerName);
    }

    public void depositToJuniorCheckingAccount(String SSN, Double deposit){
        sqliteDatabase.insertIntoJuniorCheckingAccount(SSN,deposit);
    }

    public Boolean withdrawalFromJuniorCheckingAccount(String SSN, Double withdrawal){
        return this.sqliteDatabase.wihdrawIntoJuniorCheckingAccount(SSN, withdrawal);
    }
//    public void depositToJuniorSavingsAccount(String UUID, String customerName, String SSN, Double deposit){
//        sqliteDatabase.insertIntoJuniorSavingsAccount(UUID, deposit,SSN,customerName);
//    }

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
    public boolean withDrawFromBankFunds(Double freeMoney){
        if(sqliteDatabase.withDrawFromBankFunds(freeMoney))
            return true;
        else
            return false;
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