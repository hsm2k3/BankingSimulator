import org.joda.time.DateTime;
import org.joda.time.LocalDateTime;

import java.util.ArrayList;
import java.util.List;

public class CheckingAccount {
    private Double balance;
    private Double initialBalance;
    private LocalDateTime accountCreationDate;
    List<Transaction> transactionHistory = new ArrayList();

    public void CheckingAccount(Double initialBalance, DateTime accountCreationDate, List transactionHistory) {
        CheckingAccount personalChecking = new CheckingAccount();
        this.accountCreationDate = getCurrentDate();
        //  this.balance = getInitialBalance(initialBalance);
    }

    private LocalDateTime getCurrentDate() {
        LocalDateTime currentDate = new LocalDateTime();
        return currentDate;
    }
/*
    public Double getInitialBalance(Double initialBalance) {
        // if(accountCreationDate.get)
        //}
    }*/

    //How would I go about passing the money from the account holder
    //as a transaction to the Banker
    public void withdrawal(Double amount){

    }
}