package Accounts;

public class UserAccounts {
    private static final int UUID = 0;
    private static final int customerName = 1;
    private static final int accountCreationDate = 2;
    private static final int DOB = 3;
    private String[][] userAccounts;
    private int index;


    public String[][] getUserAccounts(String UUID, String customerName, String accountCreationDate,
                                 String dob,int index){
        this.index = index;
        this.userAccounts = new String[this.index+1][4];
        this.userAccounts[this.index][this.UUID] = UUID;
        this.userAccounts[this.index][this.customerName] = customerName;
        this.userAccounts[this.index][this.accountCreationDate] = accountCreationDate;
        this.userAccounts[this.index][this.DOB] = dob;
        return this.userAccounts;
    }
    public boolean doesUserAccountExist(String customerName, String DOB){
        boolean isFound = false;
        for (int i = 0; i < this.index;i++)
            if (this.userAccounts[i][this.customerName].equals(customerName)
                    && this.userAccounts[i][this.DOB].equals(DOB))
                isFound = true;
            else
                isFound = false;
            return isFound;
    }
}
