package com.isetrades.grow_smart;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
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

public class SignUp extends AppCompatActivity
{
    JSONArray jsonArray = null;
    JSONObject jsonObject = null;
    private EditText txtEmail;
    private EditText txtLogin;
    private EditText txtNom;
    private EditText txtPrenom;
    private RadioButton rHomme;
    private RadioButton rFemme;
    private EditText txtPassword1;
    private EditText txtPassword2;
    private Button btnSinscrire;
    private String login;
    private String nom;
    private String prenom;
    private String email;
    private String sexe;
    private String password1;
    private String password2;
    private String password;
    private String imgIndex;
    String st;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        txtEmail = (EditText) findViewById(R.id.txtEmail);
        txtLogin = (EditText) findViewById(R.id.txtLogin);
        txtNom = (EditText) findViewById(R.id.txtNom);
        txtPrenom = (EditText) findViewById(R.id.txtPrenom);
        rHomme = (RadioButton) findViewById(R.id.rHomme);
        rFemme = (RadioButton) findViewById(R.id.rFemme);
        txtPassword1 = (EditText) findViewById(R.id.txtPassword1);
        txtPassword2 = (EditText) findViewById(R.id.txtPassword2);
        btnSinscrire = (Button) findViewById(R.id.btnSinscrire);



        btnSinscrire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {

                email = txtEmail.getText().toString();
                login = txtLogin.getText().toString();
                nom = txtNom.getText().toString();
                prenom = txtPrenom.getText().toString();
                password1 = txtPassword1.getText().toString();
                password2 = txtPassword2.getText().toString();

                //Toast.makeText(getApplicationContext(), email+login+nom+prenom+password1+password2, Toast.LENGTH_LONG).show();

                if (rHomme.isChecked())
                {
                    sexe="Homme";
                }
                else
                if(rFemme.isChecked())
                {
                    sexe="Femme";
                }

                if (email.length() == 0 || login.length() == 0 || nom.length() == 0 || prenom.length() == 0 || password1.length() == 0 || password2.length() == 0)
                {
                    Snackbar.make(v, "Il faut remplir tout le formulaire!!", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                    //Toast.makeText(getApplicationContext(), "Il faut remplir tout le formulaire!!", Toast.LENGTH_SHORT).show();
                }
                else
                    if(password1.equals(password2)==false)
                    {
                        Snackbar.make(v, "Mot de passes n'est pas identique", Snackbar.LENGTH_LONG)
                                .setAction("Action", null).show();
                        //Toast.makeText(getApplicationContext(), "Mot de passe n'est pas identique", Toast.LENGTH_SHORT).show();
                    }

                    else
                    {
                        new InsertClient().execute(login, nom, prenom, sexe, email, password2, "1");
                    }
                /*else
                    if (password1.equals(password2) == false)
                    {
                        Toast.makeText(getApplicationContext(), "Mot de passe n'est pas identique", Toast.LENGTH_SHORT).show();
                    }
                    else
                        if (password1.equals(password2) == true)
                        {
                            password = password2;
                        }
                        else
                            if(rHomme.isChecked() == false && rFemme.isChecked() == false)
                            {
                                Toast.makeText(getApplicationContext(), "Présiser Votre sexe", Toast.LENGTH_SHORT).show();
                            }
                            else
                                if (rHomme.isChecked())
                                {
                                    sexe = "Homme";
                                }
                                else
                                    if (rFemme.isChecked())
                                    {
                                        sexe = "Femme";
                                    }

                                    else
                                    {
                                        imgIndex = "74";
                                        //new InsertClient().execute(login, nom, prenom, sexe, email, password, imgIndex);
                                        Toast.makeText(getApplicationContext(), " ok", Toast.LENGTH_SHORT).show();

                                    }
*/





            }
        });
    }

    private class InsertClient extends AsyncTask<String, Integer, String>
    {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(String... strings)
        {
            //make connection with db(web service
            try
            {

                st = strings[0]+strings[1]+strings[2]+strings[3]+strings[4]+strings[5]+strings[6];
                URL url = new URL("http://192.168.137.1:80/growsmart/InsertClient.php?login="+strings[0]+"&nom="+strings[1]+"&prenom=" +
                        strings[2]+"&sexe="+strings[3]+"&email="+strings[4]+"&motdepasse="+strings[5]+"&imgUser="+strings[6]);
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
                    Toast.makeText(getApplicationContext(), "Inserted", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), SignIn.class);
                    startActivity(intent);
                    //Toast.makeText(getApplicationContext(), st , Toast.LENGTH_LONG).show();

                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
