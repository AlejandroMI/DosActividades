package com.example.android.dosactividades;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

/**
 * Created by Alejandro on 23/02/2017.
 */

public class CalcActivity extends AppCompatActivity {

    private CharSequence textoD = ""; //Para poder guardar el texto del display
    private int resultado; //Guardaremos el resultado final.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);
    }



    public void leerTeclado(View view) {

        TextView textoTeclado = (TextView) findViewById(view.getId());
        display(textoTeclado);

        switch (view.getId()) {

            case R.id.t7: /** Se ha pulsado la tecla 7 */
                break;
            case R.id.t8: /** Se ha pulsado la tecla 8 */
                break;
            case R.id.t9: /** Se ha pulsado la tecla 9 */
                break;
            case R.id.t4: /** Se ha pulsado la tecla 4 */
                break;
            case R.id.t5: /** Se ha pulsado la tecla 5 */
                break;
            case R.id.t6: /** Se ha pulsado la tecla 6 */
                break;
            case R.id.t1: /** Se ha pulsado la tecla 1 */
                break;
            case R.id.t2: /** Se ha pulsado la tecla 2 */
                break;
            case R.id.t3: /** Se ha pulsado la tecla 3 */
                break;
            case R.id.tsuma: /** Se ha pulsado la tecla + */
                break;
            case R.id.t0: /** Se ha pulsado la tecla 0 */
                break;
            case R.id.tigual: /** Se ha pulsado la tecla = */
                break;
        }
    }

   private void display(TextView text) {

        TextView textoDisplay = (TextView)findViewById(R.id.textoDisplay); //Puntero al display
        CharSequence textoT = text.getText(); //Cogemos el texto de la tecla pulsada
        textoD = textoD.toString() +textoT; //Concatenamos el texto del display con el de la tecla
        textoDisplay.setText(textoD); //Cambiamos el texto al nuevo string

   }


    private void calculo(int entrada){


    }

}