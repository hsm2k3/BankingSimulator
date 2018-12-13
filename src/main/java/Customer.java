import org.joda.time.DateTime;
import org.joda.time.Period;

import java.util.UUID;

//HAD to move to main to allow the constructor to work;

//we should make the unique ID for the customer in this class as well.

public class Customer {
    private String customerName;
    private DateTime dateOfBirth;
    private Boolean isMinor;
    private Double inWallet;
    private UUID customerUUID = UUID.randomUUID();


    public Customer(DateTime dob, String customerName, Double inWallet) {
        this.dateOfBirth = dob;
        this.customerName = customerName;
        this.inWallet = inWallet;
        this.isMinor = setIsMinor(dob);
    }

    //Sanitizing user input -- returns false is !characters only
    protected UUID getUUID() {
        return this.customerUUID;
    }

    protected String getUUIDasString() {
        return customerUUID.toString();
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

    //inWallet
    public Double getInWallet(){return this.inWallet;}
    public Double setInWallet(Double changeAmount){return this.inWallet + changeAmount;}

}