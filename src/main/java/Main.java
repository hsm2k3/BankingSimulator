import org.joda.time.*;


import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Bank bank = new Bank();
        LocalDate todaysDate = new LocalDate();
        DateTime firstDate = new DateTime(1996, 4, 9, 0, 0);
        DateTime secondDate = new DateTime();
        secondDate.getChronology();

        LocalDateTime currentTime = new LocalDateTime();



        Period period = new Period(firstDate, secondDate);
        System.out.println(currentTime);
        System.out.println(secondDate.getDayOfMonth());
        System.out.println(period.getYears());

        bank.connectToDatabase();



    }
}
