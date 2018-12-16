package customer;

import org.joda.time.DateTime;
import org.joda.time.Period;

import java.util.UUID;

//HAD to move to main to allow the constructor to work;

//we should make the unique ID for the customer in this class as well.

public class Customer {
    //Fields
    private String customerName;
    private DateTime dateOfBirth;
    private DateTime accountCreationDate;

    //Tells the user
    private Boolean isMinor;

    //Unique ID provided by customer
    UUID customerID = null;

    //Constructor
    public Customer(DateTime dob, String customerName) {
        this.dateOfBirth = dob;
        this.customerName = customerName;
        this.isMinor = setIsMinor(dob);
        this.accountCreationDate = DateTime.now();
    }

    public void setCustomerID(UUID newID){
        this.customerID = newID;
    }

    //Functions for name
    public String getCustomerName() {
        return this.customerName;
    }

    //Functions for returning date of birth
    public String getDateofBirthasString() {
        return this.dateOfBirth.toString();
    }

    public DateTime getCustomerDOB() {
        return this.dateOfBirth;
    }

    //Getters and Setters for isMinor
    private Boolean setIsMinor(DateTime dateOfBirth) {
        //Setting time and checking the difference in years
        DateTime currentDate = new DateTime();
        currentDate.getChronology();
        Period period = new Period(dateOfBirth, currentDate);

        //Basing availability of accounts on age
        if ((period.getYears() <= 18))
            return this.isMinor = false;
        else
            return this.isMinor = true;
    }

    public Boolean getisMinor() {
        return this.isMinor;
    }

}