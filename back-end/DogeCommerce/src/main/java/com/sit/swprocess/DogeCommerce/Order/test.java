package com.sit.swprocess.DogeCommerce.Order;

import java.text.DecimalFormat;

public class test {
    public static void main(String[] args) {
        double x = 12312123.1234 * 100;
        DecimalFormat decimalFormat = new DecimalFormat("##");
        String wow = decimalFormat.format(x);
        System.out.println(wow);
    }
}
