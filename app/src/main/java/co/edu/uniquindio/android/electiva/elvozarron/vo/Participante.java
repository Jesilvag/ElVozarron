package co.edu.uniquindio.android.electiva.elvozarron.vo;

import java.util.UUID;

/**
 * Clase encargada de manejar la información de cada participante
 * Created by MONICA on 15/11/2016.
 */
public class Participante {

    /**
     * Atributos de un participante
     */

    private String _id;
    private String idParticipante;
    private String nombreParticipante;
    private String entrenador;
    private String ocupacion;
    private int edad;
    private String urlVideo;
    private boolean estado;
    private int avatar;

    /**
     * Método constructor de la clase, que me permite crear un participante
     * @param nombreParticipante
     * @param entrenador
     * @param ocupacion
     * @param edad
     * @param urlVideo
     * @param avatar
     */
    public Participante(String nombreParticipante, String entrenador, String ocupacion, int edad, String urlVideo, int avatar) {
        idParticipante = UUID.randomUUID().toString();//cadena aleatoria que se le asigna como id
        this.nombreParticipante = nombreParticipante;
        this.entrenador = entrenador;
        this.ocupacion = ocupacion;
        this.edad = edad;
        this.urlVideo = urlVideo;
        this.avatar = avatar;
        this.estado = true; // se declara desde el codigo, porque se supone que si se crea el participante es porque va estar activo, cuando se elimine se cambia su estado a false
    }

    public Participante(String id, String nombreParticipante, String entrenador, String ocupacion, String edad, String urlVideo, String avatar) {
    }

    /**
     *Métodos getter y setter de la clase participante
     */
    public String getIdParticipante() {
        return idParticipante;
    }

    public void setIdParticipante(String idParticipante) {
        this.idParticipante = idParticipante;
    }

    public String getNombreParticipante() {
        return nombreParticipante;
    }

    public void setNombreParticipante(String nombreParticipante) {
        this.nombreParticipante = nombreParticipante;
    }

    public String getEntrenador() {
        return entrenador;
    }

    public void setEntrenador(String entrenador) {
        this.entrenador = entrenador;
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getUrlVideo() {
        return urlVideo;
    }

    public void setUrlVideo(String urlVideo) {
        this.urlVideo = urlVideo;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public int getAvatar() {
        return avatar;
    }

    public void setAvatar(int avatar) {
        this.avatar = avatar;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }
}
