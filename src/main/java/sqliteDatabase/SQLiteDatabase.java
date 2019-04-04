package sqliteDatabase;



import java.sql.*;
import java.text.DecimalFormat;

public class SQLiteDatabase {
    private static final String url = "jdbc:sqlite:bank.db";
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
        return connected;
    }



    public static void createsNewCheckingAccountTable(){

        //SQL statement for creating Checking Account table
        String sql = "CREATE TABLE IF NOT EXISTS CheckingAccount (\n "
                + "UUID TEXT NOT NULL UNIQUE, \n"
                + "CustomerName TEXT NOT NULL,\n"
                + "SSN TEXT NOT NULL,\n"
                + "CustomerBalance REAL NOT NULL,\n"
                + "PRIMARY KEY(UUID)\n"
                + ");";

        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement())
        {
            stmt.execute(sql);
        }
        catch (SQLException e)
        {
            System.out.println("Transaction recorded.");
        }
    }

    public static void createsNewSavingsAccountTable(){

        //SQL statement for creating Checking Account table
        String sql = "CREATE TABLE IF NOT EXISTS SavingsAccount (\n "
                + "UUID TEXT NOT NULL UNIQUE, \n"
                + "CustomerName TEXT NOT NULL,\n"
                + "SSN TEXT NOT NULL,\n"
                + "CustomerBalance REAL NOT NULL,\n"
                + "PRIMARY KEY(UUID)\n"
                + ");";

        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement())
        {
            stmt.execute(sql);
        }
        catch (SQLException e)
        {
            System.out.println("Transaction recorded.");
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
            System.out.println("Transaction recorded.");
        }
    }


    public boolean depositIntoCheckingAccount(String SSN, Double deposit){
        String sql = "SELECT * FROM CheckingAccount WHERE SSN = " +SSN;
        String UUID = "";
        String customerName="";
        Double Balance = 0.0;
        boolean depositWorked = false;
        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt  = conn.createStatement();
             ResultSet resultSet = stmt.executeQuery(sql)) {
            while(resultSet.next()){
                UUID = resultSet.getString("UUID");
                customerName = resultSet.getString("CustomerName");
                Balance = resultSet.getDouble("CustomerBalance");
//                System.out.println("original balance " + Balance);
                Balance = Balance + deposit;
//                System.out.println("this is the new Balance " +Balance);
            }
            depositWorked = true;
        }
        catch(SQLException e){
        System.out.println("The bank got robbed! Call 911!");
        depositWorked = false;
        }
        String sqlupdate = "UPDATE Account SET UUID = ?, CustomerName = ?, SSN = ?, CustomerBalance = ? WHERE SSN = " +SSN;
        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(sqlupdate)) {
            pstmt.setString(1,UUID);
            pstmt.setString(2,customerName);
            pstmt.setString(3,SSN);
            pstmt.setDouble(4, Balance);
            pstmt.executeUpdate();
            depositWorked = true;
        } catch (SQLException e) {
            System.out.println("Transaction recorded.");
            depositWorked = false;
        }

        return depositWorked;
    }

    public Boolean withdrawFromCheckingAccount(String SSN, Double withdrawal){
        String sql = "SELECT * FROM CheckingAccount WHERE SSN = " +SSN;
        String UUID = "";
        String customerName="";
        Double Balance = 0.0;



        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt  = conn.createStatement();
             ResultSet resultSet = stmt.executeQuery(sql)) {
            while(resultSet.next()){
                UUID = resultSet.getString("UUID");
                customerName = resultSet.getString("CustomerName");
                Balance = resultSet.getDouble("CustomerBalance");
                Balance = Balance - withdrawal;
                System.out.println("this is the new Balance " +Balance);
            }
        }
        catch(SQLException e){
            System.out.println("The bank got robbed! Call 911!");
        }
        String sqlupdate = "UPDATE Account SET UUID = ?, CustomerName = ?, SSN = ?, CustomerBalance = ? WHERE SSN = " +SSN;

        if((Balance>=0.0)){
            try (Connection conn = DriverManager.getConnection(url);
                 PreparedStatement pstmt = conn.prepareStatement(sqlupdate);
                    /*ResultSet resultSet = pstmt.executeQuery(sqlupdate)*/) {
                pstmt.setString(1, UUID);
                pstmt.setString(2, customerName);
                pstmt.setString(3, SSN);
                pstmt.setDouble(4, Balance);
                System.out.println("We're remove this " + withdrawal + " from your account");
                pstmt.executeUpdate();
            } catch (SQLException e) {
                System.out.println("Transaction recorded.");
            }
            return true;
        }
        else
            return false;



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
            System.out.println("Transaction recorded.");
        }
    }

    public void insertIntoNewCheckingAccount(String ID, String customerName, String SSN, Double Balance){
        String sql = "INSERT INTO Account (UUID, CustomerName, SSN, CustomerBalance) VALUES (?,?,?,?)";
        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, ID);
            pstmt.setString(2, customerName);
            pstmt.setString(3,SSN);
            pstmt.setDouble(4, Balance);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Transaction recorded.");
        }
    }

    public boolean isUserAccountInDB(String SSN){
        boolean flag = false;
        String sql = "SELECT SSN FROM UserAccounts WHERE SSN = " +SSN;
        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt  = conn.createStatement();
             ResultSet resultSet = stmt.executeQuery(sql)) {
            while(resultSet.next()){
                String existingSSN = resultSet.getString("SSN");
                if(existingSSN.equals(SSN))
                flag = true;
                else
                    flag=false;
            }
        }
        catch(SQLException e){
            flag = false;
        }
        return flag;
    }


    public void displayAccountInformation(String SSN){
        String sql = "SELECT * FROM Account WHERE SSN = " +SSN;
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###.00");
        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt  = conn.createStatement();
             ResultSet resultSet = stmt.executeQuery(sql)) {
            while(resultSet.next()){
                String UUID = resultSet.getString("UUID");
                String customerName = resultSet.getString("CustomerName");
                String customerSSN = resultSet.getString("SSN");
                Double customerBalance = resultSet.getDouble("CustomerBalance");
                System.out.print("Account ID: " + UUID + "\t");
                System.out.print("Name: " +customerName+ "\t");
                System.out.print("SSN: " +customerSSN+ "\t");
                System.out.println("Balance: $" +decimalFormat.format(customerBalance)+ "\t");
            }
        }
        catch(SQLException e){

        }
    }
}