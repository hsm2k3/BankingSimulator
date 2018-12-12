package bank.employees;

import accounts.JuniorAccount;
import customer.Customer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Teller {

    String Name;
    Boolean isAvailable;
    List<Customer> customerList = new ArrayList<Customer>();

    private BranchManager branchManager;
    public Teller(BranchManager branchManager){
        this.branchManager = branchManager;
    }
    //display menu when user visits the teller
    //we should make some methods that will check if a customer exist
    //if they are already in the system we give them one type of menu
    //if they don't exist we give them another type of menu

    public void createsNewCheckingAccount(){

    }

    public Teller (){
    }

    public void setAvailable(Boolean available) {
        isAvailable = available;
    }

    public accounts.Account createNewJuniorAccount(Customer customer){
        accounts.Account newJuniorAccount = new JuniorAccount(calculateInitialBalanace(customer.getInWallet()));
        return newJuniorAccount;
    }

    public Double calculateInitialBalanace(Double customerAmountInWallet){
        return customerAmountInWallet*.8;
    }
    public void recieveCustomerList(List customerList){
        this.customerList = customerList;
    }
}

/*

        -------PLACE IN MAIN---------------------------------------

    public int displayTellerMenu(Scanner scanner, String customerName){
        int selection = 0;
        boolean validSelection = true;
        do {
            System.out.println("Welcome, " + customerName + ", how may I help you today?");
            System.out.println("----------------------------------------");
            System.out.println("1. Make a new checking account.");
            System.out.println("2. Make a new savings account.");
            System.out.println("3. Deposit money into checking account.");
            System.out.println("4. Deposit money into savings account.");
            System.out.println("5. Withdraw money from checking account.");
            System.out.println("6. Withdraw money from savings account.");
            System.out.println("7. Leave teller.");
            System.out.println("----------------------------------------");
            selection = scanner.nextInt();
            if(selection > 7 || selection < 1)
                validSelection = false;
            else
                validSelection = true;
        }while (!validSelection);
        return selection;
    }*/