package com.example.android.dosactividades;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.android.dosactividades.R.id.mensaje_principal;

public class MainActivity extends AppCompatActivity {

    int ACTIVIDAD_CALCULADORA=1234;
    String respuesta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Definimos el menú de la barra de aplicaciones
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    /**
     * Definimos la acción de compartir
     */

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        Intent intent = new Intent(Intent.ACTION_SENDTO);//Creamos el intent
        intent.setData(Uri.parse("mailto:")); //Solo aplicaciones de email
        intent.putExtra(Intent.EXTRA_SUBJECT,"Probando mi aplicación");
        intent.putExtra(Intent.EXTRA_TEXT, "Este es mi resultado: " + respuesta + "\n" + "Thank you!");
        if (intent.resolveActivity(getPackageManager())!= null){
            startActivity(intent);}
        return true;
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
            respuesta = resultadoIntent.getExtras().getString("resultado");
            principal.setText(respuesta); //Damos el resultado cambiando el string principal
            secundario.setText(R.string.infor); //Info
        }
    }

}
