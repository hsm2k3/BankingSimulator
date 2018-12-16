package Accounts;

public class JuniorSavingsAccount {
    private static final int UUID = 0;
    private static final int customerName = 1;
    private static final int balance = 2;
    private String[][] juniorSavingsAccount;
    private int index;

    public String[][] getJuniorSavingsAccount(String UUID, String customerName, Double balance, int index){
        this.index = index;
        this.juniorSavingsAccount = new String[this.index+1][3];
        this.juniorSavingsAccount[this.index][this.UUID] = UUID;
        this.juniorSavingsAccount[this.index][this.customerName] = customerName;
        this.juniorSavingsAccount[this.index][this.balance] = balance.toString();
        return this.juniorSavingsAccount;
    }
}
