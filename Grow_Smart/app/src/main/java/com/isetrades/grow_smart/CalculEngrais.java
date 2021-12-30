package com.isetrades.grow_smart;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

public class CalculEngrais extends AppCompatActivity
{
    ArrayList<Plante> listuu = new ArrayList<Plante>();
    ArrayList<String> listePlante = new ArrayList<String>();
    ArrayList<Maladie> listMaladi = new ArrayList<Maladie>();
    ArrayList<String> lstStringMaladi = new ArrayList<String>();
    private Spinner PlanteSpinner;
    private Spinner spinnerMaladie;
    private Button btnCalcul;
    private EditText txtSurface;
    private int res=0;
    private int s=0;
    private Retrofit RF;
    private RegisterAPI api;
    TextView txtRes;
    private Button btnReset;

    ArrayAdapter<String> adapter;
    ArrayAdapter<String> adapter1;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calcul_engrais);

        btnCalcul = (Button) findViewById(R.id.btnCalcul);
        txtSurface = (EditText) findViewById(R.id.txtSurface);
        txtRes = (TextView) findViewById(R.id.txtRes);
        btnReset = (Button) findViewById(R.id.btnReset);

        try
        {
            RF = new Retrofit.Builder().baseUrl("http://192.168.137.1:80/").addConverterFactory(GsonConverterFactory.create()).build();
            api = RF.create(RegisterAPI.class);
            Call<List<Plante>> LISTP = api.getPlante();
            LISTP.enqueue(new Callback<List<Plante>>() {
                @Override
                public void onResponse(Response<List<Plante>> response, Retrofit retrofit)
                {
                    if (response.isSuccess()) {
                        listuu = (ArrayList<Plante>) response.body();
                        //Log.d("SucessWebService", "SucessWebService");
                    }
                    listePlante.add("Choisir plante");
                    for (int i = 0; i < listuu.size(); i++)
                    {

                        listePlante.add(listuu.get(i).getLibelle());
                        //Log.d("Value of ", "List[" + i + "]" + listuu.get(i).toString());
                        //Toast.makeText(CalculQtePlante.this, "List[" + i + "]==>" + listuu.get(i).toString(), Toast.LENGTH_SHORT).show();
                    }
                    PlanteSpinner = (Spinner) findViewById(R.id.spinnerPlante);
                    adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, listePlante);

                    PlanteSpinner.setAdapter(adapter);
                }

                @Override
                public void onFailure(Throwable t) {
                    System.out.print("Erreur web service" + t.getLocalizedMessage());
                    Log.d("Erreur deu web service", t.getMessage());
                    Toast.makeText(getApplicationContext(), "Erreur \t" + t.getLocalizedMessage(), Toast.LENGTH_LONG).show();
                }
            });
        }catch (NullPointerException ex)
        {
            System.out.print(ex.getLocalizedMessage());
        }



        try
        {
            RF = new Retrofit.Builder().baseUrl("http://192.168.137.1:80/").addConverterFactory(GsonConverterFactory.create()).build();
            api = RF.create(RegisterAPI.class);
            Call<List<Maladie>> LISTP = api.getMaladies();
            LISTP.enqueue(new Callback<List<Maladie>>() {
                @Override
                public void onResponse(Response<List<Maladie>> response, Retrofit retrofit)
                {
                    if (response.isSuccess()) {
                        listMaladi = (ArrayList<Maladie>) response.body();
                        //Log.d("SucessWebService", "SucessWebService");
                    }
                    lstStringMaladi.add("Choisir maladie");
                    for (int i = 0; i < listMaladi.size(); i++)
                    {

                        lstStringMaladi.add(listMaladi.get(i).getNom());
                        //Log.d("Value of ", "List[" + i + "]" + listuu.get(i).toString());
                        //Toast.makeText(CalculQtePlante.this, "List[" + i + "]==>" + listuu.get(i).toString(), Toast.LENGTH_SHORT).show();
                    }
                    spinnerMaladie = (Spinner) findViewById(R.id.spinnerMaladie);
                    adapter1 = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, lstStringMaladi);

                    spinnerMaladie.setAdapter(adapter1);
                }

                @Override
                public void onFailure(Throwable t) {
                    System.out.print("Erreur web service" + t.getLocalizedMessage());
                    Log.d("Erreur deu web service", t.getMessage());
                    Toast.makeText(getApplicationContext(), "Erreur \t" + t.getLocalizedMessage(), Toast.LENGTH_LONG).show();
                }
            });
        }catch (NullPointerException ex)
        {
            System.out.print(ex.getLocalizedMessage());
        }

        btnCalcul.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                if (txtSurface.getText().length()==0)
                    Toast.makeText(getApplicationContext(), "Entrer la surface de votre terre...", Toast.LENGTH_SHORT).show();
                else if(PlanteSpinner.getSelectedItem().equals("Choisir plante"))
                    Toast.makeText(getApplicationContext(), "Choisir Plante...", Toast.LENGTH_SHORT).show();

                else
                {
                    Call<List<Plante>> p = null;
                    if (PlanteSpinner.getSelectedItem().equals("Tomate"))
                        p = api.getPTomate();
                    else if (PlanteSpinner.getSelectedItem().equals("Graine"))
                        p = api.getGraine();
                    else if(PlanteSpinner.getSelectedItem().equals("Pomme de terre"))
                        p = api.getPommeTerre();

                    p.enqueue(new Callback<List<Plante>>() {
                        @Override
                        public void onResponse(Response<List<Plante>> response, Retrofit retrofit)
                        {
                            String unite = "";
                            ArrayList<Plante> ps = (ArrayList<Plante>) response.body();
                            Plante p = ps.get(0);
                            Log.d("SucessWebService", "SucessWebService");
                            s = Integer.parseInt(String.valueOf(txtSurface.getText()));
                            res = s * p.getQuantite();

                            //Toast.makeText(CalculQtePlante.this, "" + res, Toast.LENGTH_LONG).show();
                            //Toast.makeText(getApplicationContext(),""+p.getQuantite(),Toast.LENGTH_SHORT).show();
                            if(p.getFamille().equals("Plante"))
                                unite="Plantes";
                            else
                            if(p.getFamille().equals("Graine")) unite="Kg";
                            txtRes.setText(""+res+" "+unite+" par Hectar.");
                        }

                        @Override
                        public void onFailure(Throwable t)
                        {
                            Log.d("FailureWebService", "FailureWebService");
                            Toast.makeText(getApplicationContext(), "Erreur de connection", Toast.LENGTH_SHORT).show();

                        }
                    });


                }


            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                txtSurface.setText("");
                PlanteSpinner.setAdapter(adapter);
                spinnerMaladie.setAdapter(adapter1);
                txtRes.setText("");

            }
        });
    }
}

