package co.edu.uniquindio.android.electiva.elvozarron.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.util.Base64;
import android.util.Log;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by MONICA on 21/11/2016.
 */
public class Utilidades {

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

}
