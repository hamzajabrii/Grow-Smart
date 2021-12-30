package com.isetrades.grow_smart;

public class Article
{
    private String dateArticle;

    private String titreArticle;

    private String descriptionArticle;

    private String loginuser;

    private int codeArticle;

    public Article(String dateArticle, String titreArticle, String descriptionArticle, String loginuser, int codeArticle) {
        this.dateArticle = dateArticle;
        this.titreArticle = titreArticle;
        this.descriptionArticle = descriptionArticle;
        this.loginuser = loginuser;
        this.codeArticle = codeArticle;
    }

    public String getDateArticle ()
    {
        return dateArticle;
    }

    public void setDateArticle (String dateArticle)
    {
        this.dateArticle = dateArticle;
    }

    public String getTitreArticle ()
    {
        return titreArticle;
    }

    public void setTitreArticle (String titreArticle)
    {
        this.titreArticle = titreArticle;
    }

    public String getDescriptionArticle ()
    {
        return descriptionArticle;
    }

    public void setDescriptionArticle (String descriptionArticle)
    {
        this.descriptionArticle = descriptionArticle;
    }

    public String getLoginuser ()
    {
        return loginuser;
    }

    public void setLoginuser (String loginuser)
    {
        this.loginuser = loginuser;
    }

    public int getCodeArticle ()
    {
        return codeArticle;
    }

    public void setCodeArticle (int codeArticle)
    {
        this.codeArticle = codeArticle;
    }


}
