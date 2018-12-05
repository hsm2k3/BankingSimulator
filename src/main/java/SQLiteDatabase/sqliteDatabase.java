package SQLiteDatabase;

import java.sql.*;

public class sqliteDatabase {
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
                + "CheckingAccountID INTEGER NOT NULL UNIQUE, \n"
                + "Balance REAL NOT NULL,\n"
                + "PRIMARY KEY(CheckingAccountID)\n"
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
                + "TransactionID INTEGER NOT NULL UNIQUE,\n"
                + "TransactionNote TEXT,\n"
                + "Date INTEGER NOT NULL,\n"
                + "Amount INTEGER NOT NULL,\n"
                + "PRIMARY KEY(TransactionID)\n"
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
                + "AccountID INTEGER NOT NULL UNIQUE ,\n"
                + "CustomerName TEXT NOT NULL,\n"
                + "AccountCreationDate INTEGER NOT NULL,\n"
                + "DOB INTEGER NOT NULL,\n"
                + "PRIMARY KEY(AccountID)\n"
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

    public void insertIntoCheckingAccount(Integer ID, Double balance){
        String sql = "INSERT INTO CheckingAccount (checkingAccountID, balance) VALUES (?, ?)";
        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, ID);
            pstmt.setDouble(2, balance);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


    public void insertIntoUserAccount(Integer ID, String name, Integer date, Integer dob){
        String sql = "INSERT INTO UserAccounts (CustomerName, AccountID, AccountCreationDate, DOB) VALUES (?,?,?,?)";
        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, ID);
            pstmt.setString(2, name);
            pstmt.setInt(3, date);
            pstmt.setInt(4, dob);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public void insertIntoTransactions(Integer ID, String transactionNote, Integer date, Integer amount){
        String sql = "INSERT INTO Transactions (TransactionID, TransactionNote, Date, Amount) VALUES (?,?,?,?)";
        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, ID);
            pstmt.setString(2, transactionNote);
            pstmt.setInt(3, date);
            pstmt.setInt(4, amount);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}