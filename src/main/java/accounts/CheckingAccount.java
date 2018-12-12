package accounts;

import Transactions.TransactionList;
import org.joda.time.LocalDateTime;

import java.util.List;
import java.util.UUID;

public abstract class CheckingAccount implements Account {
    private Double balance;
    private LocalDateTime accountCreationDate;
    private TransactionList transactionList;
    private UUID accountNumber = UUID.randomUUID();


    public CheckingAccount(Double initialBalance) {
        this.balance = initialBalance;

        LocalDateTime currentDate = new LocalDateTime();
        this.accountCreationDate = currentDate;
    }



    public UUID getAccountNumber() {
        return accountNumber;
    }

    //Here we do date manipulation to return required amount from customer
    public abstract Double getInitialBalance(Double initialBalance);

    public abstract void requestDeposit(Transactions.Transaction deposit);

    public abstract void requestWithdrawal(Transactions.Transaction withdrawal);



}