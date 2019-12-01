package com.example.lab2tehtava2;

import android.util.Log;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class lista {


    public ArrayList<String> betterParse(String dataString){
        List<String> list = new ArrayList<String> ();

        try{
            JSONObject stock = null;
            JSONObject jsonObject = new JSONObject (dataString);
            JSONObject stockElement = jsonObject.getJSONObject ("AAPL");
            double stockPrice = stockElement.getDouble ("price");

            Iterator it = jsonObject.keys();
            while (it.hasNext ()){
                String key = (String) it.next();
                stock = jsonObject.getJSONObject (key);
                Log.d("luento", "Avain löytyi: " + key + " " + stock.getDouble ("price"));
                list.add(key + " " + stock.getDouble ("price") );
            }





            return (ArrayList<String>) list;


        }
        catch (Exception e){

        }
        return null;
    }


}
