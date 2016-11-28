package co.edu.uniquindio.android.electiva.elvozarron.fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import co.edu.uniquindio.android.electiva.elvozarron.R;
import co.edu.uniquindio.android.electiva.elvozarron.activity.EntrenadorActivity;
import co.edu.uniquindio.android.electiva.elvozarron.util.ConexionSQLite;
import co.edu.uniquindio.android.electiva.elvozarron.vo.Entrenador;

/**
 * Clase que maneja la información contenida en el fragment del detalle entrenador
 */
public class DetalleEntrenadorFragment extends Fragment implements View.OnClickListener{

    private TextView txtNombreEntrenador;
    private TextView txtNombreGenero;
    private TextView txtHistorial;

    public Entrenador getEntrenador() {
        return entrenador;
    }

    public void setEntrenador(Entrenador entrenador) {
        this.entrenador = entrenador;
    }

    private Entrenador entrenador;
    private ConexionSQLite datos;

    //Método constructor
    public DetalleEntrenadorFragment() {
        // Required empty public constructor

    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    //metodo que infla el codigo
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detalle_entrenador, container, false);
    }

    /**
     * metodo que muestra los atributos de un entrenador en el fragmento de detalle
     * @param entrenador, elemento que entra con los atribuos del entrenador
     */
    public void mostrarEntrenador (Entrenador entrenador) {
        this.entrenador = entrenador;
        txtNombreEntrenador = (TextView) getView().findViewById(R.id.nombre_entrenador);
        txtNombreEntrenador.setText(entrenador.getNombre());
        txtNombreGenero = (TextView) getView().findViewById(R.id.nombre_genero);
        txtNombreGenero.setText(entrenador.getGenero());
        txtHistorial= (TextView) getView().findViewById(R.id.historial_entrenador);
        txtHistorial.setText(entrenador.getHistorial());

    }

    /**
     * Metodo que inicia una actividad al iniciar un evento con el mpuse
     * @param v
     */
    @Override public void onClick(View v) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(entrenador.getUrl()));
        startActivity(intent);

    }
}
