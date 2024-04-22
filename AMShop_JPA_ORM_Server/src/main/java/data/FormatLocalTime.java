package data;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class FormatLocalTime {
    private static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
    
    public static String fromLocalTime(LocalTime localTime){
        if(localTime!= null){
            String time = localTime.format(dtf);
            return time;
        }
        return "";
    }
}
