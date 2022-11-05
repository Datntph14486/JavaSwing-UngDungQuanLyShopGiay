/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Vuong_Ahihiiii
 */
public class XDate {//  xu ly du lieu thoi gian
    
    static SimpleDateFormat formater = new SimpleDateFormat();
    
    // 1. chuyen chuoi thanh ngay
    public static Date toDate(String date1, String pattern){            // chuyen chuoi thanh ngay : String s = "01-09-1971"
        try {                                                          //                           Date date = Xdate.toDate(s,"dd-MM-yyyy");
            formater.applyPattern(pattern);
            return formater.parse(date1);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
        
    // 2. Chuyen thoi gian hien tai thanh chuoi
    public static String toString (Date date1 , String pattern){              // Date now = new Date();
        formater.applyPattern(pattern);                                      // String s = XDate.toString(now,"dd-MM-yyyy");
        return formater.format(date1);
    }
    
    
    // 3. Bo sung 10 ngay vao ngay hien tai                               //  Date now =new Date();
     public static Date addDays(Date date1, long days){                  //  Date after = Xdate.addDays(now, 10);
         date1.setTime(date1.getTime() + days*24*60*60*1000);
         return date1;
     }

    
}
