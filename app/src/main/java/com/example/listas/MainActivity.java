package com.example.listas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ComponentActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.media.Image;
import android.os.Bundle;
import android.os.Handler;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.listas.Lista.Lista;
import com.google.android.material.button.MaterialButton;

import java.util.Arrays;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button btnApertura;
    Button btnChecked;
    CheckBox checkBox;
    ImageView imgBounce;
    Button btnImageMove;
    Button btnRandom;
    ImageView imgRandom;

    EditText txtCapricua;

    TextView resultado;
    Button Comprobar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Aqui Definimos las Partes
        btnApertura = findViewById(R.id.btnApertura);
        btnChecked = findViewById(R.id.btnChecked);
        btnImageMove = findViewById(R.id.btnImageMove);
        btnChecked.setEnabled(false);
        checkBox = findViewById(R.id.checkBox);
        imgBounce = findViewById(R.id.imgBounce);
        btnRandom = findViewById(R.id.btnRandom);
        imgRandom = findViewById(R.id.imgRandom);
        txtCapricua = findViewById(R.id.txtCapricua);
        resultado = findViewById(R.id.resultado);
        Comprobar = findViewById(R.id.btnComprobar);
        //Para Abrir la Lista
        btnApertura.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Lista.class);
                startActivity(intent);
            }
        });
        //Para el CheckBox
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            public void onCheckedChanged (CompoundButton buttonView, boolean isCheecked){
                if (isCheecked){
                    btnChecked.setEnabled(true);
                }
                else{
                    btnChecked.setEnabled(false);
                }
            }
        });
        btnChecked.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"Felicidades le haz hecho click", Toast.LENGTH_SHORT).show();
            }
        });
        //Movimiento de la Imagen
        btnImageMove.setOnClickListener(new View.OnClickListener() {
            int increment = 50;
            @Override
            public void onClick(View v) {
                int screenWidth = getResources().getDisplayMetrics().widthPixels;
                int imageViewWidth = imgBounce.getWidth();
                int maxPosition = screenWidth - imageViewWidth;

                float currentPosition = imgBounce.getX();
                float newPosition = currentPosition + 50;

                if (newPosition > maxPosition) {
                    newPosition = maxPosition;
                    increment = -50;
                } else if (currentPosition <= 0) {
                    increment = 50;
                }
                imgBounce.setX(newPosition);
                float newPositionAfterBounce = currentPosition + increment;

                if (newPositionAfterBounce < 0) {
                    newPositionAfterBounce = 0;
                    increment = 50;
                }
                imgBounce.setX(newPositionAfterBounce);
            }
        });
        //Imagen Aleatoria
        btnRandom.setOnClickListener(new View.OnClickListener() {
            int [] ImageArray = {R.drawable.img_2,R.drawable.gato,R.drawable.jojo,R.drawable.avengers,R.drawable.oso,R.drawable.truman};
            @Override
            public void onClick(View view) {
                int randomIndex = new Random().nextInt(ImageArray.length);
                imgRandom.setImageResource(ImageArray[randomIndex]);
            }
        });
        //Comprobar si es Capricua
        Comprobar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String numberString = txtCapricua.getText().toString();
                int number = Integer.parseInt(numberString);

                int reverseNumber = 0;
                int remainder;

                int originalNumber = number;

                while (number != 0) {
                    remainder = number % 10;
                    reverseNumber = reverseNumber * 10 + remainder;
                    number = number / 10;
                }

                if (originalNumber == reverseNumber) {
                    resultado.setText(originalNumber + " Es Capricua.");
                } else {
                    resultado.setText(originalNumber + " No es Capricua.");
                }
            }
        });

    }
}