package com.isetrades.grow_smart;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AddProblem extends AppCompatActivity
{
    JSONArray jsonArray = null;
    JSONObject jsonObject = null;
    private EditText txtTitreProb;
    private EditText txtDescriptionProb;
    private Button btnAddProblem;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_problem);
        txtTitreProb = (EditText) findViewById(R.id.txtTitreProb);
        txtDescriptionProb = (EditText) findViewById(R.id.txtDescriptionProb);
        btnAddProblem = (Button) findViewById(R.id.btnAddProblem);
        btnAddProblem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                String titre = txtTitreProb.getText().toString();
                String description = txtDescriptionProb.getText().toString();
                Date date = new Date();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                sdf.format(new Date());


                String user = "SmileMore";
                //Toast.makeText(getApplicationContext(), sdf.format(new Date()), Toast.LENGTH_SHORT).show();
                new AddProbleme().execute(titre, description, sdf.format(new Date()), user);
                //new AddProbleme.execute(txtTitreProb.getText().toString(), txtDescriptionProb.getText().toString());
            }
        });
    }


   private class AddProbleme extends AsyncTask<String, Integer, String>
   {
       @Override
       protected void onPreExecute()
       {
           super.onPreExecute();
       }

       @Override
       protected String doInBackground(String... strings)
       {
           //make connection with db(web service
           try
           {


               URL url = new URL("http://192.168.137.1:80/growsmart/AddProblem.php?titre="+strings[0]+"&description="+strings[1]+"&date=" +
                       strings[2]+"&user="+strings[3]);
               URLConnection urlConnection = url.openConnection();
               InputStreamReader inputStreamReader = new InputStreamReader(urlConnection.getInputStream());
               BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

               String line ;
               while ((line = bufferedReader.readLine()) != null)
               {
                   jsonObject = new JSONObject(line);

               }
               Log.d("fff", String.valueOf(jsonObject.getBoolean("result")));


               //Log.d("hhhh", jsonObject.toString());

           } catch (MalformedURLException e) {
               e.printStackTrace();
           } catch (IOException e) {
               e.printStackTrace();
           } catch (JSONException e) {
               e.printStackTrace();
           }
           return null;
       }

       @Override
       protected void onPostExecute(String s)
       {
           super.onPostExecute(s);

           try {
               boolean isInserted = jsonObject.getBoolean("result");


               if (isInserted)
               {
                   Toast.makeText(getApplicationContext(), "Published", Toast.LENGTH_SHORT).show();
                   Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                   startActivity(intent);
                   //Toast.makeText(getApplicationContext(), st , Toast.LENGTH_LONG).show();

               }
           } catch (JSONException e)
           {
               e.printStackTrace();
           }
       }
   }

}


