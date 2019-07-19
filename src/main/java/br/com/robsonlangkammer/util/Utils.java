package br.com.robsonlangkammer.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by robson on 15/07/19.
 */
public class Utils {


    private static SimpleDateFormat dataFormatBr = new SimpleDateFormat("dd/MM/yyyy");


    public static String converteDateToBr(Date date){
        String dataParse = "";
        if(date!=null)
            dataParse =  dataFormatBr.format(date);
        return dataParse;
    }

}
