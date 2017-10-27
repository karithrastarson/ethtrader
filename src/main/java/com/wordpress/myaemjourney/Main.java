package com.wordpress.myaemjourney;

import api.kraken.KrakenApi;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;


public class Main {

    private static final String OUTPUT_FILE = "prices.txt";

    public static void main(String[] args){

        BufferedWriter writer = null;
        try {
            File logFile = new File(OUTPUT_FILE);
            KrakenApi api = new KrakenApi();

            api.setKey("***YOUR*API*KEY***"); // FIXME
            api.setSecret("***YOUR*API*SECRET***"); // FIXME

            String response = "";
            Map<String, String> input = new HashMap<>();
            input.put("pair", "ETHEUR,XBTEUR,BCHEUR");
            for (int i = 0; i < 10000 ; i++) {
                writer = new BufferedWriter(new FileWriter(logFile,true));
                //create a temporary file
                String timeStamp = new SimpleDateFormat("ddMMyyyy_HHmmss").format(Calendar.getInstance().getTime());
                response = api.queryPublic(KrakenApi.Method.TICKER, input);
                StringParser sp = new StringParser(response);
                System.out.print(timeStamp + "\t" + sp.getXBTLastTradeClosed() + "\t" + sp.getETHLastTradeClosed() + "\t" + sp.getBCHLastTradeClosed() + "\n");
                writer.write(timeStamp + "\t" + sp.getXBTLastTradeClosed() + "\t" + sp.getETHLastTradeClosed() + "\t" + sp.getBCHLastTradeClosed() + "\n");
                writer.close();
                TimeUnit.MINUTES.sleep(1);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}