package co.edu.uniquindio.android.electiva.elvozarron.util;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import co.edu.uniquindio.android.electiva.elvozarron.R;
import co.edu.uniquindio.android.electiva.elvozarron.activity.EntrenadoresActivity;
import co.edu.uniquindio.android.electiva.elvozarron.activity.InternacionalizacionActivity;
import co.edu.uniquindio.android.electiva.elvozarron.activity.ParticipantesActivity;
import co.edu.uniquindio.android.electiva.elvozarron.vo.ItemMenu;

/**
 * Clase Adapter que maneja la lista del menu de bienvenida
 * Created by MONICA on 25/10/2016.
 */
public class ItemMenuAdapter extends RecyclerView.Adapter<ItemMenuAdapter.ItemMenuViewHolder> {

    private List<ItemMenu> items;//lista con las opciones en el menu de bienvenida



    //Clase view holder
    public static class ItemMenuViewHolder extends RecyclerView.ViewHolder  {

        public ImageView imagen;
        public TextView texto;
        public ItemMenu itemMenu;

        /**
         * Metodo constructor de la clase ItemMenuViewHolder
         * @param view
         */
        public ItemMenuViewHolder(View view){
            super(view);
            imagen = (ImageView)view.findViewById(R.id.imagen);
            texto = (TextView)view.findViewById(R.id.nombre);

            //aqui se asigna la accion que se llevara a cabo cuando se presione determinado item, comparado
            //por el nombre que tiene cada uno de los items
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if(itemMenu.getId().equals("1")) {

                        Intent intent = new Intent(v.getContext(), EntrenadoresActivity.class);
                        v.getContext().startActivity(intent);
                    }
                    if (itemMenu.getId().equals("2")){
                        Intent intent = new Intent(v.getContext(), ParticipantesActivity.class);
                        v.getContext().startActivity(intent);
                    }
                    if (itemMenu.getId().equals("3")){
                        Toast.makeText(v.getContext(), "votar", Toast.LENGTH_SHORT).show();
                    }
                    if (itemMenu.getId().equals("4")){
                        Intent intent = new Intent(v.getContext(), InternacionalizacionActivity.class);
                        v.getContext().startActivity(intent);
                    }
                    if (itemMenu.getId().equals("5")){
                        Toast.makeText(v.getContext(), "agregar participante", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }


    /**
     * metodo constructor de la clase ItemMenuAdapter
     * @param items
     */
    public ItemMenuAdapter(List<ItemMenu> items){
        this.items = items;
    }

    /**
     * Método que retorna el tamaño de la lista del menu de bienvenida
     * @return
     */
    @Override
    public int getItemCount(){
        return items.size();
    }

    /**
     * Metodo que infla el codigo para asignarlo a la lista de bienvenida (list_item_welcome)
     * @param viewGroup
     * @param i
     * @return
     */
    @Override
    public ItemMenuViewHolder onCreateViewHolder(ViewGroup viewGroup, int i){

        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_welcome,viewGroup,false);
        return new ItemMenuViewHolder(v);
    }

    /**
     * Método que asigna los valores de un item a traves de la variable viewHolder
     * @param viewHolder
     * @param i
     */
    @Override
    public void onBindViewHolder(ItemMenuViewHolder viewHolder, int i){

        ItemMenu item = items.get(i);

        viewHolder.imagen.setImageResource(items.get(i).getImagen());
        viewHolder.texto.setText(items.get(i).getNombre());
        viewHolder.itemMenu = item;
    }
}

