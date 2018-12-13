package Bank.Employees;

import customer.Customer;

import java.util.UUID;

public class Teller {
    private BranchManager branchManager;
    public Teller(BranchManager branchManager){
        this.branchManager = branchManager;
    }

    //    public Boolean passDeposit()

    public UUID assisgnCustomerID(){
        UUID customerID = UUID.randomUUID();
        return customerID;
    }

    public void checkAccountExists(String name, String DateTime){

    }

}
