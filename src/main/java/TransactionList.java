import java.util.ArrayList;
import java.util.List;

public class TransactionList {

    List<Transaction> transactionList = new ArrayList<>();

    public TransactionList(){
        List<Transaction> transactionList = new ArrayList<>();
    }

    public Boolean addTransaction(Transaction recentTransaction){
        transactionList.add(recentTransaction);

        return true;
    }
/*
   ============ these consist of either simple returns or for each loops==========
   ------------ wasn't sure what else to add lmk for features ====================
    public Boolean removeTransaction(){};
    public Boolean returnAllTransactions(){};
    public Boolean returnMonthlyStatement(){};
    public Boolean reutrnTransBelow500(){};
 */
}
