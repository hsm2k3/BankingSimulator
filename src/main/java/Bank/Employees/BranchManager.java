package Bank.Employees;
import Bank.Bank;

public class BranchManager {
    private Bank bank;
    public BranchManager(Bank bank){
        this.bank = bank;
    }

    public boolean isBankOpen(){
        if(this.bank.connectToDatabase())
            return true;
        else
            return false;
    }

    public void loadUserAccounts(){
        this.bank.getUserAccounts();
    }

    public void loadCheckingAccounts(){
        this.bank.getCheckingAccounts();
    }

    public void loadSavingsAccounts(){
        this.bank.getSavingsAccounts();
    }

    public void loadJuniorCheckingAccounts(){
        this.bank.getJuniorCheckingAccounts();
    }

    public void loadJuniorSavingsAccounts(){
        this.bank.getJuniorSavingsAccounts();
    }

    public boolean doesUserAccountExist(String customerName, String DOB){
        if(this.bank.doesUserAccountExist(customerName,DOB))
            return true;
        else
            return false;
    }

    public boolean addUserAccount(String UUID, String customerName, String DOB){
        String accountCreationDate = "";
        if(this.bank.doesUserAccountExist(customerName,DOB)) {
            System.out.println(customerName + " already has an account");
            return false;
        }
        else {
            this.bank.addUserAccount(UUID, customerName, accountCreationDate, DOB);
            return true;
        }
    }

}
