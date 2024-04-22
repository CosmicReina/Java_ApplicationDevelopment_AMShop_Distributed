package data;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class FormatLocalDate {
    public static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    
    public static String fromLocalDate(LocalDate localDate){
        String date = dtf.format(localDate);
        return date;
    }
    
    public static LocalDate toLocalDate(String date){
        LocalDate localDate = LocalDate.parse(date, dtf);
        return localDate;
    }
}
