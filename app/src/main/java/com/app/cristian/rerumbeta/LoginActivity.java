package com.app.cristian.rerumbeta;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.app.cristian.rerumbeta.modelos.User;
import com.app.cristian.rerumbeta.network.RetrofitAPIService;
import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {


    Button IniciarSesion;
    EditText EditTextEmail;
    EditText EditTextContrasena;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sesion);

        IniciarSesion = (Button) findViewById(R.id.button2);
        IniciarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Email = EditTextEmail.getText().toString();
                //
                Toast.makeText(LoginActivity.this, Email, Toast.LENGTH_LONG).show();
                //

                String Contrasena = EditTextContrasena.getText().toString();

                Toast.makeText(LoginActivity.this, Contrasena, Toast.LENGTH_LONG).show();

                if (Email.equalsIgnoreCase("") || Contrasena.equalsIgnoreCase("")) {

                    if (Email.equalsIgnoreCase("")) {
                        YoYo.with(Techniques.Tada)
                                .duration(700)
                                //.repeat(5)
                                .playOn(EditTextEmail);

                    }
                    if (Contrasena.equalsIgnoreCase("")) {
                        YoYo.with(Techniques.Tada)
                                .duration(700)
                                //.repeat(5)
                                .playOn(EditTextContrasena);
                    }
                }
                else{
                    // este bloque nos valida que User && Pass no esten vacios
                    HashMap<String, String> params = new HashMap<String, String>();

                    //Sobre o paquete que lleva mis datos al servidor
                    params.put("email", Email);
                    params.put("password", Contrasena);

                    Call<User> logguearse = RetrofitAPIService.getInstance().logguearse(params);

                    logguearse.enqueue(new Callback<User>() {
                        @Override
                        public void onResponse(Call<User> call, Response<User> response) {
                            //Caer aca significa que el servidor me respondio, no que el usuario es valido
                            if(response.body() != null){
                                Intent i = new Intent(LoginActivity.this, MainActivity.class);
                                startActivity(i);
                            }
                        }

                        @Override
                        public void onFailure(Call<User> call, Throwable t) {
                            Toast.makeText(LoginActivity.this,"No hay conexión :(", Toast.LENGTH_SHORT).show();
                            Intent i = new Intent(LoginActivity.this, MainActivity.class);
                            startActivity(i);
                        }
                    });
                }
            }

        });


        EditTextEmail   =   (EditText)  findViewById(R.id.editText);
        EditTextContrasena  =   (EditText)  findViewById(R.id.editText2);
        //R es como un diccionario & punto "." es para mostrar las acciones del mismo
    }
}
