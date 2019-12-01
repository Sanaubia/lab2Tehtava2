package com.example.lab2tehtava2;

import android.os.AsyncTask;
import android.util.JsonReader;
import android.util.Log;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;

interface ClientInterface{

}

public class StockAsync extends AsyncTask<String, Integer, Object> {




    public String result;


    private void executeTask(){

        try{
            URL url;
            url = new URL ("https://financialmodelingprep.com/api/company/price/AAPL,GOOG,IBM,NOK?datatype=json");
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection ( );
            result = fromStream (urlConnection.getInputStream ());

          //  Log.d ("testi", "Elegant price:" + betterParse (result));

        } catch (Exception e){

        }

    }

    public static String fromStream(InputStream in) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader (in));
        StringBuilder out = new StringBuilder();
        String newLine = System.getProperty("line.separator");
        String line;
        while ((line = reader.readLine()) != null) {
            out.append(line);
            out.append(newLine);
        }
        return out.toString();
    }

    @Override
    protected String doInBackground(String... strings) {
        executeTask();
        return "valmis";

    }


}
