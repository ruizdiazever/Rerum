package com.app.cristian.rerumbeta;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.app.cristian.rerumbeta.AdapterList.CustomListDB;
import com.app.cristian.rerumbeta.modelosDB.EventosDB;
import com.orm.SugarRecord;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Cristian on 22/05/2017.
 */

public class listEventoDB extends Activity implements View.OnClickListener {
    Button nuevoEventoDB;
    String ubicacion;
    //private ArrayAdapter<UsuarioDB> mAdapter;
    private ListView lista_EventosDB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista_eventos_db);

        lista_EventosDB = (ListView)findViewById(R.id.listEventosDB);
        nuevoEventoDB = (Button)findViewById(R.id.nuevoEventoDB);

        //List<UsuarioDB> allData = SugarRecord.listAll(UsuarioDB.class);
        final List<EventosDB> allData = SugarRecord.listAll(EventosDB.class);
        final ArrayList<Long> IdDB = new ArrayList<Long>();
        final ArrayList<String> webArrayDB = new ArrayList<String>();
        ArrayList<String> imgArrayDB = new ArrayList<String>();
        final ArrayList<String> resumenArrayDB = new ArrayList<String>();
        final ArrayList<String> categoriaDB = new ArrayList<String>();
        // Boton para cambiar de actividad
        nuevoEventoDB.setOnClickListener(this);
        //-------Ubicacion---------
        ubicacion = getIntent().getExtras().getString("MainCategoria");
        //-------------------------
        for(int i=0;i < allData.size();i++){
            //allData.get(i).getCategoria().equals("6")
            if(allData.get(i).getCategoria().equals(ubicacion)){
                IdDB.add(allData.get(i).getId());
                webArrayDB.add(allData.get(i).getTitulo());
                //Picasso.with(listEventoDB.this).load("http://www.disfrutemosba.buenosaires.gob.ar/imagenes/imagegallery/4ec2-caligrafiaok.jpg").into(auxImg);
                //imgArrayDB.add(allData.get(i).getImagen());
                imgArrayDB.add(allData.get(i).getImagen());
                resumenArrayDB.add(allData.get(i).getResumen());
                categoriaDB.add(allData.get(i).getCategoria());
            }
        }
        //int i = 3;
        //allData.get(i).setCategoria("6");
        //Toast.makeText(this, "clickeaste " + allData.get(i).getCategoria(), Toast.LENGTH_SHORT).show();
        //nuevoEventoDB.setOnClickListener(this);
        CustomListDB adapterDB = new CustomListDB(listEventoDB.this, webArrayDB, imgArrayDB, resumenArrayDB);
        //List<UsuarioDB> allData = SugarRecord.listAll(UsuarioDB.class);
        //mAdapter = new ArrayAdapter<UsuarioDB>(listEventoDB.this, android.R.layout.simple_list_item_1,allData);
        lista_EventosDB.setAdapter(adapterDB);
        //mAdapter.notifyDataSetChanged();
        //mListview.setAdapter(mAdapter);
        lista_EventosDB.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(listEventoDB.this, "clickeaste " + allData.get(position).getId()+"posicion"+position, Toast.LENGTH_SHORT).show();
                Intent cartelDB= new Intent (listEventoDB.this, cartelEventoDB.class);
                //cartelDB.putExtra("IdDB",allData.get(position).getId());

                cartelDB.putExtra("IdDB",IdDB.get(position));
                cartelDB.putExtra("TituloDB",webArrayDB.get(position));
                //cartelDB.putExtra("TituloDB",allData.get(position).getTitulo());
                cartelDB.putExtra("ResumenDB",resumenArrayDB.get(position));
                cartelDB.putExtra("CategoriaDB",categoriaDB.get(position));
                //cartelDB.putExtra("ImagenDB",allData.get(position).getImagen());
                startActivity(cartelDB);
            }

        });
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();

        if(id==R.id.nuevoEventoDB){
            Intent listaGeneral = new Intent(listEventoDB.this, listaGeneral.class);
            listaGeneral.putExtra("IdCategoria",ubicacion);
            startActivity(listaGeneral);

        }
    }
}
