package data;

import java.sql.*;
import java.time.LocalDateTime;

public class UtilityLocalDateTime {
    public static Timestamp fromLocalDateTime(LocalDateTime localDateTime){
        if(localDateTime == null) return null;
        return Timestamp.valueOf(localDateTime);
    }
    
    public static LocalDateTime toLocalDateTime(Timestamp timestamp){
        if(timestamp == null) return null;
        return timestamp.toLocalDateTime();
    }
}