package com.isetrades.grow_smart;

public class Maladie
{
    private int codeplante;

    private String description;

    private int code;

    private String nom;

    public Maladie(int codeplante, String description, int code, String nom) {
        this.codeplante = codeplante;
        this.description = description;
        this.code = code;
        this.nom = nom;
    }

    public int getCodeplante ()
    {
        return codeplante;
    }

    public void setCodeplante (int codeplante)
    {
        this.codeplante = codeplante;
    }

    public String getDescription ()
    {
        return description;
    }

    public void setDescription (String description)
    {
        this.description = description;
    }

    public int getCode ()
    {
        return code;
    }

    public void setCode (int code)
    {
        this.code = code;
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
