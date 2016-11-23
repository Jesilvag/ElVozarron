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
import co.edu.uniquindio.android.electiva.elvozarron.activity.EntrenadorActivity;
import co.edu.uniquindio.android.electiva.elvozarron.fragments.ListaDeEntrenadoresFragment;
import co.edu.uniquindio.android.electiva.elvozarron.vo.Entrenador;

/**
 * Clase Adapter que maneja el recycler view para manejar listas
 * Created by MONICA on 30/10/2016.
 */
public class EntrenadorAdapter extends RecyclerView.Adapter<EntrenadorAdapter.EntrenadoreViewHolder>{

    private ArrayList<Entrenador> entrenadores;
    private static OnClickAdaptadorDeEntrenador listener;


    /**
     * Metodo constructor de la clase AdaptadorEntrenador, recibe un arraylist y un fragmento
     * @param entrenadores
     * @param listaDeEntrenadoresFragment
     */
    public EntrenadorAdapter(ArrayList<Entrenador> entrenadores, ListaDeEntrenadoresFragment listaDeEntrenadoresFragment) {
        this.entrenadores = entrenadores;
        listener = (OnClickAdaptadorDeEntrenador) listaDeEntrenadoresFragment;
    }


    /**
     * metodo que ayuda a inflar el codigo, y crea el nuevo viewholder
     * @param parent
     * @param viewType
     * @return entrenadorViewholder
     */
    @Override
    public EntrenadoreViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.resumen_entrenadores, parent, false);
        EntrenadoreViewHolder entrenadorViewHolder = new EntrenadoreViewHolder(itemView);
        return entrenadorViewHolder;
    }


    /**
     * asigna los valores a los id, a traves del adaptador
     * @param viewHolder
     * @param i
     */
    @Override
    public void onBindViewHolder(EntrenadorAdapter.EntrenadoreViewHolder viewHolder,int i){
        Entrenador entrenador = entrenadores.get(i);
        viewHolder.txtNombreEntrenador.setText(entrenadores.get(i).getNombre());
        viewHolder.txtGenero.setText(entrenadores.get(i).getGenero());
        viewHolder.imagen.setImageResource(entrenadores.get(i).getImagen());
        viewHolder.entre = entrenador;
    }

    /**
     * retorna el tamaño del arraylis de entrenadores
     * @return
     */
    @Override
    public int getItemCount() {

        return entrenadores.size();
    }

    /**
     * ACA EMPIEZA LA CLASE EntrenadorViewHolder
     * Clase que crea el EntrenadoresViewHolder y que al momento de realizar clic en uno de los items nos envie a uno de l
     *los entrenadores
     */
    public static class EntrenadoreViewHolder extends RecyclerView.ViewHolder  {
        private TextView txtNombreEntrenador;
        private TextView txtGenero;
        private ImageView imagen;
        public Entrenador entre;


        public EntrenadoreViewHolder(View itemView) {
            super(itemView);
            txtNombreEntrenador = (TextView)itemView.findViewById(R.id.nombre_entrenador);
            txtGenero = (TextView)itemView.findViewById(R.id.nombre_genero);
            imagen = (ImageView) itemView.findViewById(R.id.imagen_entrenador);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if(entre.getNombre().equals("rihana")){
                        Intent intent = new Intent(v.getContext(), EntrenadorActivity.class);
                        v.getContext().startActivity(intent);

                    }
                    if(entre.getNombre().equals("adele")){
                        Intent intent = new Intent(v.getContext(), EntrenadorActivity.class);
                        v.getContext().startActivity(intent);

                    }
                    if(entre.getNombre().equals("jhony rivera")){
                        Intent intent = new Intent(v.getContext(), EntrenadorActivity.class);
                        v.getContext().startActivity(intent);

                    }

                }
            });
        }

        /**
         * Asigna los valores del entrenador a la interfaz , para que sean visibles en ella
         *
         * @param entrenador
         */
        public void binEntrenador(Entrenador entrenador) {
            txtNombreEntrenador.setText(entrenador.getNombre());

            txtGenero.setText(entrenador.getGenero());
        }



    } //ACA TERMINA LA CLASE EntrenadorViewHolder

    /**
     * interface que tiene el metodo para pasar la posicion del evento
     */
    public interface OnClickAdaptadorDeEntrenador{
        public void onClickPosition(int pos);
    }
}
