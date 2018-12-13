import org.joda.time.DateTime;
import org.joda.time.LocalDateTime;

import java.util.Date;
import java.util.UUID;

public class Transaction {
    private UUID transactionID = UUID.randomUUID();
    private String customerNote;
    private DateTime transactionDate;
    private Double amount;

    public Transaction(String customerNote, Double amount){
        this.customerNote = customerNote;
        this.amount = amount;
        this.transactionDate = DateTime.now();
    }

    //Amount
    public Double getAmount(){return this.amount;}

    //DateTime
    public DateTime getTransactionDate(){return this.transactionDate;}
    public String getTransactionDateasString(){return this.transactionDate.toString();}

    //Transaction ID
    public UUID getTransactionID(){return this.transactionID; }
    public String getTransactionIDasString(){return this.transactionID.toString();}

    //Note
    public String getCustomerNote(){return this.customerNote;}

}