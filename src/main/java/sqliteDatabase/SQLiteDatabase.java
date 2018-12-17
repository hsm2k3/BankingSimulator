package sqliteDatabase;

import Accounts.*;

import java.sql.*;

public class SQLiteDatabase {
    private static final String url = "jdbc:sqlite:bank.db";
    private UserAccounts userAccounts = new UserAccounts();
    private CheckingAccount checkingAccount = new CheckingAccount();
    private SavingsAccount savingsAccount = new SavingsAccount();
    private JuniorCheckingAccount juniorCheckingAccount = new JuniorCheckingAccount();
    private JuniorSavingsAccount juniorSavingsAccount = new JuniorSavingsAccount();
    private Date customerDOB;
    protected int index;
    public static boolean connect() {
        Connection connection = null;
        boolean connected = false;
        try {
            // create a connection to the database
            connection = DriverManager.getConnection(url);
             connected = true;

        }
        catch (SQLException e) {
            System.out.println("Sorry the bank is closed now.");
             connected = false;
        }
//        finally {
//            try {
//                if (connection != null) {
//                    connection.close();
//                    connected = false;
//                }
//            } catch (SQLException ex) {
//                System.out.println(ex.getMessage());
//                System.out.println("Sorry the bank is closed now.");
//                connected = false;
//            }
//        }
        return connected;
    }

    public static void createsNewCheckingAccountTable(){

        //SQL statement for creating Checking Account table
        String sql = "CREATE TABLE IF NOT EXISTS CheckingAccount (\n "
                + "UUID TEXT NOT NULL UNIQUE, \n"
                + "CustomerName TEXT NOT NULL,\n"
                + "SSN TEXT NOT NULL,\n"
                + "Balance REAL NOT NULL,\n"
                + "PRIMARY KEY(UUID)\n"
                + ");";

        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement())
        {
            stmt.execute(sql);
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }

    public static void createsNewJuniorCheckingAccountTable(){

        //SQL statement for creating Checking Account table
        String sql = "CREATE TABLE IF NOT EXISTS JuniorCheckingAccount (\n "
                + "UUID TEXT NOT NULL UNIQUE, \n"
                + "CustomerName TEXT NOT NULL,\n"
                + "Balance REAL NOT NULL,\n"
                + "PRIMARY KEY(UUID)\n"
                + ");";

        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement())
        {
            stmt.execute(sql);
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }

    public static void createsNewTransactionsTable(){
        //SQL statement for creating Transactions table
        String sql = "CREATE TABLE IF NOT EXISTS Transactions (\n "
                + "UUID TEXT NOT NULL UNIQUE, \n"
                + "CustomerName TEXT NOT NULL,\n"
                + "TransactionNote TEXT,\n"
                + "Date TEXT NOT NULL,\n"
                + "Amount REAL NOT NULL,\n"
                + "PRIMARY KEY(UUID)\n"
                + ");";

        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement())
        {
            stmt.execute(sql);
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }

    public static void createsNewUserAccountsTable(){
        //SQL statement for creating User Account table
        String sql = "CREATE TABLE IF NOT EXISTS UserAccounts (\n "
                // AccountID will use the UUID
                + "UUID TEXT NOT NULL UNIQUE ,\n"
                + "CustomerName TEXT NOT NULL,\n"
                + "AccountCreationDate TEXT NOT NULL,\n"
                + "SSN TEXT NOT NULL UNIQUE,\n"
                + "DOB TEXT NOT NULL,\n"
                + "PRIMARY KEY(UUID)\n"
                + ");";

        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement())
        {
            stmt.execute(sql);
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }

    public static void createsNewAvailableFundsTable(){
    //SQL statement for creating User Account table
        String sql = "CREATE TABLE IF NOT EXISTS AvailableFunds (\n "
                + "TotalAvailableFunds REAL NOT NULL UNIQUE);";

        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement())
        {
            stmt.execute(sql);
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }

    public static void createsNewSavingsAccount(){
        //SQL statement for creating User Savings Account table
        String sql = "CREATE TABLE IF NOT EXISTS SavingsAccount (\n"
                // AccountID will use the UUID
                + "UUID TEXT NOT NULL UNIQUE ,\n"
                + "CustomerName TEXT NOT NULL,\n"
                + "SSN TEXT NOT NULL,\n"
                + "SavingsBalance REAL NOT NULL ,\n"
                + "PRIMARY KEY (UUID)\n"
                + ");";
        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement())
        {
            stmt.execute(sql);
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }
    public static void createsNewJuniorSavingsAccount(){
        //SQL statement for creating User Savings Account table
        String sql = "CREATE TABLE IF NOT EXISTS JuniorSavingsAccount (\n"
                // AccountID will use the UUID
                + "UUID TEXT NOT NULL UNIQUE ,\n"
                + "CustomerName TEXT NOT NULL,\n"
                + "JuniorSavingsBalancae REAL NOT NULL ,\n"
                + "PRIMARY KEY (UUID)\n"
                + ");";
        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement())
        {
            stmt.execute(sql);
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }


    public void insertIntoAvailableFunds(Double availableFunds){
        //SQL statement for creating the bank's total of available funds table
        String sql = "INSERT INTO AvailableFunds (TotalAvailableFunds) VALUES (?)";
        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setDouble(1, availableFunds);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void insertIntoCheckingAccount(String ID, Double deposit,String SSN, String customerName){
        String sql = "INSERT INTO CheckingAccount (UUID, customerName, SSN, balance) VALUES (?,?,?,?)";
        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, ID);
            pstmt.setString(2, customerName);
            pstmt.setString(3,SSN);
            pstmt.setDouble(4,deposit);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void insertIntoSavingsAccount(String ID, Double deposit,String SSN, String customerName){
        String sql = "INSERT INTO SavingsAccount (UUID, customerName, SSN, SavingsBalance) VALUES (?,?,?,?)";
        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, ID);
            pstmt.setString(2, customerName);
            pstmt.setString(3,SSN);
            pstmt.setDouble(4,deposit);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


    public void insertIntoUserAccount(String ID, String customerName, String accountCreationDate, String SSN, String dob){
        String sql = "INSERT INTO UserAccounts (UUID, CustomerName, AccountCreationDate, SSN, DOB) VALUES (?,?,?,?,?)";
        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, ID);
            pstmt.setString(2, customerName);
            pstmt.setString(3, accountCreationDate);
            pstmt.setString(4,SSN);
            pstmt.setString(5, dob);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public boolean insertIntoTransactions(String ID, String transactionNote, String customerName, Date date, Integer amount){
        String sql = "INSERT INTO Transactions (UUID, CustomerName, TransactionNote, Date, Amount) VALUES (?,?,?,?,?)";
        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, ID);
            pstmt.setString(2,customerName);
            pstmt.setString(3, transactionNote);
            pstmt.setDate(4, date);
            pstmt.setInt(5, amount);
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean getUserAccounts(){
        String [][]userAccountsString = new String[index][5];
        String sql = "SELECT UUID, CustomerName, AccountCreationDate, SSN, DOB FROM UserAccounts";
        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt  = conn.createStatement();
             ResultSet resultSet = stmt.executeQuery(sql)) {
            while(resultSet.next()){
                String UUID = resultSet.getString("UUID");
                String customerName =resultSet.getString("CustomerName");
                String accountCreationDate = resultSet.getString("AccountCreationDate");
                String SSN = resultSet.getString("SSN");
                String dob = resultSet.getString("DOB");
                userAccountsString[index][0] = UUID;
                userAccountsString[index][1] = customerName;
                userAccountsString[index][2] = accountCreationDate;
                userAccountsString[index][3] = SSN;
                userAccountsString[index][4] = dob;
//                userAccounts.setUserAccounts(userAccountsString,index);
                index++;
            }
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean getCheckingAccounts(){
        int index = 0;
        String sql = "SELECT UUID, CustomerName, Balance FROM CheckingAccount";
        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt  = conn.createStatement();
             ResultSet resultSet = stmt.executeQuery(sql)) {
            while(resultSet.next()){
                String UUID = resultSet.getString("UUID");
                String customerName =resultSet.getString("CustomerName");
                Double balance = resultSet.getDouble("Balance");
                checkingAccount.getCheckingAccounts(UUID,customerName,balance,index);
                index++;
            }
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean getSavingsAccounts(){
        index = 0;
        String sql = "SELECT UUID, CustomerName, Balance FROM SavingsAccount";
        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt  = conn.createStatement();
             ResultSet resultSet = stmt.executeQuery(sql)) {
            while(resultSet.next()){
                String UUID = resultSet.getString("UUID");
                String customerName =resultSet.getString("CustomerName");
                Double balance = resultSet.getDouble("Balance");
//                savingsAccount.getSavingsAccounts(UUID,customerName,balance,index);
                index++;
            }
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean getJuniorCheckingAccount(){
        int index = 0;
        String sql = "SELECT UUID, CustomerName, Balance FROM SavingsAccount";
        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt  = conn.createStatement();
             ResultSet resultSet = stmt.executeQuery(sql)) {
            while(resultSet.next()){
                String UUID = resultSet.getString("UUID");
                String customerName =resultSet.getString("CustomerName");
                Double balance = resultSet.getDouble("Balance");
                juniorCheckingAccount.getJuniorCheckingAccount(UUID,customerName,balance,index);
                index++;
            }
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean getJuniorSavingsAccount(){
        int index = 0;
        String sql = "SELECT UUID, CustomerName, Balance FROM SavingsAccount";
        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt  = conn.createStatement();
             ResultSet resultSet = stmt.executeQuery(sql)) {
            while(resultSet.next()){
                String UUID = resultSet.getString("UUID");
                String customerName =resultSet.getString("CustomerName");
                Double balance = resultSet.getDouble("Balance");
                juniorSavingsAccount.getJuniorSavingsAccount(UUID,customerName,balance,index);
                index++;
            }
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

//    public boolean doesUserAccountExist(String customerName, String SSN, String DOB){
//        if (userAccounts.doesUserAccountExist(customerName,SSN,DOB,index))
//            return true;
//        else
//            return false;
//    }

}