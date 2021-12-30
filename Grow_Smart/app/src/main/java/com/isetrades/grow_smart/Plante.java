
package com.isetrades.grow_smart;

public class Plante
{
    private String libelle;

    private String dateplantage;

    private String description;

    private int quantite;

    private int tempjour;

    private int code;

    private String daterecolte;

    private String famille;

    private int tempnuit;

    public Plante(String libelle, String dateplantage, String description, int quantite, int tempjour, int code, String daterecolte, String famille, int tempnuit)
    {
        this.libelle = libelle;
        this.dateplantage = dateplantage;
        this.description = description;
        this.quantite = quantite;
        this.tempjour = tempjour;
        this.code = code;
        this.daterecolte = daterecolte;
        this.famille = famille;
        this.tempnuit = tempnuit;
    }


    public String getLibelle ()
    {
        return libelle;
    }

    public void setLibelle (String libelle)
    {
        this.libelle = libelle;
    }

    public String getDateplantage ()
    {
        return dateplantage;
    }

    public void setDateplantage (String dateplantage)
    {
        this.dateplantage = dateplantage;
    }

    public String getDescription ()
    {
        return description;
    }

    public void setDescription (String description)
    {
        this.description = description;
    }

    public int getQuantite ()
    {
        return quantite;
    }

    public void setQuantite (int quantite)
    {
        this.quantite = quantite;
    }

    public int getTempjour ()
    {
        return tempjour;
    }

    public void setTempjour (int tempjour)
    {
        this.tempjour = tempjour;
    }

    public int getCode ()
    {
        return code;
    }

    public void setCode (int code)
    {
        this.code = code;
    }

    public String getDaterecolte ()
    {
        return daterecolte;
    }

    public void setDaterecolte (String daterecolte)
    {
        this.daterecolte = daterecolte;
    }

    public String getFamille ()
    {
        return famille;
    }

    public void setFamille (String famille)
    {
        this.famille = famille;
    }

    public int getTempnuit ()
    {
        return tempnuit;
    }

    public void setTempnuit (int tempnuit)
    {
        this.tempnuit = tempnuit;
    }


}
			
			