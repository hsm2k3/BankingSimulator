import org.joda.time.DateTime;
import org.omg.IOP.TransactionService;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TransactionList {

    List<Transaction> transactionList = new ArrayList<>();

    public TransactionList(){
        List<Transaction> transactionList = new ArrayList<>();
    }


    public void addTransaction(Transaction recentTransaction){ transactionList.add(recentTransaction); }

//    public Boolean removeTransaction(UUID transactionUUID){
//        //Searches for the transaction and adds removes it
//        for(Integer i =0; i<transactionList.size(); i++) {
//            if (transactionList.get(i).getTransactionID() == transactionUUID) {
//                transactionList.remove(i);
//                return true;
//            }
//        }
//
//        return false;
//    }
//
//    public Transaction getTransaction(UUID transactionUUID){
//        for(Integer i =0; i<transactionList.size(); i++) {
//            if (transactionList.get(i).getTransactionID() == transactionUUID)
//            return transactionList.get(i);
//        }
//        return null;
//    }


    //This handles returning transactions from the last 30 days
    //You can very simply edit this to pass a day and get the transactions for that day.
    public ArrayList<Transaction> getPast30Days(){

        //Essentially this takes the current date
        DateTime currentDate = DateTime.now();
        Integer year = currentDate.getYear();
        Integer month = currentDate.getMonthOfYear();
        Integer day = currentDate.getDayOfMonth();

        //Formats it so it's like the rest of the dates
        DateTime newCurrentTime = new DateTime(year, month, day, 0, 0, 0);

        //Setting time and checking the difference in years
        List<String> daysInbetween = new ArrayList<>();

        //Then this creates an ArrayList of Strings that has all the possible dates from the last
        //30 days.
        for(Integer i=0; i<31;i++) {
            DateTime newDate =  newCurrentTime.minusDays(i);
            daysInbetween.add(newDate.toString());
        }


        //-------------------HERE IS WHERE THE REAL WORK IS DONE----------------------------
        //HERE IS WHERE YOU WOULD DO A LOOP AND CHECK THE DB FOR MATCHES
        //for(i =0; i<31; i++){
        //if("PULL DATABASE TRANSACTION DATE" == daysInbetween.get(i))
        //  past30DayTransactions.add("TRANSACTION IS PASSED HERE))
        //

        //HERE YOU WOULD RETURN past30DayTransactions as the entire transaction list;
        return null;
    }
}

/*
    public ArrayList<Transaction> getTransBelow500(){
        //initialize new ArrayList of Transactions
        //For each loop going through them
            //myList.add(i)

        //retrun myList();
    }
*/
/*
   ============ these consist of either simple returns or for each loops==========
   ------------ wasn't sure what else to add lmk for features ====================
    public Boolean removeTransaction(){};
    public Boolean returnAllTransactions(){};
    public Map reutrnTransBelow500(){};
 */

