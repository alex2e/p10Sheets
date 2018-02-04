package com.example.alejandro.practica10sheet.data;


import android.os.Parcel;
import android.os.Parcelable;

public class Alumno implements Parcelable {
    private String nombre;
    private int numero;
    private String urlPhoto;


    public Alumno(String nombre, int numero, String urlPhoto) {
        this.nombre = nombre;
        this.numero = numero;
        this.urlPhoto = urlPhoto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        try{
            this.numero = Integer.parseInt(numero);
        }catch (Exception e){
        }

    }

    public String getUrlPhoto() {
        return urlPhoto;
    }
    public void setUrlPhoto(String urlPhoto) {
        this.urlPhoto = urlPhoto;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.nombre);
        dest.writeInt(this.numero);
        dest.writeString(this.urlPhoto);
    }

    protected Alumno(Parcel in) {
        this.nombre = in.readString();
        this.numero = in.readInt();
        this.urlPhoto = in.readString();
    }

    public static final Parcelable.Creator<Alumno> CREATOR = new Parcelable.Creator<Alumno>() {
        @Override
        public Alumno createFromParcel(Parcel source) {
            return new Alumno(source);
        }

        @Override
        public Alumno[] newArray(int size) {
            return new Alumno[size];
        }
    };
}
