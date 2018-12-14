package customer;

import org.joda.time.DateTime;
import org.joda.time.Period;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {

    @DisplayName("This test makes sure that the isMinor function works")
    @Test
    void failingGetIsMinor() {
        //Setting time and checking the difference in years

        DateTime currentDate = new DateTime();
        currentDate = DateTime.now();

        DateTime dateOfBirth = new DateTime(1996, 1, 1, 0, 0);

        Period period = new Period(dateOfBirth, currentDate);

        assertTrue((period.getYears() <= 18));
    }

}