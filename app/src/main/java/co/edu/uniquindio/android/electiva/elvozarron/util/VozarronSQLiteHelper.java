package co.edu.uniquindio.android.electiva.elvozarron.util;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by MONICA on 21/11/2016.
 */
public class VozarronSQLiteHelper extends SQLiteOpenHelper {

    private ConexionSQLite conexionSQLite;

    public VozarronSQLiteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(conexionSQLite.crearTablaParticipante());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
