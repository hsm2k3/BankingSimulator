import org.joda.time.LocalDateTime;

import java.util.UUID;

public class Transaction {
    public Double amount;
    public String note;
    public LocalDateTime transactionDate;
    public UUID transactionNumber;

    public Transaction(Double amount, String note) {
        this.amount = amount;
        this.note = note;
        this.transactionDate = getCurrentDate();
        this.transactionNumber = UUID.randomUUID();
    }

    public Double getAmount() {
        return this.amount;
    }

    public String getNote() {
        if ((note == null) || (note.isEmpty()))
            return "No note included for this transaction";
        else
            return note;
    }

    public LocalDateTime getCurrentDate() {
        LocalDateTime currentDate = new LocalDateTime();
        return currentDate;
    }

    public UUID getTransactionNumber() {
        return this.transactionNumber;
    }

}