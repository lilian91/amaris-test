package com.amaris.java_test.sharedkernel;

import com.amaris.java_test.sharedkernel.exception.DateFormtaInputException;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public abstract class Utils {
    private static final DateFormat DF = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static String isValidDate(String dateStr) throws Exception {
        DF.setLenient(false);

        try {
            return DF.format(DF.parse(dateStr));
        } catch (ParseException e) {
            throw new DateFormtaInputException("Imposible leer fecha de aplicación. Formato de entrada esperado: yyyy-MM-dd HH:mm:ss");
        }
    }
}
