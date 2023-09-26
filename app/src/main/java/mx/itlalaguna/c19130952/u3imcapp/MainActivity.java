/*------------------------------------------------------------------------------------------
:*                         TECNOLOGICO NACIONAL DE MEXICO
:*                                CAMPUS LA LAGUNA
:*                     INGENIERIA EN SISTEMAS COMPUTACIONALES
:*                             DESARROLLO EN ANDROID "A"
:*
:*                   SEMESTRE: ENE-JUN/2023    HORA: 08-09 HRS
:*
:*                       Activity principal de la app imc
:*
:*  Archivo     : MainActivity.java
:*  Autor       : Cesar Alexis Ochoa Tapia     19130952
:*  Fecha       : 03/Mar/2023
:*  Compilador  : Android Studio Electric Eel 2022.1
:*  Descripcion : Este activity despliega la pantalla principal para leer
                  el peso y estatura de la persona y calcula su indice de
                  Masa corporal, ademas determina su condicion de salud y tambien nos muestra
                  las etiquetas como variables traducidas dependiendo del idioma.
:*  Ultima modif:
:*  Fecha       Modific              Motivo
:*==========================================================================================
:*
:*------------------------------------------------------------------------------------------*/
package mx.itlalaguna.c19130952.u3imcapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
//-----------------------------------------------------------
    private EditText edtPeso;
    private EditText edtEstatura;
    //-----------------------------------------------------------
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //obtener las referencias a los edittext del layout
        edtPeso = findViewById(R.id.edtPeso);
        edtEstatura = findViewById(R.id.edtEstatura);

    }
    //-----------------------------------------------------------
    public void btnCalcularIMCClick(View v){

                         DecimalFormat decimalFormat = new DecimalFormat("##.##");
                         if(edtPeso.getText().toString().isEmpty() && edtEstatura.getText().toString().isEmpty()){
                             mostrarToast((String) getText(R.string.campos));
                         }
                         else if(edtPeso.getText().toString().isEmpty()){
                             mostrarToast((String) getText(R.string.pesoVacio));
                         }
                         else if(edtEstatura.getText().toString().isEmpty()){
                             mostrarToast((String) getText(R.string.estaturaVacia));
                         }
                         else {
                             double peso = Double.parseDouble(edtPeso.getText().toString());
                             double estatura = Double.parseDouble(edtEstatura.getText().toString());

                             double imc = peso / (estatura * estatura);

                             String condicion = getString(R.string.condicion_salud);
                             String IMC = getString(R.string.IMC);
                             //VERSION DE INFORMACION USANDO LOS TOAST-------------------------------------------
                        /*
     //-----------------------------------------------------------
                        String condicion = getString(R.string.condicion_salud);
                        String IMC = getString(R.string.IMC);
                        if(imc < 15.0) {
                            condicion += getString(R.string.delgadez_MSevera);
                            mostrarToast("IMC = "+ decimalFormat.format(imc)+ "\n"+ condicion );

                        }
                        else if (imc >= 15.0 && imc <= 15.9){
                            condicion += getString(R.string.delgadez_Severa);
                            mostrarToast("IMC = "+decimalFormat.format(imc)+ "\n"+condicion);

                        }
                        else if (imc >= 16.0 && imc <= 18.4){
                            condicion += getString(R.string.Delgadez);
                            mostrarToast("IMC = "+decimalFormat.format(imc)+ "\n"+condicion);

                        }
                        else if (imc >= 18.5 && imc <= 24.9){
                            condicion += getString(R.string.Peso_Saludable);
                            mostrarToast("IMC = "+decimalFormat.format(imc)+ "\n"+condicion);

                        }

                        else if (imc >= 25 && imc <= 29.9){
                            condicion += getString(R.string.sobrepeso);
                            mostrarToast("IMC = "+decimalFormat.format(imc)+ "\n"+condicion);
                        }
                        else if (imc >= 30 && imc <= 34.9){
                            condicion += getString(R.string.Obesidad_Moderada);
                            mostrarToast("IMC = "+decimalFormat.format(imc)+ "\n"+condicion);
                        }
                        else if (imc >= 35 && imc <= 39.9){
                            condicion += getString(R.string.Obesidad_Severa);
                            mostrarToast("IMC = "+decimalFormat.format(imc)+ "\n"+condicion);
                        }
                        else if (imc >= 40){
                            condicion += getString(R.string.Obesidad_MSevera);
                            mostrarToast("IMC = "+decimalFormat.format(imc)+ "\n"+condicion);
                        }
                        */
                             // android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);

//VERSION DE INFORMACION USANDO LOS ALERT DIALOG-------------------------------------------
// ----------------------------------------------------------------------------------------------


                             if (imc < 15.0) {
                                 condicion += getString(R.string.delgadez_MSevera);
                                 AlertaDialog(imc, condicion);

                             } else if (imc >= 15.0 && imc <= 15.9) {
                                 condicion += getString(R.string.delgadez_Severa);
                                 AlertaDialog(imc, condicion);

                             } else if (imc >= 16.0 && imc <= 18.4) {
                                 condicion += getString(R.string.Delgadez);
                                 AlertaDialog(imc, condicion);

                             } else if (imc >= 18.5 && imc <= 24.9) {
                                 condicion += getString(R.string.Peso_Saludable);
                                 AlertaDialog(imc, condicion);

                             } else if (imc >= 25 && imc <= 29.9) {
                                 condicion += getString(R.string.sobrepeso);
                                 AlertaDialog(imc, condicion);
                             } else if (imc >= 30 && imc <= 34.9) {
                                 condicion += getString(R.string.Obesidad_Moderada);
                                 AlertaDialog(imc, condicion);
                             } else if (imc >= 35 && imc <= 39.9) {
                                 condicion += getString(R.string.Obesidad_Severa);
                                 AlertaDialog(imc, condicion);
                             } else if (imc >= 40) {
                                 condicion += getString(R.string.Obesidad_MSevera);
                                 AlertaDialog(imc, condicion);
                             }
                         }

    }
    // ----------------------------------------------------------------------------------------------
    public void AlertaDialog(double imc,String condicion){
        DecimalFormat decimalFormat = new DecimalFormat("##.##");
        String IMC = getString(R.string.IMC);
        String aceptar = getString(R.string.Aceptar);
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);
            builder.setTitle(IMC)
                    .setMessage(IMC + ": " + decimalFormat.format(imc) + "\n" + condicion)
                    .setPositiveButton(aceptar,
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    mostrarToast("Clic "+aceptar);
                                    dialogInterface.dismiss();
                                }
                            })
                    .create()
                    .show();
    }
    //-----------------------------------------------------------
    public void btnAcercaDeClick(View v){
    //mostar alert dialog con los datos de la app y del autor
        //que incluya el logo del tec
        LinearLayout layout = (LinearLayout) this.getLayoutInflater().inflate(R.layout.activity_acerca_de, null);


        android.app.AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(layout)
                .setPositiveButton(R.string.Aceptar, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {


                        mostrarToast("OK");
                        dialogInterface.dismiss();

                    }
                })

                .create()
                .show();

    }
    //-----------------------------------------------------------

    public void ocultarTeclado(View v)
    {
        View vista = getCurrentFocus();
        if ( vista != null ) {
            InputMethodManager imm = (InputMethodManager) getSystemService(
                    Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(vista.getWindowToken(),
                    InputMethodManager.HIDE_NOT_ALWAYS);
        }
        }
    public void mostrarToast(String mensaje){
        Toast.makeText(this,mensaje,Toast.LENGTH_LONG).show();
    }

}