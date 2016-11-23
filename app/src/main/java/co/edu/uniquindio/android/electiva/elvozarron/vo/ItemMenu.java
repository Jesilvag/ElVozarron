package co.edu.uniquindio.android.electiva.elvozarron.vo;

/**
 * Clase que contiene los atributos de ItemMenu
 * Created by MONICA on 24/10/2016.
 */
public class ItemMenu {

    private String nombre;
    private String id;
    private int imagen;

    /**
     * Metodo constructor de la clase
     * @param nombre
     * @param imagen
     * @param id
     */
    public ItemMenu(String nombre, int imagen, String id) {
        this.nombre = nombre;
        this.id = id;
        this.imagen = imagen;
    }

    //GETTERS Y SETTERS DE LOS ATRIBUTOS DE LA CLASE

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    /**
     * Metodo toString de la clase, sobreescrito
     * @return
     */
    @Override
    public String toString() {
        return "ItemMenu{" +
                "nombre='" + nombre + '\'' +
                ", id='" + id + '\'' +
                ", imagen=" + imagen +
                '}';
    }
}
