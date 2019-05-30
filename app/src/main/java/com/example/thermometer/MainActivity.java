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
                            Double gCel;

                        if (gCelsius.getText().toString().trim().isEmpty() == false){
                        gCel = Double.parseDouble(gCelsius.getText().toString());

                        if (isChecked) {
//                            t.start();
                            gCel = (gCel * 9 / 5) + 32;
                            gFahren.setText(gCel.toString() + " ºF");
                        } else {
                            gFahren.setText("");
                        }
                        }
                    }
                });
        }

//        public Thread autoRefresh(){
//
//    Thread t = new Thread(){
//
//        @Override
//        public void run(){
//
//            while(!isInterrupted()){
//
//                try {
//                    Thread.sleep(1000);  //1000ms = 1 sec
//
//                    runOnUiThread(new Runnable() {
//
//                        @Override
//                        public void run() {
////                            count++;
////                            textView.setText(String.valueOf(count));
//                        }
//                    });
//
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//
//            }
//        }
//    };
//    return t;
//    }



}

