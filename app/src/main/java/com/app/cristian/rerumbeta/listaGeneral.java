package com.app.cristian.rerumbeta;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.app.cristian.rerumbeta.AdapterList.CustomList;
import com.app.cristian.rerumbeta.modelos.Items;
import com.app.cristian.rerumbeta.network.RerunAPI;
import com.app.cristian.rerumbeta.network.RetrofitAPIService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Cristian on 15/05/2017.
 */

public class listaGeneral extends Activity {

   ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listageneral);

        list=(ListView)findViewById(R.id.list);
        //ImageView auxImg =(ImageView)findViewById(R.id.imgView);



        RerunAPI retrofit = RetrofitAPIService.getInstance();
        //------------------Map-----------------------
        Map<String, String> params = new HashMap<String, String>();
        params.put("OrdenarPor","FechaPublicacionDesde");
        //params.put("IdCategories","6");
        params.put("IdCategories",getIntent().getExtras().getString("IdCategoria"));
        params.put("Orden","DESC");
        params.put("Limit","10");
        //--------------------------------------------

        //Call <Items> pedirDatosAlGob = retrofit.pedirDatos(params.get("FechaPublicacionDesde"), "2");
        Call <Items> pedirDatosAlGob = retrofit.pedirDatosC(params.get("IdCategories"),params.get("OrdenarPor"),params.get("Orden"),params.get("Limit"));


        //Toast.makeText(this,"HICE CLICK"+getIntent().getExtras().getString("IdCategoria"), Toast.LENGTH_SHORT).show();

        pedirDatosAlGob.enqueue(new Callback<Items>() {
            @Override
            public void onResponse(Call<Items> call, Response<Items> response) {
                Toast.makeText(listaGeneral.this, "Cargando eventos", Toast.LENGTH_SHORT).show();
                final Items eventos = response.body();

                ArrayList<String> tituloArray = new ArrayList<String>();
                ArrayList<String> imgArray = new ArrayList<String>();
                ArrayList<String> resumenArray = new ArrayList<String>();

                for (int i = 0; i < eventos.getItem().size(); i++) {
                    tituloArray.add(eventos.getItem().get(i).getTitulo());
                    //Picasso.with(listaGeneral.this).load("http://www.disfrutemosba.buenosaires.gob.ar/imagenes/imagegallery/4ec2-caligrafiaok.jpg").into(auxImg);
                    imgArray.add(eventos.getItem().get(i).getImagen());
                    resumenArray.add(eventos.getItem().get(i).getResumen());
                }

                CustomList adapter = new CustomList(listaGeneral.this, tituloArray, imgArray, resumenArray);
                list.setAdapter(adapter);
                list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                        //Toast.makeText(listaGeneral.this, "You Clicked at " + position, Toast.LENGTH_SHORT).show();
                        Intent cartel = new Intent(listaGeneral.this, cartelEvento.class);

                        cartel.putExtra("Titulox", eventos.getItem().get(position).getTitulo());
                        cartel.putExtra("Resumenx", eventos.getItem().get(position).getResumen());
                        cartel.putExtra("Imagenx", eventos.getItem().get(position).getImagen());
                        cartel.putExtra("Descripcionx", eventos.getItem().get(position).getDescripcion());
                        cartel.putExtra("Horax", eventos.getItem().get(position).getHora());
                        cartel.putExtra("Minutosx", eventos.getItem().get(position).getMinutos());
                        cartel.putExtra("FechaDeIniciox", eventos.getItem().get(position).getFechaInicio());
                        cartel.putExtra("FechaDeFinalx", eventos.getItem().get(position).getFechaFin());
                        cartel.putExtra("FechaDePublicacionx", eventos.getItem().get(position).getFechaProximoEventoDesde());
                        cartel.putExtra("Categoriax", eventos.getItem().get(position).getIdCategorias());

                        //Recolector de basura :)
                        System.gc();
                        startActivity(cartel);
                    }

                });
            }

            @Override
            public void onFailure(Call<Items> call, Throwable t) {
                Toast.makeText(listaGeneral.this,"No hay conexión :(", Toast.LENGTH_SHORT).show();
            }
        });


    }

}
