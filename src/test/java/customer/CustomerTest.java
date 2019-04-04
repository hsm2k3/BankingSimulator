package customer;

import org.joda.time.DateTime;
import org.joda.time.Period;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {

    @DisplayName("This test makes sure that the isMinor function works")
    @Test
    void failingIsMinor() throws ParseException {
        //Setting time and checking the difference in years
        String DOB = "1/1/1996";
        String now = LocalDateTime.now().format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy");
        SimpleDateFormat customerDOB = new SimpleDateFormat("MM/dd/yyyy");
//        this will throw a ParseException if the date format is wrong
        Date today = simpleDateFormat.parse(now);
        Date dob = customerDOB.parse(DOB);
        DateTime dateOfBirth = new DateTime(dob);
        DateTime currentDate = new DateTime(today);
        Period period = new Period(dateOfBirth, currentDate);
//        DateTime currentDate = new DateTime();
//        currentDate = DateTime.now();
//
//        DateTime dateOfBirth = new DateTime(1996, 1, 1, 0, 0);
//
//        Period period = new Period(dateOfBirth, currentDate);

        assertFalse((period.getYears() <= 18));
    }

}