package com.isetrades.grow_smart;

public class Utilisateur
{
    private String prenom;

    private String email;

    private String imgUser;

    private String sexe;

    private String motdepasse;

    private String login;

    private String nom;

    public Utilisateur(String prenom, String email, String imgUser, String sexe, String motdepasse, String login, String nom) {
        this.prenom = prenom;
        this.email = email;
        this.imgUser = imgUser;
        this.sexe = sexe;
        this.motdepasse = motdepasse;
        this.login = login;
        this.nom = nom;
    }

    public String getPrenom ()
    {
        return prenom;
    }

    public void setPrenom (String prenom)
    {
        this.prenom = prenom;
    }

    public String getEmail ()
    {
        return email;
    }

    public void setEmail (String email)
    {
        this.email = email;
    }

    public String getImgUser ()
    {
        return imgUser;
    }

    public void setImgUser (String imgUser)
    {
        this.imgUser = imgUser;
    }

    public String getSexe ()
    {
        return sexe;
    }

    public void setSexe (String sexe)
    {
        this.sexe = sexe;
    }

    public String getMotdepasse ()
    {
        return motdepasse;
    }

    public void setMotdepasse (String motdepasse)
    {
        this.motdepasse = motdepasse;
    }

    public String getLogin ()
    {
        return login;
    }

    public void setLogin (String login)
    {
        this.login = login;
    }

    public String getNom ()
    {
        return nom;
    }

    public void setNom (String nom)
    {
        this.nom = nom;
    }


}
