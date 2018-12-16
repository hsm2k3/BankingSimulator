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
                + "SavingsBalancae REAL NOT NULL ,\n"
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

    public void insertIntoCheckingAccount(String ID, Double balance, String customerName){
        String sql = "INSERT INTO CheckingAccount (UUID, customerName, balance) VALUES (?,?,?)";
        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, ID);
            pstmt.setString(2, customerName);
            pstmt.setDouble(3,balance);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


    public void insertIntoUserAccount(String ID, String customerName, String accountCreationDate, String dob){
        String sql = "INSERT INTO UserAccounts (UUID, CustomerName, AccountCreationDate, DOB) VALUES (?,?,?,?)";
        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, ID);
            pstmt.setString(2, customerName);
            pstmt.setString(3, accountCreationDate);
            pstmt.setString(4, dob);
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
        int index = 0;
        String sql = "SELECT UUID, CustomerName, AccountCreationDate, DOB FROM UserAccounts";
        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt  = conn.createStatement();
             ResultSet resultSet = stmt.executeQuery(sql)) {
            while(resultSet.next()){
                String UUID = resultSet.getString("UUID");
                String customerName =resultSet.getString("CustomerName");
                String accountCreationDate = resultSet.getString("AccountCreationDate");
                String dob = resultSet.getString("DOB");
                userAccounts.getUserAccounts(UUID,customerName,accountCreationDate,dob,index);
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
        int index = 0;
        String sql = "SELECT UUID, CustomerName, Balance FROM SavingsAccount";
        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt  = conn.createStatement();
             ResultSet resultSet = stmt.executeQuery(sql)) {
            while(resultSet.next()){
                String UUID = resultSet.getString("UUID");
                String customerName =resultSet.getString("CustomerName");
                Double balance = resultSet.getDouble("Balance");
                savingsAccount.getSavingsAccounts(UUID,customerName,balance,index);
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

    public boolean doesUserAccountExist(String customerName, String DOB){
        if (userAccounts.doesUserAccountExist(customerName,DOB))
            return true;
        else
            return false;
    }

}