package co.edu.uniquindio.android.electiva.elvozarron.util;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import co.edu.uniquindio.android.electiva.elvozarron.vo.Participante;

/**
 * Created by MONICA on 21/11/2016.
 */
public class ConexionSQLite {


    public static final String NOMBRE_BD = "vozarron";
    public static final String TABLA_PARTICIPANTES = "Participantes";
    public static final String CAMPOS_TABLA_PARTICIPANTES[]= new String[]{"_ID","NOMBRE_PARTICIPANTE","FK_ENTRENADOR","OCUPACION","EDAD","URL_VIDEO","AVATAR"};

    private VozarronSQLiteHelper usdbh;
    private SQLiteDatabase db;

    public ConexionSQLite(Context context, int version){
        usdbh = new VozarronSQLiteHelper(context,NOMBRE_BD,null,version);
        db = usdbh.getWritableDatabase();
    }

    public static String crearTablaParticipante(){
        String crearTabla = "CREATE TABLE %s ( %s INTEGER PRIMARY KEY AUTOINCREMENT, %s TEXT, %s TEXT, %s TEXT, %s TEX)";
        return String.format(crearTabla, TABLA_PARTICIPANTES, CAMPOS_TABLA_PARTICIPANTES[0], CAMPOS_TABLA_PARTICIPANTES[1], CAMPOS_TABLA_PARTICIPANTES[2],
                CAMPOS_TABLA_PARTICIPANTES[3], CAMPOS_TABLA_PARTICIPANTES[4],CAMPOS_TABLA_PARTICIPANTES[5],CAMPOS_TABLA_PARTICIPANTES[6]);
    }


    public ArrayList<Participante> getInformacionBD(){

        ArrayList<Participante> participantes = new ArrayList<>();

        Cursor c = db.query(TABLA_PARTICIPANTES,CAMPOS_TABLA_PARTICIPANTES,null,null,null,null,null);

        if (c.moveToFirst()) {
            do {
                String _id = c.getString(0);
                String nombreParticipante = c.getString(1);
                String entrenador = c.getString(2);
                String ocupacion = c.getString(3);
                String edad = c.getString(4);
                String urlVideo = c.getString(5);
                String avatar = c.getString(6);

                participantes.add(new Participante(_id, nombreParticipante, entrenador, ocupacion,edad,urlVideo,avatar));

            } while (c.moveToNext());
        }

        return participantes;

    }

}
