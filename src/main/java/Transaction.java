import org.joda.time.DateTime;
import org.joda.time.LocalDateTime;

public class Transaction {
    Double amount;
    String note;
    private LocalDateTime transactionDate;


    public void Transaction(Double amount, String note, DateTime transactionDate){
        Transaction newTransaction = new Transaction();
        this.amount = getAmount(amount);
        this.note = getNote(note);
        this.transactionDate = getCurrentDate();
    }

    public Double getAmount(Double amount){
        if(amount > 0.0)
          return amount;
        else
            throw new IncorrectAmountException("Yo don't be doing that dog"){};
    }

    public String getNote(String note){
        if((note == null) || (note.isEmpty()))
            return "No note included for this transaction";
        else
            return note;
        }

        private LocalDateTime getCurrentDate(){
            LocalDateTime currentDate = new LocalDateTime();
            return currentDate;
        };

}
