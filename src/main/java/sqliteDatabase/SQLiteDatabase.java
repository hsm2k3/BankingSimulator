package sqliteDatabase;



import java.sql.*;

public class SQLiteDatabase {
    private static final String url = "jdbc:sqlite:bank.db";

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
                + "SSN TEXT NOT NULL,\n"
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

    public boolean withDrawFromBankFunds(Double freeMoney){
        boolean withdrawl = false;
        String sql = "UPDATE AvailableFunds SET TotalAvailableFunds = -(?)";
        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setDouble(1, freeMoney);
            pstmt.executeUpdate();
            withdrawl = true;
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
            System.out.println("Call 911 the bank was robbed!");
            withdrawl = false;
        }
        return withdrawl;
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

    public void insertIntoJuniorCheckingAccount(String SSN, Double deposit){
        String sql = "SELECT * FROM JuniorCheckingAccount WHERE SSN = " +SSN;
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
                Balance = Balance + deposit;
                System.out.println("this is the new Balance " +Balance);
            }
        }
        catch(SQLException e){
        System.out.println("The bank got robbed! Call 911!");
        }
        String sqlupdate = "UPDATE JuniorCheckingAccount SET UUID = ?, CustomerName = ?, SSN = ?, Balance = ? WHERE SSN = " +SSN;
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

    public Boolean wihdrawIntoJuniorCheckingAccount(String SSN, Double withdrawal){
        String sql = "SELECT * FROM JuniorCheckingAccount WHERE SSN = " +SSN;
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
        String sqlupdate = "UPDATE JuniorCheckingAccount SET UUID = ?, CustomerName = ?, SSN = ?, Balance = ? WHERE SSN = " +SSN;

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

//    public void insertIntoJuniorSavingsAccount(String ID, Double deposit,String SSN, String customerName){
//        String sql = "INSERT INTO JuniorSavingsAccount (UUID, customerName, SSN, JuniorSavingsBalancae) VALUES (?,?,?,?)";
//        try (Connection conn = DriverManager.getConnection(url);
//             PreparedStatement pstmt = conn.prepareStatement(sql)) {
//            pstmt.setString(1, ID);
//            pstmt.setString(2, customerName);
//            pstmt.setString(3,SSN);
//            pstmt.setDouble(4,deposit);
//            pstmt.executeUpdate();
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
//    }


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
        String [][]userAccountsString = new String[index+1][5];
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
//                checkingAccount.setIndex(index);


                System.out.println(userAccountsString[index][0]);
                index++;
                System.out.println(userAccountsString[index][0]);
                System.out.println("this is index from DB " + index);

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
//                checkingAccount.getCheckingAccounts(UUID,customerName,balance,index);
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
                index++;
            }
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean checkUserAccount(String SSN){
        boolean flag = false;
        String sql = "SELECT SSN FROM UserAccounts WHERE SSN = " +SSN;
        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt  = conn.createStatement();
             ResultSet resultSet = stmt.executeQuery(sql)) {
            while(resultSet.next()){
                String SSN2 = resultSet.getString("SSN");
                if(SSN2.equals(SSN))
                flag = true;
            }
        }
        catch(SQLException e){
            flag = false;
        }
        return flag;
    }

//    public boolean doesUserAccountExist(String customerName, String SSN, String DOB){
//        if (userAccounts.doesUserAccountExist(customerName,SSN,DOB,index))
//            return true;
//        else
//            return false;
//    }
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