package data;

import java.text.NumberFormat;
import java.util.Locale;

public class FormatDouble {
    
    public static NumberFormat nbf = NumberFormat.getCurrencyInstance(new Locale("vi", "vn"));
    
    public static String toMoney(double number){
        String money = nbf.format(number);
        return money;
    }
    
    public static double fromMoney(String money){
        String numericString = money.replaceAll("[^\\d]", "");
        System.out.println(numericString);
        double number = Double.parseDouble(numericString);
        return number;
    }
}
