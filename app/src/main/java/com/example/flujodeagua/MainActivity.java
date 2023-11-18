package com.example.flujodeagua;


import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.ArrayMap;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    EditText usuario;
    EditText contraseña;
    Button loginButton;
    ArrayMap usuarios = new ArrayMap();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        usuarios.put("rosendo","1234");
        usuarios.put("angel","1234");
        usuarios.put("abraham","1234");
        usuarios.put("brayan","1234");
        setContentView(R.layout.login);


        usuario = findViewById(R.id.usuario);
        contraseña = findViewById(R.id.contraseña);
        loginButton = findViewById(R.id.loginBtn);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });

    }


    public void login(){
        Object usuarioLogin = usuarios.get(usuario.getText().toString());
        if(usuarioLogin == null || !usuarioLogin.equals(contraseña.getText().toString())){
            Toast.makeText(getApplicationContext(), "Usuario y/o contraseña incorrectos", Toast.LENGTH_SHORT).show();
            return;
        }

        Intent i = new Intent(MainActivity.this, GrafanaActivity.class);
        MainActivity.this.startActivity(i);
    }

}