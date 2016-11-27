package co.edu.uniquindio.android.electiva.elvozarron.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.util.Base64;
import android.util.Log;

import com.google.gson.Gson;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import co.edu.uniquindio.android.electiva.elvozarron.vo.Participante;

/**
 * Created by MONICA on 21/11/2016.
 */
public class Utilidades {


    public final static String URL_SERVICIO = "http://10.0.2.2:3000/api/manager";
    public static final int LISTAR = 1;
    public static final int AGREGAR= 2;
    public static final int MODIFICAR = 3;
    public static final int ELIMINAR = 4;


    public static void getKeyHash(Context context) {
        try {
            PackageInfo info = context.getPackageManager().getPackageInfo(context.getPackageName(), PackageManager.GET_SIGNATURES);
            for (Signature signature : info.signatures) {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                String sign = Base64.encodeToString(md.digest(), Base64.DEFAULT);
                Log.e("Mi clave HASH:", sign);
            }
        } catch (PackageManager.NameNotFoundException e) {
            Log.d("prueba", "1 KeyHash Error: " + e.getMessage());
        } catch (NoSuchAlgorithmException e) {
            Log.d("prueba", "2 KeyHash Error: " + e.getMessage());
        }

    }



    public static Participante convertirJSONAParticipante(String jsonParticipante) {

        Gson gson = new Gson();
        Participante participante = gson.fromJson(jsonParticipante, Participante.class);
        return participante;

    }

    public static String convertirParticipanteAJSON(Participante participante) {

        Gson gson=  new Gson();
        String json = gson.toJson(participante);
        return json;

    }


        }
