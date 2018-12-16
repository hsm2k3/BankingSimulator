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

    //    public Boolean passDeposit()

    public String setUUID(){
        UUID customerID = UUID.randomUUID();
        return this.uuid = customerID.toString();
    }

//    public Customer getCustomerAccount(String UUID, String customerName, String accountCreationDate, String DOB){
//        setCurrentCustomer(branchManager.addUserAccount(UUID,customerName, accountCreationDate, DOB));
//        return branchManager.getUserAccount(name, dateOfBirth);
//    }

    public boolean doesUserAccountExists(String name, String dob){
        if(branchManager.doesUserAccountExist(name,dob))
            return true;
        else
            return false;
    }

    public void addUserAccout(String name, String dob){
        branchManager.addUserAccount(this.uuid,name,dob);
    }

}
