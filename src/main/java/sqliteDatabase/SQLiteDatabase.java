package sqliteDatabase;

import java.sql.*;

public class SQLiteDatabase {
    private static final String url = "jdbc:sqlite:Bank.db";
    public static void connect() {
        Connection conn = null;
        try {
            // create a connection to the database
            conn = DriverManager.getConnection(url);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
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
                + "Amount INTEGER NOT NULL,\n"
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
                + "TotalAvailableFunds INTEGER NOT NULL UNIQUE);";

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
                + "SavingsBalancae INTEGER NOT NULL ,\n"
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
                + "JuniorSavingsBalancae INTEGER NOT NULL ,\n"
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
        //SQL statement for creating the Bank's total of available funds table
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


    public void insertIntoUserAccount(String ID, String customerName, String date, String dob){
        String sql = "INSERT INTO UserAccounts (UUID, CustomerName, AccountCreationDate, DOB) VALUES (?,?,?,?)";
        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, ID);
            pstmt.setString(2, customerName);
            pstmt.setString(3, date);
            pstmt.setString(4, dob);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public boolean insertIntoTransactions(String ID, String transactionNote, String customerName, String date, Integer amount){
        String sql = "INSERT INTO Transactions (UUID, CustomerName, TransactionNote, Date, Amount) VALUES (?,?,?,?,?)";
        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, ID);
            pstmt.setString(2,customerName);
            pstmt.setString(3, transactionNote);
            pstmt.setString(4, date);
            pstmt.setInt(5, amount);
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

}
