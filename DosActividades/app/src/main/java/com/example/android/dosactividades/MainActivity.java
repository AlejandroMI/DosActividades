package com.example.android.dosactividades;

import android.app.ActionBar;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

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
        super.startActivityForResult(intencion, 1234);

        //Evitamos crash si no hay respuesta.
        if (intencion.resolveActivity(getPackageManager())!= null){
            startActivity(intencion);
        }
    }

}
