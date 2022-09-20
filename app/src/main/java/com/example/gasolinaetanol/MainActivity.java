package com.example.gasolinaetanol;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Setar a área de conteúdo
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.button);
        TextView resultado = (TextView) findViewById(R.id.resultado);
        EditText gasolina = (EditText) findViewById(R.id.gasolina);
        EditText alcool = (EditText) findViewById(R.id.alcool);
        EditText litros = (EditText) findViewById(R.id.litros);



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Transformar os dados em double
                double var_gasolina = Double.parseDouble(gasolina.getText().toString() );
                double var_alcool = Double.parseDouble(alcool.getText().toString() );
                double var_litros = Double.parseDouble(litros.getText().toString() );

                //Calcular IMC
                double calculo = (var_alcool / var_gasolina);
                double valor;
                String msgImc;

                if (calculo <= 0.7){
                    valor = var_alcool * var_litros;
                    msgImc = "COMPENSA ETANOL, VOCÊ IRÁ GASTAR R$"+ String.format("%.2f", valor);


                }else{
                    valor = var_gasolina * var_litros;
                    msgImc = "COMPENSA GASOLINA, VOCÊ IRÁ GASTAR R$"+ String.format("%.2f", valor);
                }

                resultado.setText(msgImc);


                Context context = getApplicationContext();
                CharSequence text = String.valueOf(button);
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();


            }
        });




    }
}