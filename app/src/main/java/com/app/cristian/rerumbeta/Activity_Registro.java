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

public class Activity_Registro extends AppCompatActivity {
    Button btnregistro;
    EditText password1, password2, usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        btnregistro = (Button)findViewById(R.id.buttonregistro);
        btnregistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent i = new Intent(Activity_Registro.this, MainActivity.class);
                //startActivity(i);
                String pass1 = password1.getText().toString();
                String pass2 = password2.getText().toString();
                String email = usuario.getText().toString();

                //   ||   esto o lo otro..... esto || esto
                //   &&   esto y lo otro ..... esto && esto
                if(pass1.equalsIgnoreCase("") || (pass2.equalsIgnoreCase("")) || (email.equalsIgnoreCase("")) ){
                    if (pass1.equalsIgnoreCase("")) {
                        YoYo.with(Techniques.Tada)
                                .duration(700)
                                //.repeat(5)
                                .playOn(password1);

                    }
                    if (pass2.equalsIgnoreCase("")) {
                        YoYo.with(Techniques.Tada)
                                .duration(700)
                                //.repeat(5)
                                .playOn(password2);
                    }
                    if (email.equalsIgnoreCase("")){
                        YoYo.with(Techniques.Tada)
                                .duration(700)
                                //.repeat(5)
                                .playOn(usuario);
                    }
                }
                else {
                    HashMap <String,String> params = new HashMap <String, String>();
                    //Nombre palabra & definicion, como un diccionario.. String (Palabra) String (Definicion)

                    //Sobre o paquete que lleva mis datos al servidor
                    params.put("email", email);
                    params.put("password1", pass1);
                    params.put("password2", pass2);

                    Call<User> registrarse = RetrofitAPIService.getInstance().registrarse(params);

                    registrarse.enqueue(new Callback<User>() {
                        @Override
                        public void onResponse(Call<User> call, Response<User> response) {
                            //Caer aca significa que el servidor me respondio, no que el usuario es valido
                            if(response.body() != null){
                                Intent i = new Intent(Activity_Registro.this, MainActivity.class);
                                startActivity(i);
                            }
                        }

                        @Override
                        public void onFailure(Call<User> call, Throwable t) {
                            Toast.makeText(Activity_Registro.this,"No hay conexión :(", Toast.LENGTH_SHORT).show();
                            Intent i = new Intent(Activity_Registro.this, MainActivity.class);
                            startActivity(i);
                        }
                    });
                }

            }
        });

        password1 = (EditText) findViewById(R.id.editTextpass);

        password2 = (EditText) findViewById(R.id.editTextpass2);

        usuario =(EditText) findViewById(R.id.editTextemail);
    }

}
