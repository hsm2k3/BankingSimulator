package customer;

import org.joda.time.DateTime;
import org.joda.time.Period;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;
import java.util.UUID;

//HAD to move to main to allow the constructor to work;

//we should make the unique ID for the customer in this class as well.

public class Customer {
    //Fields
    private String customerName;
    private String customerDOB;
    private String customerSSN;
    private String accountCreationDate;
    private Double customerBalance;

    //Tells the user
    private Boolean isMinor;

    //Constructor
    public Customer() {
    }



    //Functions for name
    public String setCustomerName(String name) {
        return this.customerName = name;
    }

    //Functions for returning date of birth


    public String setCustomerDOB(String DOB) {
        return this.customerDOB = DOB;

    }

    public String setCustomerSNN(String SSN){
        return this.customerSSN = SSN;
    }

    public Double setCustomerBalance(Double balance){
        return this.customerBalance = balance;
    }


    //Getters and Setters for isMinor
    public boolean isMinor(String DOB) throws ParseException {
        String now = LocalDateTime.now().format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy");
        SimpleDateFormat customerDOB = new SimpleDateFormat("MM/dd/yyyy");
//        this will throw a ParseException if the date format is wrong
        Date today = simpleDateFormat.parse(now);
        Date dob = customerDOB.parse(DOB);
        DateTime dateOfBirth = new DateTime(dob);
        DateTime currentDate = new DateTime(today);


        Period period = new Period(dateOfBirth, currentDate);

        //Basing availability of accounts on age
        if ((period.getYears() < 18))
            return this.isMinor = true;
        else
            return this.isMinor = false;
    }

}