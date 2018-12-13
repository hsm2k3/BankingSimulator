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

    public Boolean removeTransaction(UUID transactionUUID){
        //Searches for the transaction and adds removes it
        for(Integer i =0; i<transactionList.size(); i++) {
            if (transactionList.get(i).getTransactionID() == transactionUUID) {
                transactionList.remove(i);
                return true;
            }
        }

        return false;
    }

    public Transaction getTransaction(UUID transactionUUID){
        for(Integer i =0; i<transactionList.size(); i++) {
            if (transactionList.get(i).getTransactionID() == transactionUUID)
            return transactionList.get(i);
        }
        return null;
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
}
