import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

public class DateTime {

    public static void main(String[] args) {
        
        //Dates
        Calendar c = Calendar.getInstance( );
        c.set(2022, Calendar.JANUARY,1);

        LocalDate d = LocalDate.of(2022,Month.JANUARY, 1);

        // Times
        LocalTime time = LocalTime.of(10,0);

        //DataTime
        // LocalDateTime dt = LocalDateTime.of(date, time);
        LocalDateTime dt2 = LocalDateTime.of(2022, 1, 1, 10, 00);

        LocalDateTime lastWeek = dt2.minusDays(7);
        String dataFormatted = dt2.format(DateTimeFormatter.ISO_LOCAL_DATE);
        System.out.println(dataFormatted);
    } 
    
}
