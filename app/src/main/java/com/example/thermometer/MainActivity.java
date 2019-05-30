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

        gCelsius = (EditText)findViewById(R.id.etCelsius);
        gFahren = (EditText)findViewById(R.id.etFahrenheit);

        swConversor = (Switch)findViewById(R.id.swConversor);

                if (gCelsius != null){
        swConversor.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Double gCel;
                Boolean btnCon;
                gCel = Double.parseDouble(gCelsius.getText().toString());
                btnCon = Boolean.parseBoolean(swConversor.getText().toString());

                if (isChecked){

                    gFahren.setText(gCel.toString()+"F");

                } else {
                gFahren.setText("");
                }


            }
        });

            }
    }
}
