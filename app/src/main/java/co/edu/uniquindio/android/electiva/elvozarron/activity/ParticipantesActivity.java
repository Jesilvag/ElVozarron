package co.edu.uniquindio.android.electiva.elvozarron.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

import co.edu.uniquindio.android.electiva.elvozarron.R;
import co.edu.uniquindio.android.electiva.elvozarron.fragments.ListaDeParticipantesFragment;
import co.edu.uniquindio.android.electiva.elvozarron.util.ParticipanteAdapter;
import co.edu.uniquindio.android.electiva.elvozarron.vo.Participante;

public class ParticipantesActivity extends AppCompatActivity implements ListaDeParticipantesFragment.OnParticipanteSeleccionadoListener {

    private RecyclerView listadoDeParticipantes;
    private ArrayList<Participante> participantes;
    private ParticipanteAdapter adaptador;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_participantes);

        participantes = new ArrayList();
        participantes.add(new Participante("akemi nakamura", "rihana", "estudiante", 25, "https://www.youtube.com/watch?v=fOn5tSagerY", R.drawable.p_akemi));
        participantes.add(new Participante("andrea lombana", "jhony", "estudiante", 23, "https://www.youtube.com/watch?v=Qnu0Mww49us", R.drawable.p_andrea));
        participantes.add(new Participante("andres bermudez", "adele", "estudiante", 21, "https://www.youtube.com/watch?v=UCF9oHXhDMU", R.drawable.p_andres));

        ListaDeParticipantesFragment listaDeParticipantesFragment = (ListaDeParticipantesFragment) getSupportFragmentManager().findFragmentById(R.id.fragmento_lista_participantes);
        listaDeParticipantesFragment.setParticipantes(participantes);
        try { Thread.sleep(1000000);
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    /**
     * metodo que me dice si un item fue seleccionado
     *
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onParticipanteSeleccionado(int position) {

    }
}
