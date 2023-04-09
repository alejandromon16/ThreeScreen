package com.example.listas.LogIn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.listas.Lista.Lista;
import com.example.listas.MainActivity;
import com.example.listas.R;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LogIn extends AppCompatActivity {

    EditText Email;
    Button btnLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        Email = findViewById(R.id.EmailAddress);
        btnLogin = findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String correoElectronico = Email.getText().toString();
                // Crear un patrón para verificar la validez del correo electrónico
                Pattern pattern = Pattern.compile("[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+");
                // Verificar si el correo electrónico ingresado coincide con el patrón
                Matcher matcher = pattern.matcher(correoElectronico);
                if (!matcher.matches()) {
                    // Mostrar un mensaje de error al usuario
                    Toast.makeText(LogIn.this, "El correo electrónico ingresado es inválido", Toast.LENGTH_SHORT).show();
                    return;
                }
                else {
                    Intent intent = new Intent(LogIn.this, MainActivity.class);
                    startActivity(intent);
                }
            }
        });
        //Aqui acaba el boton
    }
}