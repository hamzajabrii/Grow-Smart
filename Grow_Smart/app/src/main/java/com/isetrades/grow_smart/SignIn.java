package com.isetrades.grow_smart;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

public class SignIn extends AppCompatActivity
{
    private AdView mAdView;
    private Utilisateur user;
    private SwipeRefreshLayout maSwipe;
    private Retrofit RF;
    private RegisterAPI api;
    //private ListView lstArticle;
    ArrayList<Article> listArticle = new ArrayList<Article>();

    ArrayList<Utilisateur> listUser = new ArrayList<Utilisateur>();
    ArrayList<Probleme> listeProb = new ArrayList<Probleme>();
    ArrayAdapter<String> adapter;

    private EditText txtLoginSignIn;
    private EditText txtPasswordSignIn;
    private Button btnIdenifier;
    private Button btnNvCompte;
    private String UserName;
    private String UserPassword;
    Utilisateur utilisateur = null;
    SharedPreferences sharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        // Sample AdMob app ID: ca-app-pub-3940256099942544~3347511713
        MobileAds.initialize(this, "ca-app-pub-3940256099942544~3347511713");
        AdView adView = new AdView(this);
        adView.setAdSize(AdSize.BANNER);
        adView.setAdUnitId("ca-app-pub-3940256099942544/6300978111");
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        txtLoginSignIn = (EditText) findViewById(R.id.txtLoginSignIn);
        txtPasswordSignIn = (EditText) findViewById(R.id.txtPasswordSignIn);
        btnIdenifier = (Button) findViewById(R.id.btnIdenifier);
        btnNvCompte = (Button) findViewById(R.id.btnNvCompte);

        sharedPreferences = getBaseContext().getSharedPreferences("userConnected", MODE_PRIVATE);

        if (sharedPreferences.contains("UserName") )
        {

            //user connecté
            //Toast.makeText(getApplicationContext(), "UserName : " + sharedPreferences.getString("UserName",null), Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(getApplicationContext(),MainActivity.class);
            startActivity(intent);
        }




        btnNvCompte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(SignIn.this, SignUp.class);
                startActivity(intent);
            }
        });

        btnIdenifier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) 
            {


                    //user non connecté
                    UserName = txtLoginSignIn.getText().toString();
                    UserPassword = txtPasswordSignIn.getText().toString();

                    user = getUser(UserName,UserPassword);

                    //Toast.makeText(getApplicationContext(), user.getLogin(), Toast.LENGTH_SHORT).show();

                    if(user == null)
                    {
                        //Toast.makeText(getApplicationContext(), "User Name or Password incorrect ", Toast.LENGTH_SHORT).show();
                        Snackbar.make(v, "Invalid UserName or Password", Snackbar.LENGTH_LONG)
                                .setAction("Action", null).show();
                    }
                    else
                    {
                        sharedPreferences
                                .edit()
                                .putString("UserName", user.getLogin())
                                .apply();
                        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                        startActivity(intent);

                    }

                    //Toast.makeText(getApplicationContext(), "User Non connecté ", Toast.LENGTH_SHORT).show();

                
            }
        });

    }
    
    public Utilisateur getUser(final String m, final String p)
    {


        try
        {
            RF = new Retrofit.Builder().baseUrl("http://192.168.137.1:80/").addConverterFactory(GsonConverterFactory.create()).build();
            api = RF.create(RegisterAPI.class);
            retrofit.Call<List<Utilisateur>> LISTP = api.getAllUtilisateur();
            LISTP.enqueue(new Callback<List<Utilisateur>>()
            {
                @Override
                public void onResponse(Response<List<Utilisateur>> response, Retrofit retrofit)
                {
                    if (response.isSuccess()) 
                    {
                        listUser = (ArrayList<Utilisateur>) response.body();
                        Log.d("SucessWebServiceUser", "user : "+listUser.get(0).getPrenom()+" Article : "+listArticle.size());
                    }
                    //Toast.makeText(getApplicationContext(),"user : "+listUser.size()+" | article : "+listArticle.size(),Toast.LENGTH_LONG).show();

                    for (int i = 0; i<listUser.size(); i++)
                    {
                        String log = listUser.get(i).getLogin();
                        String pass = listUser.get(i).getMotdepasse();
                        if (m.equals(log) && p.equals(pass))
                        {
                            utilisateur = listUser.get(i);
                           /* new Utilisateur(listUser.get(i).getPrenom(), listUser.get(i).getEmail(), listUser.get(i).getImgUser(),
                                    listUser.get(i).getSexe(), m,p,listUser.get(i).getNom())*/
                        }
                    }                  
                    
                }

                @Override
                public void onFailure(Throwable t)
                {
                    System.out.print("Erreur web service" + t.getLocalizedMessage());
                    Log.d("Erreur deu web service", t.getMessage());
                    Toast.makeText(getApplicationContext(), "Erreur \t" + t.getLocalizedMessage(), Toast.LENGTH_LONG).show();
                }
            });
        }catch (Exception ex)
        {
            ex.getStackTrace();
        }
        return utilisateur;
    }
}
