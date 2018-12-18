package Bank.Employees;

import java.util.UUID;

public class Teller {

    //In this class I added a currentCustomer field and the setCurrentCustomer() method
    //This is so that the teller can directly interact with the instance. I'm not sure if this
    //makes sense currently but we can always return the instance to update.
    private BranchManager branchManager;
    protected String uuid;


    public Teller(BranchManager branchManager){
        this.branchManager = branchManager;
    }

//    public void printUserAccounts(){
//        System.out.println("printuseraccounts is called");
//
//    }
    //    public Boolean passDeposit()

    public String setUUID(){
        UUID customerID = UUID.randomUUID();
        return this.uuid = customerID.toString();
    }

    public void addUserAccount(String name, String SSN, String dob){
        this.branchManager.addUserAccount(this.uuid,name,SSN,dob);
    }
    public void addToAccount(String name, String SSN, Double balance){
        this.branchManager.addToAccount(this.uuid,name,SSN, balance);

    }

    public void depositToAccount(String SSN, Double deposit){
        this.branchManager.depositToAccount(SSN,deposit);
    }

    public Boolean withdrawlFromJuniorCheckingAccount(String SSN, Double withdrawal){
        return this.branchManager.withdrawalFromJuniorCheckingAccount(SSN, withdrawal);
    }

    public boolean checkUserAccount(String SSN){
        if(this.branchManager.checkUserAccount(SSN))
            return true;
        else
            return false;
    }

    public void displayAccountInformation(String SSN){
        this.branchManager.displayAccountInformation(SSN);
    }
}
