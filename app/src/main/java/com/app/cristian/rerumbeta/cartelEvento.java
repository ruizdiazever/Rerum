package com.app.cristian.rerumbeta;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.app.cristian.rerumbeta.modelosDB.EventosDB;
import com.squareup.picasso.Picasso;

/**
 * Created by Cristian on 21/05/2017.
 */

public class cartelEvento extends Activity implements View.OnClickListener {

    Button guardarEvento;
    TextView titulo,descripcion,resumen;
    ImageView cartel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cartelevento);
        Resources res = getResources();
        //String texto = res.getString(R.string.string_html);
        String texto = getIntent().getExtras().getString("Descripcionx");
        guardarEvento = (Button)findViewById(R.id.GuardarEvento);
        titulo=(TextView)findViewById(R.id.Titulo);
        descripcion=(TextView)findViewById(R.id.descripcion);
        resumen=(TextView)findViewById(R.id.Resumen);

        //SimpleDraweeView cartel = (SimpleDraweeView)findViewById(R.id.Cartel);
        cartel=(ImageView)findViewById(R.id.Cartel);

        titulo.setText(getIntent().getExtras().getString("Titulox"));
        Picasso.with(this).load("http://disfrutemosba.buenosaires.gob.ar/imagenes/imagegallery/"+getIntent().getExtras().getString("Imagenx")).into(cartel);
        Picasso.with(this).setIndicatorsEnabled(true);
        //Uri uri = Uri.parse("http://disfrutemosba.buenosaires.gob.ar/imagenes/imagegallery/"+getIntent().getExtras().getString("Imagenx"));
        //cartel.setImageURI(uri);
        CharSequence styledText = Html.fromHtml(texto);
        descripcion.setText(styledText);
        resumen.setText(getIntent().getExtras().getString("Resumenx"));
//------------
        Toast.makeText(this, "Categoria " + getIntent().getExtras().get("Categoriax"), Toast.LENGTH_SHORT).show();
        guardarEvento.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if(id==R.id.GuardarEvento){
            String Btitulo = getIntent().getExtras().getString("Titulox");
            String Bimagen = getIntent().getExtras().getString("Imagenx");
            //Bitmap Bimagen =((BitmapDrawable)cartel.getDrawable()).getBitmap();
            String Bdescripcion = getIntent().getExtras().getString("Descripcionx");
            String Bresumen = getIntent().getExtras().getString("Resumenx");
            String Bhora = getIntent().getExtras().getString("Horax");
            String Bminutos = getIntent().getExtras().getString("Minutosx");
            String BfechaDeInicio = getIntent().getExtras().getString("FechaDeIniciox");
            String BfechaDeFinal = getIntent().getExtras().getString("FechaDeFinalx") ;
            String BfechaDePublicacion = getIntent().getExtras().getString("FechaDePublicacionx");
            String Bcategoria = getIntent().getExtras().getString("Categoriax");

    // titulo,  descripcion,  resumen,  fechaInicio,  fechaFinal,  fechaDePublicacion,  imagen,  hora,  minutos,  usuario) {
//--------------Bitmap modificado---------
            EventosDB dataEventos = new EventosDB(Btitulo,Bdescripcion,Bresumen,BfechaDeInicio,BfechaDeFinal,BfechaDePublicacion,Bimagen,Bhora,Bminutos,Bcategoria);
            dataEventos.save();

            Toast toast1;
            //toast1 = Toast.makeText(this, Long.toString(64), Toast.LENGTH_LONG);
            toast1 = Toast.makeText(this, "Evento guardado", Toast.LENGTH_SHORT);
            toast1.show();
            Intent yupiDB = new Intent(cartelEvento.this, listEventoDB.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            yupiDB.putExtra("MainCategoria",getIntent().getExtras().getString("Categoriax"));
            startActivity(yupiDB);
        }
    }
}
