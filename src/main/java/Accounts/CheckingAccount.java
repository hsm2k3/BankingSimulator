package Accounts;
//import Transactions.TransactionList;
import org.joda.time.DateTime;
import org.joda.time.LocalDateTime;

import java.util.List;
import java.util.UUID;

public abstract class CheckingAccount {
    private Double balance;
    private Double initialBalance;
    private LocalDateTime accountCreationDate;
//    private TransactionList transactionList;
    private UUID accountNumber = UUID.randomUUID();


    public void CheckingAccount(Double initialBalance, DateTime accountCreationDate, List transactionHistory) {
        //----------------------CheckingAccount personalChecking = new CheckingAccount();
        this.accountCreationDate = getCurrentDate();
        //  this.balance = getInitialBalance(initialBalance);
    }

    private LocalDateTime getCurrentDate() {
        LocalDateTime currentDate = new LocalDateTime();
        return currentDate;
    }

    //Here we do date manipulation to return required amount from customer
    public abstract Double getInitialBalance(Double initialBalance);

//    public abstract void requestDeposit(Transactions.Transaction deposit);

//    public abstract void requestWithdrawal(Transactions.Transaction withdrawal);

    ///aSdasdasdasd
}