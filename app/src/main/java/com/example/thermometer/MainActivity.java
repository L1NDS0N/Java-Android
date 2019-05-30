package com.example.thermometer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText gCelsius;
    EditText gFahren;
    Button btnConversor;
    Switch swConversor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inicializarComponentes();
        botaoConversor();
    }

        private void inicializarComponentes(){
            gCelsius = (EditText)findViewById(R.id.etCelsius);
            gFahren = (EditText)findViewById(R.id.etFahrenheit);
            swConversor = (Switch)findViewById(R.id.swConversor);
        }

        private void botaoConversor(){

                swConversor.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                            Double gCel; // <-- Isso aqui deveria resolver, mas não resolve
                            Double res = 0.0;

                        gCel = Double.parseDouble(gCelsius.getText().toString());




                        if (isChecked) {
                            Toast.makeText(MainActivity.this, "Valor da et: " +gCel, Toast.LENGTH_LONG).show();
                            res = (gCel * 9 / 5) + 32;
                            gFahren.setText(res.toString() + " ºF");

                        } else {
                            gFahren.setText("");
                        }
                    }
                });
        }

}

