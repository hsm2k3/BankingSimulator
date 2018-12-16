package Accounts;

//import Transactions.TransactionList;
import org.joda.time.LocalDateTime;

import java.util.UUID;

public class JuniorCheckingAccount{
    private static final int UUID = 0;
    private static final int customerName = 1;
    private static final int balance = 2;
    private String[][] juniorCheckingAccount;
    private int index;

    public String[][] getJuniorCheckingAccount(String UUID, String customerName, Double balance, int index){
        this.index = index;
        this.juniorCheckingAccount = new String[this.index+1][3];
        this.juniorCheckingAccount[this.index][this.UUID] = UUID;
        this.juniorCheckingAccount[this.index][this.customerName] = customerName;
        this.juniorCheckingAccount[this.index][this.balance] = balance.toString();

        return this.juniorCheckingAccount;
    }
}
