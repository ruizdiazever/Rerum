package com.app.cristian.rerumbeta;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.app.cristian.rerumbeta.modelosDB.EventosDB;

/**
 * Created by Cristian on 22/05/2017.
 */

public class cartelEventoDB extends Activity implements View.OnClickListener {
    Button eliminar;
    String ubicacionCartel;
    TextView TituloDB;
    TextView ResumenDB;
    TextView DescripcionDB;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cartelevento_db);
        TituloDB = (TextView)findViewById(R.id.TituloDB);
        ResumenDB = (TextView)findViewById(R.id.ResumenDB);
        DescripcionDB = (TextView)findViewById(R.id.DescripcionDB);
        /*String text = getResources().getString(R.string.text);;
        CharSequence styledText = Html.fromHtml(text);
        ((TextView) findViewById(R.id.outputText)).setText(styledText, TextView.BufferType.SPANNABLE);*/
        eliminar = (Button)findViewById(R.id.eliminar);


        TituloDB.setText(getIntent().getExtras().getString("TituloDB"));
        DescripcionDB.setText(getIntent().getExtras().getString("DescripcionDB"));
        ResumenDB.setText(getIntent().getExtras().getString("ResumenDB"));
        eliminar.setOnClickListener(this);
        ubicacionCartel = getIntent().getExtras().getString("CategoriaDB");

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if(id==R.id.eliminar){
            Intent yupi = new Intent(cartelEventoDB.this, listEventoDB.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            EventosDB eventof = EventosDB.findById(EventosDB.class, getIntent().getExtras().getLong("IdDB"));
            yupi.putExtra("MainCategoria",ubicacionCartel);
            //Toast.makeText(cartelEventoDB.this, "categoria " + getIntent().getExtras().getString("CategoriaDB"), Toast.LENGTH_SHORT).show();
            eventof.delete();
            startActivity(yupi);
        }
    }
}
