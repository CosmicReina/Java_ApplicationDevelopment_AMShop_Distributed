package data;

import java.time.LocalTime;
import java.sql.Time;

public class UtilityLocalTime {
    public static java.sql.Time fromLocalTime(LocalTime localTime){
        if(localTime == null) return null;
        Time time = Time.valueOf(localTime);
        return time;
    }
    
    public static LocalTime toLocalTime(Time time){
        if(time == null) return null;
        LocalTime localTime = time.toLocalTime();
        return localTime;
    }
}
