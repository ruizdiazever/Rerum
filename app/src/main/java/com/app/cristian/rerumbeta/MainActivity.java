package com.app.cristian.rerumbeta;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity implements View.OnClickListener {
    Button espectaculos;
    Button talleres;
    Button descubrir;
    Button infantil;
    Button aireLibre;
    Button comida;
    // Declaramos un boton e incluimos la libreria con Alt + Enter


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_principal);

        /*DbHelper helper = new DbHelper(this);
        SQLiteDatabase db = helper.getWritableDatabase();*/
        espectaculos = (Button) findViewById (R.id.btnespectaculo);
        talleres = (Button) findViewById (R.id.btntalleres);
        descubrir = (Button) findViewById (R.id.btndescubrir);
        infantil = (Button) findViewById (R.id.btninfantil);
        aireLibre = (Button) findViewById (R.id.btnaire);
        comida = (Button) findViewById (R.id.btncomida);

        //registro.setOnClickListener(new View.OnClickListener() {
        espectaculos.setOnClickListener(this);
        talleres.setOnClickListener(this);
        descubrir.setOnClickListener(this);
        infantil.setOnClickListener(this);
        aireLibre.setOnClickListener(this);
        comida.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int Id = v.getId();
        if(v.getId() == R.id.btnaire){
            //Enlace al activity Main3Activity.class
                    //Intent inicio= new Intent (MainActivity.this, Main3Activity.class);
                    //Enlace al activity listageneral.class
            Intent Iaire = new Intent (MainActivity.this,listEventoDB.class );
            Iaire.putExtra("MainCategoria","1");
            startActivity(Iaire);
        }else if(v.getId() == R.id.btncomida){
                Intent Icomida= new Intent(MainActivity.this,listEventoDB.class );
                Icomida.putExtra("MainCategoria","6");
                //cartel.putExtra("Titulo", eventos.getItem().get(position).getTitulo());
                startActivity(Icomida);
        }else if(v.getId() == R.id.btndescubrir){
            Intent Idescubrir= new Intent(MainActivity.this,listEventoDB.class );
            Idescubrir.putExtra("MainCategoria","4");
            //cartel.putExtra("Titulo", eventos.getItem().get(position).getTitulo());
            startActivity(Idescubrir);
        }else if(v.getId() == R.id.btnespectaculo){
            Intent Iespectaculo= new Intent(MainActivity.this,listEventoDB.class );
            Iespectaculo.putExtra("MainCategoria","7");
            //cartel.putExtra("Titulo", eventos.getItem().get(position).getTitulo());
            startActivity(Iespectaculo);
        }else if(v.getId() == R.id.btninfantil){
            Intent Iinfantil= new Intent(MainActivity.this,listEventoDB.class );
            Iinfantil.putExtra("MainCategoria","5");
            //cartel.putExtra("Titulo", eventos.getItem().get(position).getTitulo());
            startActivity(Iinfantil);
        }else if(v.getId() == R.id.btntalleres){
            Intent Italleres= new Intent(MainActivity.this,listEventoDB.class );
            Italleres.putExtra("MainCategoria","3");
            //cartel.putExtra("Titulo", eventos.getItem().get(position).getTitulo());
            startActivity(Italleres);
        }else{}
    }
}
