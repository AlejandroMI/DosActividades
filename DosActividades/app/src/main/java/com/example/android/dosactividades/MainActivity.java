package com.example.android.dosactividades;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import static com.example.android.dosactividades.R.id.mensaje_principal;

public class MainActivity extends AppCompatActivity {

    int ACTIVIDAD_CALCULADORA=1234;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    /**
     * Escuchamos al botón calculadora
     */
    public void botonCalculadora(View view){
        irCalculadora();
    }

    /**
      * Con este método llamaremos a la aplicación de la calculadora.
     */
    private void irCalculadora(){

        Intent intencion=new Intent(this,CalcActivity.class);
        //Evitamos crash si no hay respuesta.
        if (intencion.resolveActivity(getPackageManager())!= null){
            startActivityForResult(intencion, ACTIVIDAD_CALCULADORA);
        }
    }

    /**
     * Recuperamos los datos que nos envie la calculadora y modificamos
     * */

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent resultadoIntent)
    {

        TextView principal = (TextView) findViewById(R.id.mensaje_principal);
        TextView secundario = (TextView) findViewById(R.id.mensaje_secundario);

        if (resultCode == Activity.RESULT_OK && requestCode == ACTIVIDAD_CALCULADORA) {
            String respuesta = resultadoIntent.getExtras().getString("resultado");
            principal.setText(respuesta); //Damos el resultado cambiando el string principal
            secundario.setText(R.string.infor); //Info
        }
    }

}
