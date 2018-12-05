import com.sun.org.apache.xpath.internal.operations.Bool;
import org.joda.time.DateTime;
import org.joda.time.Period;

import java.io.IOException;

public class Patron {
    private String firstName;
    private String lastName;
    private DateTime dateOfBirth;
    private Boolean isUnder18;

    public void Customer(String firstName, String lastName, DateTime dateOfBirth)throws IOException{
        Patron bankPatron = new Patron();
    }

     public String setFirstName(String firstName) throws IOException {
        if(checkOnlyCharacters(firstName))
            return firstName;
        else
            throw new IOException(){};
    }

    public String setLastName(String firstName) throws IOException {
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

    private void setIsUnder18(DateTime dateOfBirth){
        //Setting time and checking the difference in years
        DateTime currentDate = new DateTime();
        currentDate.getChronology();
        Period period = new Period(dateOfBirth, currentDate);

        //Basing availability of accounts on age
        if((period.getYears()<= 18))
            this.isUnder18 = false;
        else
            this.isUnder18 = true;
    }

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

    // public Boolean isTellerFree(){}
    // public void currentBalance(){}
    // public Boolean makeDeposit()
    //public Boolean requestBalance(){ }
}




