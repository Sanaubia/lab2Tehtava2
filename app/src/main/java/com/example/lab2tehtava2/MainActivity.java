package com.example.lab2tehtava2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);

        TextView textView_1 = findViewById (R.id.editText1);
        TextView textView_2 = findViewById (R.id.editText2);
        TextView textView_3 = findViewById (R.id.editText3);
        TextView textView_4 = findViewById (R.id.editText4);

        final StockAsync task = new StockAsync ( );
        lista l = new lista();





        try {
            String result = (String) task.execute ().get ();
        } catch (ExecutionException e) {
            e.printStackTrace ( );
        } catch (InterruptedException e) {
            e.printStackTrace ( );
        }

        //l.betterParse (task.result);
        //Log.d("vastaus ", list.toString ());
//        Log.d("VASTAUS", l.betterParse (task.result).toString ());
        //String vastaus = l.betterParse (task.result).get (0);
        // Log.d ("VASTAUS", vastaus);
        //  ArrayList<String> list = l.betterParse (task.result);
        textView_1.setText (l.betterParse (task.result).get (0));
        textView_2.setText (l.betterParse (task.result).get (1));
        textView_3.setText (l.betterParse (task.result).get (2));
        textView_4.setText (l.betterParse (task.result).get (3));







    }





}



