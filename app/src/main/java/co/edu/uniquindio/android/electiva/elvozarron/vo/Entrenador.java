package co.edu.uniquindio.android.electiva.elvozarron.vo;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.provider.BaseColumns;

import java.sql.Blob;

/**
 * Clase que contiene los atributos de un entrenador
 * Created by MONICA on 30/10/2016.
 */
public class Entrenador implements Parcelable,BaseColumns{



    //atributos
    private String strId;
    private String nombre;
    private String genero;
    private String historial;
    private byte[] imagen;
    private String url;
    private int id;

    //metodo constructor de la clase
    public Entrenador(int id,String historial, String nombre, String genero, byte[] imagen) {

        this.id=id;
        this.historial = historial;
        this.nombre = nombre;
        this.genero = genero;
        this.imagen = imagen;
    }

    //metodo constructor , pero que recibe un parcel, y me permita la navegación
    protected Entrenador (Parcel in){
        strId = in.readString();
        nombre = in.readString();
        genero = in.readString();
        historial = in.readString();
        url = in.readString();
    }

    /**
     * Metodo que crea el parcelable de tipo entrenador
     */
    public static final Parcelable.Creator<Entrenador> CREATOR = new Parcelable.Creator<Entrenador>() {
        @Override
        public Entrenador createFromParcel(Parcel in) {
            return new Entrenador(in);
        }

        @Override
        public Entrenador[] newArray(int size) {
            return new Entrenador[size];
        }
    };

   //@Override
    public int describeContents() {
        return 0;
    }


    /**
     *Metodo para escribir los campos con parcelable
     * @param dest
     * @param flags
     */
    //@Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(strId);
        dest.writeString(nombre);
        dest.writeString(genero);
        dest.writeString(historial);
        dest.writeString(url);
    }


    //METODOS GETTERS Y SETTERS DE LOS ATRIBUTOS DE LA CLASE
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getHistorial() {
        return historial;
    }

    public void setHistorial(String historial) {
        this.historial = historial;
    }

    public byte[] getImagen() {
        return imagen;
    }

    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    public String getStrId() {
        return strId;
    }

    public void setStrId(String strId) {
        this.strId = strId;
    }
}