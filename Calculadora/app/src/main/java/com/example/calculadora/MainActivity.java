package com.example.calculadora;

import android.graphics.Color;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.view.View.OnClickListener;

public class MainActivity extends Activity {
    EditText pantalla;
    int tamLetra = 40;

    Button [] botones = new Button[16];

    Double num1, num2;
    int operacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LinearLayout principal = new LinearLayout(this);
        principal.setOrientation(LinearLayout.VERTICAL);
        principal.setPadding(20, 30, 20, 30);
        principal.setBackgroundColor(Color.GRAY);

        TextView lblNombre = new TextView(this);
        lblNombre.setText("Paulo Cesar Ramirez Ramirez");
        lblNombre.setTextSize(18);
        lblNombre.setTextColor(Color.WHITE);
        lblNombre.setPadding(0, 0, 0, 15);
        principal.addView(lblNombre);

        pantalla = new EditText(this);
        pantalla.setTextSize(tamLetra);
        pantalla.setBackgroundColor(Color.WHITE);
        principal.addView(pantalla);

        LinearLayout l1 = new LinearLayout(this);
        l1.setOrientation(LinearLayout.HORIZONTAL);
        l1.setBackgroundColor(Color.BLACK);

        LinearLayout l2 = new LinearLayout(this);
        l2.setOrientation(LinearLayout.HORIZONTAL);
        l2.setBackgroundColor(Color.RED);

        LinearLayout l3 = new LinearLayout(this);
        l3.setOrientation(LinearLayout.HORIZONTAL);
        l3.setBackgroundColor(Color.BLACK);

        LinearLayout l4 = new LinearLayout(this);
        l4.setOrientation(LinearLayout.HORIZONTAL);
        l4.setBackgroundColor(Color.RED);

        int i = 0;
        for(i = 0; i <= 9; i++){
            botones[i] = new Button(this);
            botones[i].setText(String.valueOf(i));
            botones[i].setTextSize(tamLetra);
            botones[i].setOnClickListener(new OnClickListener(){
                public void onClick(View v){
                    String textoBoton = ((Button)v).getText().toString();
                    pantalla.setText(pantalla.getText() + textoBoton);
                }
            });
        }

        botones[10] = new Button(this);
        botones[10].setText(".");
        botones[10].setTextSize(tamLetra);
        botones[10].setOnClickListener(new OnClickListener(){
            public void onClick(View v){
                pantalla.setText(pantalla.getText() + ".");
            }
        });
        l4.addView(botones[10]);

        for (int j = 0; j <= 9; j++){
            switch (j){
                case 1:
                case 2:
                case 3:
                    l3.addView(botones[j]);
                    break;
                case 4:
                case 5:
                case 6:
                    l2.addView(botones[j]);
                    break;
                case 7:
                case 8:
                case 9:
                    l1.addView(botones[j]);
                    break;
                case 0:
                    l4.addView(botones[j]);
                    break;
            }
        }

        botones[11] = new Button(this);
        botones[11].setText("+");
        botones[11].setTextSize(tamLetra);
        botones[11].setOnClickListener(new OnClickListener(){
            public void onClick(View v){
                num1 = Double.parseDouble(pantalla.getText().toString());
                operacion = 1;
                pantalla.setText("");
            }
        });
        l1.addView(botones[11]);

        botones[13] = new Button(this);
        botones[13].setText("-");
        botones[13].setTextSize(tamLetra);
        botones[13].setOnClickListener(new OnClickListener(){
            public void onClick(View v){
                num1 = Double.parseDouble(pantalla.getText().toString());
                operacion = 2;
                pantalla.setText("");
            }
        });
        l2.addView(botones[13]);

        botones[14] = new Button(this);
        botones[14].setText("*");
        botones[14].setTextSize(tamLetra);
        botones[14].setOnClickListener(new OnClickListener(){
            public void onClick(View v){
                num1 = Double.parseDouble(pantalla.getText().toString());
                operacion = 3;
                pantalla.setText("");
            }
        });
        l3.addView(botones[14]);

        botones[15] = new Button(this);
        botones[15].setText("/");
        botones[15].setTextSize(tamLetra);
        botones[15].setOnClickListener(new OnClickListener(){
            public void onClick(View v){
                num1 = Double.parseDouble(pantalla.getText().toString());
                operacion = 4;
                pantalla.setText("");
            }
        });
        l4.addView(botones[15]);

        botones[12] = new Button(this);
        botones[12].setText("=");
        botones[12].setTextSize(tamLetra);
        botones[12].setOnClickListener(new OnClickListener(){
            public void onClick(View v){
                num2 = Double.parseDouble(pantalla.getText().toString());
                double res = 0;

                switch(operacion){
                    case 1: res = num1 + num2; break;
                    case 2: res = num1 - num2; break;
                    case 3: res = num1 * num2; break;
                    case 4:
                        if(num2 != 0) {
                            res = num1 / num2;
                        } else {
                            res = 0;
                        }
                        break;
                }
                pantalla.setText("" + res);
            }
        });
        l4.addView(botones[12]);

        principal.addView(l1);
        principal.addView(l2);
        principal.addView(l3);
        principal.addView(l4);
        setContentView(principal);
    }
}