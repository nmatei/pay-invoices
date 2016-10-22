package org.fasttrackit.util;

import com.sdl.selenium.web.utils.PropertiesReader;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class BankCardDetails extends PropertiesReader{

    public static String LAST_AMOUNT = "";

    public BankCardDetails() {
        super("src\\test\\resources\\bank-card.properties");
    }

    public String getNumber() {
        return getProperty("card.number");
    }

    public String getCvv() {
        return getProperty("card.cvv");
    }

    public String getOwner() {
        return getProperty("card.owner");
    }

    /**
     * // TODO make sure is in the correct format for all CardView's
     * @return
     */
    public String getMonth() {
        return getProperty("card.expire.month");
    }

    public String getMonthName(Locale locale) {
        String nameCapitalized = null;
        SimpleDateFormat inDateFormat = new SimpleDateFormat("MM/dd/yyyy", locale);
        SimpleDateFormat outDateForm = new SimpleDateFormat("MMMM", locale);
        try {
            Date fromDate = inDateFormat.parse(getMonth() + "/01/2016");
            String month = outDateForm.format(fromDate);
            String firstLetter = month.substring(0, 1).toUpperCase();
            nameCapitalized = firstLetter + month.substring(1);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return nameCapitalized;
    }

    public String getYear() {
        return getProperty("card.expire.year");
    }

    /**
     * @return card.3DSecure.password
     */
    public String getPassword() {
        return getProperty("card.3DSecure.password");
    }
}
