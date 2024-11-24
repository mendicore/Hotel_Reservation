package com.mycompany.Currency;

import java.text.NumberFormat;
import java.util.Locale;

public class IDR {
    public static String Rupiah(double price){
        NumberFormat curr = NumberFormat.getCurrencyInstance(new Locale("id","ID"));
        return curr.format(price);
    }
}
