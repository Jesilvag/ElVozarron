package co.edu.uniquindio.android.electiva.elvozarron.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.Locale;

import co.edu.uniquindio.android.electiva.elvozarron.R;

/**
 * Clase que manejara la internacionalización de la aplicación
 */
public class InternacionalizacionActivity extends AppCompatActivity implements View.OnClickListener {
     private ImageButton botonEspa;
    private ImageButton botonEn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_internacionalizacion);
         botonEspa = (ImageButton) findViewById(R.id.btn_español);
        botonEspa.setOnClickListener(this);
        botonEn=(ImageButton) findViewById(R.id.btn_ingles);
        botonEn.setOnClickListener(this);
    }


    public void setLocale(String lang) {
        Locale myLocale = new Locale(lang);
        Resources res = getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        Configuration conf = res.getConfiguration();
        conf.locale = myLocale;
        res.updateConfiguration(conf, dm);
        Intent refresh = new Intent(this, InternacionalizacionActivity.class);
        startActivity(refresh);
        finish();
    }


    @Override
    public void onClick(View v) {
        if( botonEspa.getId() == v.getId()){
            String espaniol="es";
            setLocale(espaniol);
            }else if(botonEn.getId()==v.getId()){
            String ingles="en";
            setLocale(ingles);
        }else{
            Toast.makeText(this,"Error",Toast.LENGTH_SHORT).show();
        }
    }
}
