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
    private String[] nombres;

    /**
     * Metodo que llama la actividad activity_welcome
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        //Array de nombres
        nombres=getResources().getStringArray(R.array.welcome);
        //arraylist del menu principal
        menus = new ArrayList();
<<<<<<< HEAD
        menus.add(new ItemMenu("Entrenadores", R.drawable.entrenadores,"1"));
        menus.add(new ItemMenu("Participantes",R.drawable.participantes,"2"));
        menus.add(new ItemMenu("Votar",R.drawable.votar,"3"));
        menus.add(new ItemMenu("Idioma",R.drawable.idioma,"4"));
        menus.add(new ItemMenu("Agregar participante",R.drawable.agregar,"5"));
=======
        menus.add(new ItemMenu(nombres[0],R.drawable.entrenadores,"1"));
        menus.add(new ItemMenu(nombres[1],R.drawable.participantes,"2"));
        menus.add(new ItemMenu(nombres[2],R.drawable.votar,"3"));
        menus.add(new ItemMenu(nombres[3],R.drawable.idioma,"4"));
        menus.add(new ItemMenu(nombres[4],R.drawable.agregar,"5"));
>>>>>>> e7be9f2b32bcb68a832b296ab452893a96367dbc


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
