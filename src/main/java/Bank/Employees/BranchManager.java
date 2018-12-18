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
    public void addToAccount(String UUID, String customerName, String SSN, Double balance){
        this.bank.addToAccount(UUID,balance,customerName,SSN);
    }
    public boolean depositToAccount(String SSN, Double deposit){
        return this.bank.depositToAccount(SSN,deposit);
    }

    public Boolean withdrawalFromJuniorCheckingAccount(String SSN, Double withdrawal){
        return this.bank.withdrawalFromJuniorCheckingAccount(SSN, withdrawal);
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


