package Accounts;

import Transactions.TransactionList;
import org.joda.time.LocalDateTime;

import java.util.UUID;

public class JuniorAccount implements Account {

    private Double balance;
    private LocalDateTime accountCreationDate;
    private UUID accountNumber = UUID.randomUUID();

    public JuniorAccount(Double moneyInWallet){
        this.balance = getInitialDeposit(moneyInWallet);
        LocalDateTime currentDate = new LocalDateTime();
        this.accountCreationDate = currentDate;
    }

    public Double getInitialDeposit(Double moneyInWallet){
        return moneyInWallet*0.4;
    }

    public Boolean makeDeposit(Transaction deposit){
        //Checks if the amount is not negative
        if(verifyAmount(deposit)) {
            this.balance += deposit.getAmount();
            return true;
        }
        else
            return false;
    }

    public Boolean verifyAmount(Transaction transaction){
        if(transaction.getAmount() < 0.0)
            return false;
        else
            return true;
    }

    public UUID getAccountNumber(){return accountNumber;}
    public Double getBalance(){return balance;}
    public LocalDateTime getAccountCreationDate(){return accountCreationDate;}

}
