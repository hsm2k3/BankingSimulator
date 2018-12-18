package Bank.Employees;

import customer.Customer;

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

//    public Customer getCustomerAccount(String UUID, String customerName, String accountCreationDate, String DOB){
//        setCurrentCustomer(branchManager.addCheckingAccount(UUID,customerName, accountCreationDate, DOB));
//        return branchManager.getUserAccount(name, dateOfBirth);
//    }

//    public boolean doesUserAccountExists(String name, String SSN, String dob){
//        if(branchManager.doesUserAccountExist(name, SSN, dob))
//            return true;
//        else
//            return false;
//    }
    public void addUserAccount(String name, String SSN, String dob){
        this.branchManager.addUserAccount(this.uuid,name,SSN,dob);
    }
    public void addCheckingAccount(String name, String SSN, Double balance){
        this.branchManager.addCheckingAccount(this.uuid,name,SSN, balance);

    }
    public void addSavingsAccount(String name, String SSN, String DOB, Double balance){
        this.branchManager.addSavingsAccount(this.uuid,name,SSN,balance);

    }
    public void addJuniorCheckingAccount(String name, String SSN, Double balance){
        this.branchManager.addJuniorCheckingAccount(this.uuid,name,SSN, balance);

    }
//    public void addJuniorSavingsAccount(String name, String SSN, Double balance){
//        this.branchManager.addJuniorSavingsAccount(this.uuid,name,SSN, balance);
//
//    }
//    public void depositToCheckingAccount(String name, String SSN, Double deposit){
//        this.branchManager.depositToCheckingAccount(this.uuid,name,SSN,deposit);
//    }
//
//    public void depositToSavingsAccount(String name, String SSN, Double deposit){
//        this.branchManager.depositToSavingsAccount(this.uuid,name,SSN,deposit);
//    }

    public void depositToJuniorCheckingAccount(String SSN, Double deposit){
        this.branchManager.depositToJuniorCheckingAccount(SSN,deposit);
    }

    public Boolean withdrawlFromJuniorCheckingAccount(String SSN, Double withdrawal){
        return this.branchManager.withdrawalFromJuniorCheckingAccount(SSN, withdrawal);
    }

//    public void depositToJuniorSavingsAccount(String name, String SSN, Double deposit){
//        this.branchManager.depositToJuniorSavingsAccount(this.uuid,name,SSN,deposit);
//    }
//    public boolean withdrawFreeMoney(Double freeMoney){
//        if(this.branchManager.withDrawFromBankFunds(freeMoney))
//            return true;
//        else
//            return false;
//    }

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
