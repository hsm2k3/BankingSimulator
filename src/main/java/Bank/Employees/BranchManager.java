package Bank.Employees;
import Bank.Bank;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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
        System.out.println("branchmanager is called");
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

//    public boolean doesUserAccountExist(String customerName, String SSN, String DOB){
//        if(this.bank.doesUserAccountExist(customerName,SSN, DOB))
//            return true;
//        else
//            return false;
//    }

    public void addUserAccount(String UUID, String customerName, String SSN, String DOB){
        String accountCreationDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));

            this.bank.addUserAccount(UUID, customerName, accountCreationDate, SSN, DOB);

        }

        public void addCheckingAccount(String UUID, String customerName, String SSN, Double balance){
        this.bank.addCheckingAccount(UUID,balance,customerName,SSN);
        }
    public void addSavingsAccount(String UUID, String customerName, String SSN, Double balance){
        this.bank.addSavingsAccount(UUID,balance,customerName,SSN);
    }
    public void addJuniorCheckingAccount(String UUID, String customerName, String SSN, Double balance){
        this.bank.addJuniorCheckingAccount(UUID,balance,customerName,SSN);
    }
//    public void addJuniorSavingsAccount(String UUID, String customerName, String SSN, Double balance){
//        this.bank.addJuniorSavingsAccount(UUID,balance,customerName,SSN);
//    }
    public void depositToCheckingAccount(String UUID, String customerName, String SSN, Double deposit){
        this.bank.depositToCheckingAccount(UUID,customerName,SSN,deposit);
    }
    public void depositToSavingsAccount(String UUID, String customerName, String SSN, Double deposit){
        this.bank.depositToSavingsAccount(UUID,customerName,SSN,deposit);
    }
    public void depositToJuniorCheckingAccount(String SSN, Double deposit){
        this.bank.depositToJuniorCheckingAccount(SSN,deposit);
    }

    public Boolean withdrawalFromJuniorCheckingAccount(String SSN, Double withdrawal){
        return this.bank.withdrawalFromJuniorCheckingAccount(SSN, withdrawal);
    }
//    public void depositToJuniorSavingsAccount(String UUID, String customerName, String SSN, Double deposit){
//        this.bank.depositToJuniorSavingsAccount(UUID,customerName,SSN,deposit);
//    }
    public boolean withDrawFromBankFunds(Double freeMoney){
        if(this.bank.withDrawFromBankFunds(freeMoney))
            return true;
        else
            return false;
    }
    public boolean checkUserAccount(String SSN){
        if(this.bank.checkUserAccount(SSN))
        return true;
            else
        return false;
    }

    public void displayAccountInformation(String SSN){
        this.bank.displayAccountInformation(SSN);
    }
}


