package com.isetrades.grow_smart;

import java.util.List;
import retrofit.Call;
import retrofit.http.GET;


public interface RegisterAPI
{




    @GET("growsmart/getAllPlante.php")
    Call<List<Plante>> getPlante();

    @GET("growsmart/getPlante.php?name=Tomate")
    Call<List<Plante>> getPTomate();

    @GET("growsmart/getPlante.php?name=Graine")
    Call<List<Plante>> getGraine();

    @GET("growsmart/getPlante.php?name=Pomme de terre")
    Call<List<Plante>> getPommeTerre();

    @GET("growsmart/getAllArticle.php")
    Call<List<Article>> getArticles();

    @GET("growsmart/getAll.php")
    Call<List<Utilisateur>> getAllUtilisateur();

    @GET("growsmart/getMaladies.php")
    Call<List<Maladie>> getMaladies();

}
