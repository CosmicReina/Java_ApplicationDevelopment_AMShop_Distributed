package data;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class UtilityLocalDate {
    public static java.sql.Date fromLocalDate(LocalDate localDate){
        if(localDate == null) return null;
        java.util.Date utilDate = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        return sqlDate;
    }
    public static LocalDate toLocalDate(java.sql.Date sqlDate){
        if(sqlDate == null) return null;
        java.util.Date utilDate = new java.util.Date(sqlDate.getTime());
        LocalDate localDate = utilDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        return localDate;
    }
}