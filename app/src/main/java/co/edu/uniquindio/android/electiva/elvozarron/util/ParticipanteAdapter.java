package co.edu.uniquindio.android.electiva.elvozarron.util;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import co.edu.uniquindio.android.electiva.elvozarron.R;
import co.edu.uniquindio.android.electiva.elvozarron.activity.DetalleParticipanteActivity;
import co.edu.uniquindio.android.electiva.elvozarron.fragments.ListaDeParticipantesFragment;
import co.edu.uniquindio.android.electiva.elvozarron.vo.Participante;

/**
 * Clase participante adapter que maneja la lista de participantes
 * Created by MONICA on 19/11/2016.
 */
public class ParticipanteAdapter extends RecyclerView.Adapter<ParticipanteAdapter.ParticipanteViewHolder>{


    private ArrayList<Participante> participantes;
    private static OnClickAdaptadorDeParticipante listener;

    /**
     *
     * @param participantes
     * @param listaDeParticipantesFragment
     */
    public ParticipanteAdapter(ArrayList<Participante> participantes, ListaDeParticipantesFragment listaDeParticipantesFragment) {
        this.participantes = participantes;
        listener = (OnClickAdaptadorDeParticipante) listaDeParticipantesFragment;
    }


    public ParticipanteViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.resumen_participantes, parent, false);
        ParticipanteViewHolder participanteViewHolder = new ParticipanteViewHolder(itemView);
        return participanteViewHolder;
    }


    public void onBindViewHolder(ParticipanteAdapter.ParticipanteViewHolder viewHolder,int i){
        Participante participante = participantes.get(i);
        viewHolder.txtEntrenadorParticipante.setText(participantes.get(i).getEntrenador());
        viewHolder.txtNombreParticipante.setText(participantes.get(i).getNombreParticipante());
        viewHolder.imagenParticipante.setImageResource(participantes.get(i).getAvatar());
        viewHolder.p=participante;
    }


    public static class ParticipanteViewHolder extends RecyclerView.ViewHolder {
        private TextView txtNombreParticipante;
        private TextView txtEntrenadorParticipante;
        private ImageView imagenParticipante;
        public Participante p;


        public ParticipanteViewHolder(View itemView) {
            super(itemView);
            txtNombreParticipante = (TextView) itemView.findViewById(R.id.nombre_participante);
            txtEntrenadorParticipante = (TextView) itemView.findViewById(R.id.nombre_entrenador_participante);
            imagenParticipante = (ImageView) itemView.findViewById(R.id.imagen_participante);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (p.getNombreParticipante().equals("monica")) {
                        Intent intent = new Intent(v.getContext(), DetalleParticipanteActivity.class);
                        v.getContext().startActivity(intent);

                    }


                }
            });
        }
        /**
         * Asigna los valores del participante   a la interfaz , para que sean visibles en ella
         *
         * @param participante
         */
        public void binParticipante(Participante participante) {
            txtNombreParticipante.setText(participante.getNombreParticipante());
            txtEntrenadorParticipante.setText(participante.getEntrenador());

        }



    } //ACA TERMINA LA CLASE ParticipanteViewHolder

    /**
     * interface que tiene el metodo para pasar la posicion del evento
     */
    public interface OnClickAdaptadorDeParticipante{
        public void onClickPosition(int pos);
    }

    @Override
    public int getItemCount() {
        return participantes.size();
    }

}
