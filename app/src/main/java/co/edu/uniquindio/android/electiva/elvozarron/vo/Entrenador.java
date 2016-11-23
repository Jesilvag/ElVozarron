package co.edu.uniquindio.android.electiva.elvozarron.vo;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Clase que contiene los atributos de un entrenador
 * Created by MONICA on 30/10/2016.
 */
public class Entrenador implements Parcelable {

    //atributos
    private String id;
    private String nombre;
    private String genero;
    private String historial;
    private int imagen;
    private String url;

    //metodo constructor de la clase
    public Entrenador(String historial, String nombre, String genero,int imagen) {
        this.historial = historial;
        this.nombre = nombre;
        this.genero = genero;
        this.imagen = imagen;
    }

    //metodo constructor , pero que recibe un parcel, y me permita la navegación
    protected Entrenador (Parcel in){
        id = in.readString();
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
        dest.writeString(id);
        dest.writeString(nombre);
        dest.writeString(genero);
        dest.writeString(historial);
        dest.writeString(url);
    }


    //METODOS GETTERS Y SETTERS DE LOS ATRIBUTOS DE LA CLASE
    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}