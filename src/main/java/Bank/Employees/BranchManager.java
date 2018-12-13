package Bank.Employees;
import Bank.Bank;
import customer.Customer;

public class BranchManager {
    private Bank bank;
    public BranchManager(Bank bank){
        this.bank = bank;
    }

    public void addUserAccount(Customer newCustomer){
        newCustomer.getCustomerDOB();

    }

}
