package Accounts;

public class UserAccounts {
    private static final int UUID = 0;
    private static final int customerName = 1;
    private static final int accountCreationDate = 2;
    private static final int SSN = 3;
    private static final int DOB = 4;
    public static String[][] userAccounts;
    protected static int rows;

//    public String[][] doesUserAccountExist(/*String UUID, String customerName, String accountCreationDate,
//                                           String SSN, String dob, int index*/){
////        this.rows = index;
////        this.userAccounts = new String[this.rows +1][5];
////        this.userAccounts[index][this.UUID] = UUID;
////        this.userAccounts[index][this.customerName] = customerName;
////        this.userAccounts[index][this.accountCreationDate] = accountCreationDate;
////        this.userAccounts[index][this.SSN] = SSN;
////        this.userAccounts[index][this.DOB] = dob;
////        System.out.print(this.userAccounts[this.rows][this.UUID]+" ");
////        System.out.print(this.userAccounts[this.rows][this.customerName]+" ");
////        System.out.print(this.userAccounts[this.rows][this.accountCreationDate]+" ");
////        System.out.print(this.userAccounts[this.rows][this.SSN]+" ");
////        System.out.println(this.userAccounts[this.rows][this.DOB]+" ");
////        System.out.println(" this.rows is : " + this.rows);
////        System.out.println("another entry: " + this.userAccounts[0][1]);
//
//
////        for(int i = 0; i < this.rows;i ++)
////            System.out.println("doesUserAccountExist : " + this.userAccounts[this.rows ][1]);
//        return this.userAccounts;
//    }
//
//    public String[][] getUserAccounts(String[][] userAccounts, int index){
//        return this.userAccounts;
//    }
//
//    public String[][] setUserAccounts(String[][] userAccounts, int index){
//        for(int i = 0; i <index;i++){
//            this.userAccounts[i][this.UUID] = userAccounts[i][this.UUID];
//            this.userAccounts[i][this.customerName] = userAccounts[i][this.customerName];
//            this.userAccounts[i][this.accountCreationDate] = userAccounts[i][this.accountCreationDate];
//            this.userAccounts[i][this.SSN] = userAccounts[i][this.SSN];
//            this.userAccounts[i][this.DOB] = userAccounts[i][this.DOB];
//            System.out.println(this.userAccounts[i][this.customerName]);
//        }
//
//        return this.userAccounts;
//    }

//    public boolean doesUserAccountExist(String customerName, String SSN, String DOB){
//        boolean doesExist = false;
//
//
////            if (this.userAccounts[i][this.customerName].equals(customerName)
////                    && this.userAccounts[i][this.DOB].equals(DOB)
////                    && this.userAccounts[i][this.SSN].equals(SSN))
////            doesExist = true;
////            else
////            doesExist = false;
////            String[][] localString = getUserAccounts();
////            System.out.println("localString " + localString[i][1]);
//
//            return doesExist;
//    }
}
