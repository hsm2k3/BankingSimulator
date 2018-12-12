package customer;

import org.joda.time.DateTime;
import org.joda.time.Period;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.UUID;

//we should make the unique ID for the customer in this class as well.

public class Customer {
    private String customerName;
    private String customerDOB;
    private DateTime dateOfBirth;
    private Boolean isMinor;
    private Double inWallet;
    private UUID patronID;
    private DateTime DOB;

    public void Customer(String firstName, String lastName, DateTime dateOfBirth)throws IOException {
        Customer bankPatron = new Customer();
        /* this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.isMinor = setIsUnder18(dateOfBirth);
        this.inWallet = inWallet;
        patronID = UUID.randomUUID();*/
    }

//    public String setFirstName(String firstName) throws IOException {
//        if(checkOnlyCharacters(firstName))
//            return firstName;
//        else
//            throw new IOException(){};
//    }
//
//    public String setLastName(String firstName) throws IOException {
//        if(checkOnlyCharacters(firstName))
//            return firstName;
//        else
//            throw new IOException(){};
//    }

    //Sanitizing user input -- returns false is !characters only
    private Boolean checkOnlyCharacters(String name){
        char[] chars = name.toCharArray();

        for (char c : chars) {
            if(!Character.isLetter(c)) {
                return false;
            }
        }
        return true;
    }
    public DateTime setDateOfBirth(Integer year, Integer month, Integer day) {
        DateTime DOB = new DateTime(year, month, day, 0,0 );
        isUnder18(DOB);
        return this.DOB = DOB;
    }
    private boolean isUnder18(DateTime dateOfBirth){
        //Setting time and checking the difference in years
        DateTime currentDate = new DateTime();
        currentDate.getChronology();
        Period period = new Period(dateOfBirth, currentDate);

        //Basing availability of accounts on age
        if((period.getYears()<= 18))
            return this.isMinor = false;
        else
            return this.isMinor = true;
    }


    public String setCustomerName(String customerName){

        return this.customerName = customerName;
    }

    public String setCustomerDOB(String customerDOB){
        return this.customerDOB = customerDOB;
    }

    public Date convertToDate() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        System.out.println(("convertToDate : " + this.customerDOB));
        return dateFormat.parse(this.customerDOB);
    }


    // public Boolean isTellerFree(){}
    // public void currentBalance(){}
    // public Boolean makeDeposit()
    //public Boolean requestBalance(){ }
}


/*
import org.joda.time.DateTime;
import org.joda.time.Period;

import java.io.IOException;
import java.util.UUID;

public class customer {
    private String firstName;
    private String lastName;
    private DateTime dateOfBirth;
    private Boolean isMinor;
    private Double inWallet;
    private UUID patronID;

    public Patron(String firstName, String lastName, DateTime dateOfBirth, Double inWallet ){
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.isMinor = setIsUnder18(dateOfBirth);
        this.inWallet = inWallet;
        patronID = UUID.randomUUID();
    }

    public String checkCharString(String name) throws IOException{
        if(checkOnlyCharacters(firstName))
            return firstName;
        else
            throw new IOException(){};
    }

    public DateTime setDateOfBirth(Integer year, Integer month, Integer day) {
        DateTime dateOfBirth = new DateTime(year, month, day, 0,0 );
        setIsUnder18(dateOfBirth);
        return dateOfBirth;
    }

    private Boolean setIsUnder18(DateTime dateOfBirth){
        //Setting time and checking the difference in years
        DateTime currentDate = new DateTime();
        currentDate.getChronology();
        Period period = new Period(dateOfBirth, currentDate);

        //Basing availability of accounts on age
        if(period.getYears() > 18)
            return false;
        else
            return true;

    }

    Double getInWallet(){return this.inWallet;}

    UUID getPatronID(){
        return this.patronID;
    }

    DateTime getDateOfBirth(){
        return this.dateOfBirth;
    }

    Boolean getIsMinor(){
        return isMinor;
    }

    String getFirstName(){
        return this.firstName;
    }

    public String getLastName(){return this.lastName;}

    //Sanitizing user input -- returns false is !characters only
    private Boolean checkOnlyCharacters(String name){
            char[] chars = name.toCharArray();

            for (char c : chars) {
                if(!Character.isLetter(c)) {
                    return false;
                }
            }
            return true;
        }

    public void postDepositInWalletBalance(Double balance){
        this.inWallet -= balance;
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public void postWithdrawalInWalletBalance(Double balance){
        this.inWallet += balance;
    }


    //Adding a new customer


    // public Boolean isTellerFree(){}
    // public void currentBalance(){}
    // public Boolean makeDeposit()
    //public Boolean requestBalance(){ }
}
*
* */