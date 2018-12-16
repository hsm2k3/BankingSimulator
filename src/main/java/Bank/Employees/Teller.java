package Bank.Employees;

import customer.Customer;

import java.util.UUID;

public class Teller {

    //In this class I added a currentCustomer field and the setCurrentCustomer() method
    //This is so that the teller can directly interact with the instance. I'm not sure if this
    //makes sense currently but we can always return the instance to update.
    private BranchManager branchManager;
    private Customer currentCustomer;

    public Teller(BranchManager branchManager){
        this.branchManager = branchManager;
    }

    //    public Boolean passDeposit()

    public UUID assisgnCustomerID(){
        UUID customerID = UUID.randomUUID();
        return customerID;
    }

    public Customer getCustomerAccount(String name, String dateOfBirth){
        setCurrentCustomer(branchManager.getUserAccount(name, dateOfBirth));
        return branchManager.getUserAccount(name, dateOfBirth);
    }

    public Boolean checkAccountExists(String name, String DateTime){
        //Does some kind of search, not sure how this would work within the Bank and SQL
    }

    public void setCurrentCustomer(Customer currentCustomer){
        this.currentCustomer = currentCustomer;
    }

    public String getCustomerName(){
        return this.currentCustomer.getCustomerName();
    }

}
