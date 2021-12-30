package com.isetrades.grow_smart;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

public class ArticleActivity extends AppCompatActivity
{
    private SwipeRefreshLayout maSwipe;
    private Retrofit RF;
    private RegisterAPI api;
    //private ListView lstArticle;
    ArrayList<Article> listArticle = new ArrayList<Article>();

    ArrayList<Utilisateur> listUser = new ArrayList<Utilisateur>();
    ArrayList<Probleme> listeProb = new ArrayList<Probleme>();
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article);


        try
        {
            RF = new Retrofit.Builder().baseUrl("http://192.168.137.1:80/").addConverterFactory(GsonConverterFactory.create()).build();
            api = RF.create(RegisterAPI.class);
            retrofit.Call<List<Article>> LISTP = api.getArticles();
            LISTP.enqueue(new Callback<List<Article>>() {
                @Override
                public void onResponse(Response<List<Article>> response, Retrofit retrofit)
                {
                    if (response.isSuccess()) {
                        listArticle = (ArrayList<Article>) response.body();
                        Log.d("SucessWebService", "Article : ");
                    }

                   /* for (int i = 0; i < listArticle.size(); i++)
                    {

                        listeSArticle.add(listArticle.get(i).getTitreArticle()+"\n"+listArticle.get(i).getDescriptionArticle());
                        //Log.d("Value of ", "List[" + i + "]" + listuu.get(i).toString());
                        //Toast.makeText(CalculQtePlante.this, "List[" + i + "]==>" + listuu.get(i).toString(), Toast.LENGTH_SHORT).show();
                    }*/

                    /*lstArticle = (ListView) findViewById(R.id.lstArticle);

                    adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.select_dialog_item, listeSArticle);
                    lstArticle.setAdapter(adapter);*/

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
            retrofit.Call<List<Utilisateur>> LISTP = api.getAllUtilisateur();
            LISTP.enqueue(new Callback<List<Utilisateur>>()
            {
                @Override
                public void onResponse(Response<List<Utilisateur>> response, Retrofit retrofit)
                {
                    if (response.isSuccess()) {
                        listUser = (ArrayList<Utilisateur>) response.body();
                        Log.d("SucessWebServiceUser", "user : "+listUser.get(0).getPrenom()+" Article : "+listArticle.size());
                    }
                    //Toast.makeText(getApplicationContext(),"user : "+listUser.size()+" | article : "+listArticle.size(),Toast.LENGTH_LONG).show();

                    for (int i = 0; i<listArticle.size(); i++)
                    {
                        Article article = listArticle.get(i);
                        for(int j = 0; j<listUser.size(); j++)
                        {
                            Utilisateur u = listUser.get(j);
                            if(article.getLoginuser().equals(listUser.get(j).getLogin()))
                            {
                                //Toast.makeText(getApplicationContext(),"IN",Toast.LENGTH_SHORT).show();
                                Probleme p = new Probleme(R.drawable.user, u.getNom()+" "+u.getPrenom(),article.getDateArticle(), article.getTitreArticle(), article.getDescriptionArticle(), 4);
                                listeProb.add(p);
                            }
                        }

                    }


                    ArticleAdapter ad = new ArticleAdapter(getApplicationContext(), R.layout.activity_list_view_item, listeProb);
                    ListView lstArticle = (ListView) findViewById(R.id.lstArticle);
                    lstArticle.setAdapter(ad);



                    /*for (int i = 0; i < listUser.size(); i++)
                    {

                        listeSArticle.add(listArticle.get(i).getTitreArticle()+"\n"+listArticle.get(i).getDescriptionArticle());
                        //Log.d("Value of ", "List[" + i + "]" + listuu.get(i).toString());
                        //Toast.makeText(CalculQtePlante.this, "List[" + i + "]==>" + listuu.get(i).toString(), Toast.LENGTH_SHORT).show();
                    }*/

                    //lstArticle = (ListView) findViewById(R.id.lstArticle);

                    //adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.select_dialog_item, listeSArticle);
                    //lstArticle.setAdapter(adapter);

                }

                @Override
                public void onFailure(Throwable t) {
                    System.out.print("Erreur web service" + t.getLocalizedMessage());
                    Log.d("Erreur deu web service", t.getMessage());
                    Toast.makeText(getApplicationContext(), "Erreur \t" + t.getLocalizedMessage(), Toast.LENGTH_LONG).show();
                }
            });
        }catch (Exception ex)
        {
            ex.getStackTrace();
        }

        /*ArticleAdapter ad = new ArticleAdapter(getApplicationContext(), R.layout.activity_list_view_item, listeProb);
        lstArticle = (ListView) findViewById(R.id.lstArticle);
        lstArticle.setAdapter(ad);*/
        /*Probleme p = new Probleme(R.drawable.user, "Hamza Jabri", "25/52/1996", "Mon Probleme", "Descripto=ion probleme", 8);
        Probleme p1 = new Probleme(R.drawable.user, "Hamza Jabri", "25/52/1996", "Mon Probleme", "Descripto=ion probleme", 8);
        Probleme p2 = new Probleme(R.drawable.user, "Hamza Jabri", "25/52/1996", "Mon Probleme", "Descripto=ion probleme", 8);

        ArrayList<Probleme> listP = new ArrayList<Probleme>();
        listP.add(p);
        listP.add(p1);
        listP.add(p2);

        */

        //maSwipe.setOnRefreshListener((SwipeRefreshLayout.OnRefreshListener) getApplicationContext());

    }
}
