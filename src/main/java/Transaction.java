import org.joda.time.DateTime;
import org.joda.time.LocalDateTime;

import java.util.Date;
import java.util.UUID;

public class Transaction {
    private String transactionID;
    private String customerNote;
    private DateTime transactionDate;
    private Double amount;

    public Transaction(String customerNote, String UUID, Double amount){
        this.transactionID = UUID;
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
    public String getTransactionIDasString(){return this.transactionID.toString();}

    //Note
    public String getCustomerNote(){return this.customerNote;}

}