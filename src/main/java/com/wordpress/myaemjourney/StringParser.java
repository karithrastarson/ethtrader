package com.wordpress.myaemjourney;

/*
String Parser solution to extract number values from the json response from kraken api

Silly solution, but using JSON objects was restricting and causing problems.
*/
public class StringParser {

    private final String inputString;
    public StringParser(String inputString) {
        this.inputString = inputString;
    }

    Double getETHLastTradeClosed() {

        String[] val = inputString.split("\"XETHZEUR\"");
        val = val[1].split("\"c\"");
        val = val[1].split("\"");
        val = val[1].split("\"");
        return  Double.parseDouble(val[0]);
    }

    Double getXBTLastTradeClosed() {

        String[] val = inputString.split("\"XXBTZEUR\"");
        val = val[1].split("\"c\"");
        val = val[1].split("\"");
        val = val[1].split("\"");
        return  Double.parseDouble(val[0]);
    }

    Double getBCHLastTradeClosed() {
        String[] val = inputString.split("\"BCHEUR\"");
        val = val[1].split("\"c\"");
        val = val[1].split("\"");
        val = val[1].split("\"");
        return  Double.parseDouble(val[0]);
    }
}
