package co.edu.uniquindio.android.electiva.elvozarron.util;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.drawable.Drawable;
import android.net.Uri;

import java.lang.reflect.Field;
import java.sql.Blob;
import java.util.ArrayList;

import co.edu.uniquindio.android.electiva.elvozarron.R;
import co.edu.uniquindio.android.electiva.elvozarron.vo.Entrenador;
import co.edu.uniquindio.android.electiva.elvozarron.vo.Participante;

/**
 * Created by MONICA on 21/11/2016.
 */
public class ConexionSQLite {


    public static final String NOMBRE_BD = "vozarron";
    public static final String TABLA_ENTRENADORES = "Entrenadores";
    public static final String CAMPOS_TABLA_ENTRENADORES[]= new String[]{"_ID","NOMBRE_ENTRENADOR","GENERO","HISTORIAL","AVATAR"};

    private VozarronSQLiteHelper usdbh;
    private SQLiteDatabase db;

    public ConexionSQLite(Context context, int version){
        usdbh = new VozarronSQLiteHelper(context,NOMBRE_BD,null,version);
        db = usdbh.getWritableDatabase();
    }

    public static String crearTablaParticipante(){
        String crearTabla = "CREATE TABLE %s ( %s INTEGER PRIMARY KEY AUTOINCREMENT, %s TEXT, %s TEXT, %s TEXT, %s BLOB)";
        return String.format(crearTabla, TABLA_ENTRENADORES, CAMPOS_TABLA_ENTRENADORES[0], CAMPOS_TABLA_ENTRENADORES[1], CAMPOS_TABLA_ENTRENADORES[2],
                CAMPOS_TABLA_ENTRENADORES[3], CAMPOS_TABLA_ENTRENADORES[4]);
    }


    public ArrayList<Entrenador> getInformacionBD(){

        ArrayList<Entrenador> entrenadores = new ArrayList<>();
        Cursor c = db.query(TABLA_ENTRENADORES, CAMPOS_TABLA_ENTRENADORES,null,null,null,null,null);

        if (c.moveToFirst()) {
            do {
           int _id = c.getInt(0);
                String nombreEntrenador = c.getString(1);
                String genero = c.getString(2);
                String historial = c.getString(3);
                byte[] avatar = c.getBlob(4);


                entrenadores.add(new Entrenador(_id,historial,nombreEntrenador,genero,avatar));

            } while (c.moveToNext());
        }

        return entrenadores;

    }
    public Entrenador getEntrenador(int id){
        String arg="_ID";
        String[]campo=new String[] {String.valueOf(id)};
        Cursor c=db.query(TABLA_ENTRENADORES,CAMPOS_TABLA_ENTRENADORES,arg,campo,null,null,null);
        Entrenador entrenador=null;
        if (c.moveToFirst()) {
            do {
                int _id = c.getInt(0);
                String nombreEntrenador = c.getString(1);
                String genero = c.getString(2);
                String historial = c.getString(3);
                byte[] avatar = c.getBlob(4);

            entrenador=new Entrenador(_id,historial,nombreEntrenador,genero,avatar);



            } while (c.moveToNext());
        }
        return  entrenador;
    }

}
