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



    public void addUserAccount(String UUID, String customerName, String SSN, String DOB){
        String accountCreationDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));

            this.bank.addUserAccount(UUID, customerName, accountCreationDate, SSN, DOB);

        }
    public void addNewCheckingAccount(String UUID, String customerName, String SSN, Double balance){
        this.bank.addNewCheckingAccount(UUID,balance,customerName,SSN);
    }
    public boolean depositToCheckingAccount (String SSN, Double deposit){
        return this.bank.depositToCheckingAccount(SSN,deposit);
    }

    public Boolean withdrawalFromJuniorCheckingAccount(String SSN, Double withdrawal){
        return this.bank.withdrawalFromJuniorCheckingAccount(SSN, withdrawal);
    }


    public boolean isUserAccountInDB(String SSN){
        return this.bank.isUserAccountInDB(SSN);
    }

    public void displayAccountInformation(String SSN){
        this.bank.displayAccountInformation(SSN);
    }
}


