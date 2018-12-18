package sqliteDatabase;



import java.sql.*;

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



    public static void createsNewAccountTable(){

        //SQL statement for creating Checking Account table
        String sql = "CREATE TABLE IF NOT EXISTS Account (\n "
                + "UUID TEXT NOT NULL UNIQUE, \n"
                + "CustomerName TEXT NOT NULL,\n"
                + "SSN TEXT NOT NULL,\n"
                + "withdrawal REAL NOT NULL,\n"
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


    public void insertIntoAccount(String SSN, Double deposit){
        String sql = "SELECT * FROM Account WHERE SSN = " +SSN;
        String UUID = "";
        String customerName="";
        Double Balance = 0.0;
        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt  = conn.createStatement();
             ResultSet resultSet = stmt.executeQuery(sql)) {
            while(resultSet.next()){
                UUID = resultSet.getString("UUID");
                customerName = resultSet.getString("CustomerName");
                Balance = resultSet.getDouble("Balance");
//                System.out.println("original balance " + Balance);
                Balance = Balance + deposit;
//                System.out.println("this is the new Balance " +Balance);
            }
        }
        catch(SQLException e){
        System.out.println("The bank got robbed! Call 911!");
        }
        String sqlupdate = "UPDATE Account SET UUID = ?, CustomerName = ?, SSN = ?, Balance = ? WHERE SSN = " +SSN;
        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(sqlupdate);
             /*ResultSet resultSet = pstmt.executeQuery(sqlupdate)*/) {
            System.out.println("right before setDouble");
            pstmt.setString(1,UUID);
            pstmt.setString(2,customerName);
            pstmt.setString(3,SSN);
            pstmt.setDouble(4, Balance);
            System.out.println("We're adding this " + Balance+ " to your account");
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }


    }

    public Boolean withdrawFromAccount(String SSN, Double withdrawal){
        String sql = "SELECT * FROM Account WHERE SSN = " +SSN;
        String UUID = "";
        String customerName="";
        Double Balance = 0.0;



        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt  = conn.createStatement();
             ResultSet resultSet = stmt.executeQuery(sql)) {
            while(resultSet.next()){
                UUID = resultSet.getString("UUID");
                customerName = resultSet.getString("CustomerName");
                Balance = resultSet.getDouble("Balance");
                System.out.println("original balance " + Balance);
                Balance = Balance - withdrawal;
                System.out.println("this is the new Balance " +Balance);
            }
        }
        catch(SQLException e){
            System.out.println("The bank got robbed! Call 911!");
        }
        String sqlupdate = "UPDATE Account SET UUID = ?, CustomerName = ?, SSN = ?, Balance = ? WHERE SSN = " +SSN;

        if((Balance>=0.0)){
            try (Connection conn = DriverManager.getConnection(url);
                 PreparedStatement pstmt = conn.prepareStatement(sqlupdate);
                    /*ResultSet resultSet = pstmt.executeQuery(sqlupdate)*/) {
                System.out.println("right before setDouble");
                pstmt.setString(1, UUID);
                pstmt.setString(2, customerName);
                pstmt.setString(3, SSN);
                pstmt.setDouble(4, Balance);
                System.out.println("We're adding this " + Balance + " to your account");
                pstmt.executeUpdate();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
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
            System.out.println(e.getMessage());
        }
    }


    public boolean checkUserAccount(String SSN){
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
        String sql = "SELECT * FROM UserAccounts WHERE SSN = " +SSN;
        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt  = conn.createStatement();
             ResultSet resultSet = stmt.executeQuery(sql)) {
            while(resultSet.next()){
                String UUID = resultSet.getString("UUID");
                String customerName = resultSet.getString("CustomerName");
                String AccountCreationDate = resultSet.getString("AccountCreationDate");
                String customerSSN = resultSet.getString("SSN");
                String DOB = resultSet.getString("DOB");
                System.out.println(UUID);
                System.out.println(customerName);
                System.out.println(AccountCreationDate);
                System.out.println(customerSSN);
                System.out.println(DOB);
            }
        }
        catch(SQLException e){

        }
    }
}