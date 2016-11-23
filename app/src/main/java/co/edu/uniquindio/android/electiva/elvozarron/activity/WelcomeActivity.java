package co.edu.uniquindio.android.electiva.elvozarron.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import co.edu.uniquindio.android.electiva.elvozarron.R;
import co.edu.uniquindio.android.electiva.elvozarron.util.ItemMenuAdapter;
import co.edu.uniquindio.android.electiva.elvozarron.vo.ItemMenu;

/**
 * Clase principal, que maneja la actividad de bienvenida
 */
public class WelcomeActivity extends AppCompatActivity {

    private RecyclerView listaMenu;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager lmanager;
    private ArrayList<ItemMenu> menus;

    /**
     * Metodo que llama la actividad activity_welcome
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        //arraylist del menu principal
        menus = new ArrayList();
        menus.add(new ItemMenu("Entrenadores",R.drawable.entrenadores,"1"));
        menus.add(new ItemMenu("Participantes",R.drawable.participantes,"2"));
        menus.add(new ItemMenu("Votar",R.drawable.votar,"3"));
        menus.add(new ItemMenu("Idioma",R.drawable.idioma,"4"));
        menus.add(new ItemMenu("Agregar participante",R.drawable.agregar,"5"));


        //obtener el recycle view
        listaMenu = (RecyclerView) findViewById(R.id.welcome);
        listaMenu.setHasFixedSize(true);

        //administrador del linear layout
        lmanager = new LinearLayoutManager(this);
        listaMenu.setLayoutManager(lmanager);

        //adaptador de los items del menu de bienvenida
        adapter = new ItemMenuAdapter(menus);
        listaMenu.setAdapter(adapter);




    }
}
