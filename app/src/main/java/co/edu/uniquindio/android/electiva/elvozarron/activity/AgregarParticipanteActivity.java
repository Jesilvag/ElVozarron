package co.edu.uniquindio.android.electiva.elvozarron.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import co.edu.uniquindio.android.electiva.elvozarron.R;


public class AgregarParticipanteActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_participante);

        Spinner spinner_entrenadores = (Spinner) findViewById(R.id.spinner_entrenadores);
        ArrayAdapter spinner_adapter = ArrayAdapter.createFromResource( this, R.array.profesores , android.R.layout.simple_spinner_item);
        spinner_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_entrenadores.setAdapter(spinner_adapter);

        Spinner spinner_ocupacion = (Spinner) findViewById(R.id.spinner_ocupacion);
        ArrayAdapter adapter_ocupacion = ArrayAdapter.createFromResource( this, R.array.ocupaciones , android.R.layout.simple_spinner_item);
        adapter_ocupacion.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_ocupacion.setAdapter(adapter_ocupacion);

    }

}
