package com.app.cristian.rerumbeta;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Bienvenida extends AppCompatActivity {
    Button botonsesion;
    Button botonregistro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bienvenida);

        botonsesion = (Button) findViewById(R.id.btninicio);
        botonsesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Bienvenida.this, LoginActivity.class);
                startActivity(i);
            }
        });

        botonregistro = (Button) findViewById(R.id.elliot2);
        botonregistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Bienvenida.this, Activity_Registro.class);
                startActivity(i);
            }
        });
    }
}
