package com.isetrades.grow_smart;

public class Engrais
{
    private int codeEngrais;

    private String dateEngrais;

    private String descriptionEngrais;

    private String libelleEngrais;

    private String nomPlante;


    public Engrais(int codeEngrais, String dateEngrais, String descriptionEngrais, String libelleEngrais, String nomPlante)
    {
        this.codeEngrais = codeEngrais;
        this.dateEngrais = dateEngrais;
        this.descriptionEngrais = descriptionEngrais;
        this.libelleEngrais = libelleEngrais;
        this.nomPlante = nomPlante;
    }

    public int getCodeEngrais ()
    {
        return codeEngrais;
    }

    public void setCodeEngrais (int codeEngrais)
    {
        this.codeEngrais = codeEngrais;
    }

    public String getDateEngrais ()
    {
        return dateEngrais;
    }

    public void setDateEngrais (String dateEngrais)
    {
        this.dateEngrais = dateEngrais;
    }

    public String getDescriptionEngrais ()
    {
        return descriptionEngrais;
    }

    public void setDescriptionEngrais (String descriptionEngrais)
    {
        this.descriptionEngrais = descriptionEngrais;
    }

    public String getLibelleEngrais ()
    {
        return libelleEngrais;
    }

    public void setLibelleEngrais (String libelleEngrais)
    {
        this.libelleEngrais = libelleEngrais;
    }

    public String getNomPlante ()
    {
        return nomPlante;
    }

    public void setNomPlante (String nomPlante)
    {
        this.nomPlante = nomPlante;
    }


}