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
    public void addNewCheckingAccount(String name, String SSN, Double balance){
        this.branchManager.addNewCheckingAccount(this.uuid,name,SSN, balance);

    }

    public boolean depositToAccount(String SSN, Double deposit){
        return this.branchManager.depositToCheckingAccount(SSN,deposit);
    }

    public Boolean withdrawFromAccount(String SSN, Double withdrawal){
        return this.branchManager.withdrawalFromJuniorCheckingAccount(SSN, withdrawal);
    }

    public boolean isUserAccountInDB(String SSN){
        return this.branchManager.isUserAccountInDB(SSN);    }

    public void displayAccountInformation(String SSN){
        this.branchManager.displayAccountInformation(SSN);
    }
}
