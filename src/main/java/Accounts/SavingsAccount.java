package Accounts;

public class SavingsAccount{
    private static final int UUID = 0;
    private static final int customerName = 1;
    private static final int balance = 2;
    private String[][] savingsAccounts;
    private int index;

    public String[][] getSavingsAccounts(String UUID, String customerName, Double balance, int index){
        this.index = index;
        this.savingsAccounts = new String[this.index+1][3];
        this.savingsAccounts[this.index][this.UUID] = UUID;
        this.savingsAccounts[this.index][this.customerName] = customerName;
        this.savingsAccounts[this.index][this.balance] = balance.toString();
        return this.savingsAccounts;
    }

}
