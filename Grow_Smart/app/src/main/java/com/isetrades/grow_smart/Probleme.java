package com.isetrades.grow_smart;

import android.os.Parcel;
import android.os.Parcelable;

public class Probleme implements Parcelable
{
    private int imgUser;
    private String userName;
    private String date;
    private String titreProbleme;
    private String desPrombleme;
    private int nbComments;

    public Probleme(int imgUser, String userName, String date, String titreProbleme, String desPrombleme, int nbComments) {
        this.imgUser = imgUser;
        this.userName = userName;
        this.date = date;
        this.titreProbleme = titreProbleme;
        this.desPrombleme = desPrombleme;
        this.nbComments = nbComments;
    }

    protected Probleme(Parcel in) {
        imgUser = in.readInt();
        userName = in.readString();
        date = in.readString();
        titreProbleme = in.readString();
        desPrombleme = in.readString();
        nbComments = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(imgUser);
        dest.writeString(userName);
        dest.writeString(date);
        dest.writeString(titreProbleme);
        dest.writeString(desPrombleme);
        dest.writeInt(nbComments);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Probleme> CREATOR = new Creator<Probleme>() {
        @Override
        public Probleme createFromParcel(Parcel in) {
            return new Probleme(in);
        }

        @Override
        public Probleme[] newArray(int size) {
            return new Probleme[size];
        }
    };

    public int getImgUser() {
        return imgUser;
    }

    public void setImgUser(int imgUser) {
        this.imgUser = imgUser;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTitreProbleme() {
        return titreProbleme;
    }

    public void setTitreProbleme(String titreProbleme) {
        this.titreProbleme = titreProbleme;
    }

    public String getDesPrombleme() {
        return desPrombleme;
    }

    public void setDesPrombleme(String desPrombleme) {
        this.desPrombleme = desPrombleme;
    }

    public int getNbComments() {
        return nbComments;
    }

    public void setNbComments(int nbComments) {
        this.nbComments = nbComments;
    }
}
