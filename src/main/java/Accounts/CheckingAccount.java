package Accounts;

//import Transactions.TransactionList;


public class CheckingAccount {
    private static final int UUID = 0;
    private static final int customerName = 1;
    private static final int balance = 2;
    private String[][] checkingAccounts;
    private int index;


    public String[][] getCheckingAccounts(String UUID, String customerName, Double balance, int index){
        this.index = index;
        this.checkingAccounts = new String[this.index+1][3];
        this.checkingAccounts[this.index][this.UUID] = UUID;
        this.checkingAccounts[this.index][this.customerName] = customerName;
        this.checkingAccounts[this.index][this.balance] = balance.toString();

        return this.checkingAccounts;
    }
}