package Customer;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

//we should make the unique ID for the customer in this class as well.

public class Customer {
    public static String setCustomerName(Scanner scanner){
        String customerName;
        System.out.println("Please provide your name: " );
        customerName = scanner.nextLine();
        System.out.println();
        return customerName;
    }
    public static String setCustomerDOB(Scanner scanner, DateFormat dateFormat) throws ParseException {
        String DOB;
        System.out.println("Please provide your DOB (MM/DD/YYYY): ");
        DOB = scanner.nextLine();
        System.out.println();
        try {
            dateFormat.parse(DOB);
        } catch (ParseException e) {
            e.printStackTrace();
            setCustomerDOB(scanner,dateFormat);
        }
        System.out.println();
        return DOB;
    }
}
