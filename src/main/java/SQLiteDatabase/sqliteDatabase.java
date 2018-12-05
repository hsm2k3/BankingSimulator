package SQLiteDatabase;

import java.sql.*;

public class sqliteDatabase {




    public static void connect() {
        Connection conn = null;
        try {
            // db parameters
            String url = "jdbc:sqlite:test.db";
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
        String url = "jdbc:sqlite:test.db";

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
        String url = "jdbc:sqlite:test.db";

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
        String url = "jdbc:sqlite:test.db";

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

    public void insertIntoCheckingAccount(Integer accountID, Double balance){
        String sql = "INSERT INTO CheckingAccount (checkingAccountID, balance) VALUES (?, ?)";
        String url = "jdbc:sqlite:test.db";
        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, accountID);
            pstmt.setDouble(2, balance);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}

    public void insertIntoUserAccount(Integer accountID, Double balance){
        String sql = "INSERT INTO CheckingAccount (checkingAccountID, balance) VALUES (?, ?)";
        String url = "jdbc:sqlite:test.db";
        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, accountID);
            pstmt.setDouble(2, balance);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}