package co.edu.uniquindio.android.electiva.elvozarron.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

import co.edu.uniquindio.android.electiva.elvozarron.R;
import co.edu.uniquindio.android.electiva.elvozarron.fragments.DetalleEntrenadorFragment;
import co.edu.uniquindio.android.electiva.elvozarron.fragments.ListaDeEntrenadoresFragment;
import co.edu.uniquindio.android.electiva.elvozarron.util.ConexionSQLite;
import co.edu.uniquindio.android.electiva.elvozarron.util.EntrenadorAdapter;
import co.edu.uniquindio.android.electiva.elvozarron.vo.Entrenador;

/**
 * Clase que maneja la lista de entrenadores
 * Created by MONICA on 30/10/2016.
 */
public class EntrenadoresActivity extends AppCompatActivity implements ListaDeEntrenadoresFragment.OnEntrenadorSeleccionadoListener {



    private RecyclerView listadoDeEntrenadores;
    private ArrayList<Entrenador> entrenadores;
    private EntrenadorAdapter adaptador ;
    private ConexionSQLite datos;

    /**
     * Método que llama el activity entrenadores
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entrenadores);
        datos=new ConexionSQLite(this,1);
        //se inicializa el arraylist con los elementos de la lista entrenadores
        entrenadores = new ArrayList();


        //asigna la lista de entrenadores en la lista del fragment
        ListaDeEntrenadoresFragment listaDeEntrenadoresFragment = (ListaDeEntrenadoresFragment) getSupportFragmentManager().findFragmentById(R.id.fragmento_lista_entrenadores);
        listaDeEntrenadoresFragment.setEntrenadores(datos.getInformacionBD());
    }

    /**
     * meodo que me permite inflar el codigo
     * @param menu
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    /**
     * metodo que me dice si un item fue seleccionado
     * @param item
     * @return
     */
    @Override public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }


    /**
     * Metodo que me retorna la actividad del entrenador detallado, segun la posicion a la que acceda
     * @param position
     */
    @Override
    public void onEntrenadorSeleccionado(int position) {

        boolean esFragmento = getSupportFragmentManager().findFragmentById(R.id.fragmento_detalle_entrenador) != null;

        if (esFragmento) {

            ((DetalleEntrenadorFragment)
                    getSupportFragmentManager().findFragmentById(R.id.fragmento_detalle_entrenador)).mostrarEntrenador(entrenadores.get(position));
        } else {
            Intent intent = new Intent(this,Entrenador.class);
            intent.putExtra("entre", entrenadores.get(position));
            startActivity(intent);
        }
    }
}
