package co.edu.uniquindio.android.electiva.elvozarron.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import co.edu.uniquindio.android.electiva.elvozarron.R;
import co.edu.uniquindio.android.electiva.elvozarron.vo.Participante;


public class DetalleParticipanteFragment extends Fragment {

    private ImageView imagenParticipante;
    private TextView txtNombreParticipante;
    private TextView txtEspacioEdad;
    private TextView txtEspacioEntrenador;
    private Spinner spinnerOcupacion;
    private TextView txtUrlVideo;
    private TextView txtEstado;
    private Participante participante;
    ArrayAdapter<CharSequence> adapter;

    public DetalleParticipanteFragment()
    {

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
        return inflater.inflate(R.layout.fragment_detalle_participante, container, false);
    }

    /**
     * metodo que muestra los atributos de un entrenador en el fragmento de detalle
     * @param participante, elemento que entra con los atribuos del entrenador
     */
    public void mostrarEntrenador (Participante participante) {
        this.participante = participante;
        txtNombreParticipante = (TextView) getView().findViewById(R.id.titulo_nombre_participante);
        txtNombreParticipante.setText(participante.getNombreParticipante());

        txtEspacioEdad = (TextView)getView().findViewById(R.id.espacio_edad);
        txtEspacioEdad.setText(participante.getEdad());

        txtEspacioEntrenador = (TextView)getView().findViewById(R.id.espacio_entrenador_par);
        txtEspacioEntrenador.setText(participante.getEntrenador());

        txtUrlVideo = (TextView)getView().findViewById(R.id.espacio_url_video);
        txtUrlVideo.setText(participante.getUrlVideo());

        txtEstado = (TextView)getView().findViewById(R.id.espacio_estado);
        txtEstado.setText(participante.isEstado()+"");//arreglar este machete


    }

}
