package co.edu.uniquindio.android.electiva.elvozarron.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import co.edu.uniquindio.android.electiva.elvozarron.R;
import co.edu.uniquindio.android.electiva.elvozarron.fragments.DetalleEntrenadorFragment;
import co.edu.uniquindio.android.electiva.elvozarron.fragments.ListaDeEntrenadoresFragment;
import co.edu.uniquindio.android.electiva.elvozarron.util.ConexionSQLite;

/**
 * Actividad que maneja el fragmento del detalle entrenador
 * Created by MONICA on 30/10/2016.
 */
public class EntrenadorActivity extends AppCompatActivity {

    private ConexionSQLite datos;
    /**
     * metodo que llama el activity entrenador
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entrenador);

        datos=new ConexionSQLite(this,1);

        DetalleEntrenadorFragment detalleEntrenadorFragment = (DetalleEntrenadorFragment) getSupportFragmentManager().findFragmentById(R.id.fragmento_detalle_entrenador);
        detalleEntrenadorFragment.setEntrenador(datos.getEntrenador(1));
    }
}
