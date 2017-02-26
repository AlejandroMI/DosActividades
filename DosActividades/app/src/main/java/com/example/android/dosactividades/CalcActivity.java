package com.example.android.dosactividades;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import static android.R.attr.value;
import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;
import static android.os.Build.VERSION_CODES.M;

/**
 * Created by Alejandro on 23/02/2017.
 */

public class CalcActivity extends AppCompatActivity {

    private CharSequence textoD = ""; //Para poder guardar el texto del display, lo
    //utilizaremos para realizar el cálculo final.
    private int resultado=0; //Guardaremos el resultado final.
    public int resultadoC=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);
    }

    /**
     * Con el siguiente metodo leeremos la entrada del teclado y llamaremos a otros
     * */
    public void leerTeclado(View view) {

        TextView textoTeclado = (TextView) findViewById(view.getId());

        if (view.getId()!=R.id.tigual) {

            display(textoTeclado);

        }else{

            calculo();
        }
    }

    /**
     * Representamos la operación en el display mediante la concatenación de la entrada.
     * */

   private void display(TextView text) {

        TextView textoDisplay = (TextView)findViewById(R.id.textoDisplay); //Puntero al view display
        CharSequence textoT = text.getText(); //Cogemos el texto de la tecla pulsada. El método
                                              //leerTeclado nos habra pasado la view correspond.
        textoD = textoD.toString()+textoT; //Concatenamos el texto del display con el de la tecla
        textoDisplay.setText(textoD); //Cambiamos el texto al nuevo string

   }


    private void calculo(){

            TextView textoDisplay = (TextView)findViewById(R.id.textoDisplay); //View display
            String[] resultArray= textoD.toString().split("[+]"); //obtenemos todos los sumandos
            //Los sumamos todos
            for (int i=0; i<=resultArray.length-1; i++){

                resultado= resultado +Integer.parseInt(resultArray[i]);
            }

            //Representamos el resultado en la pantalla.
            String result = String.valueOf(resultado);
            textoDisplay.setText(result);

            //Reseteamos el display y el resultado para poder hacer una nueva suma
            textoD="";
            resultadoC=resultado; //Guardamos el resultado para compartirlo.
            resultado=0;
    }


}