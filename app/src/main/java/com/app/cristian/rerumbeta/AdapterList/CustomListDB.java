package com.app.cristian.rerumbeta.AdapterList;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.cristian.rerumbeta.R;
import com.app.cristian.rerumbeta.listEventoDB;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Cristian on 22/05/2017.
 */

public class CustomListDB extends ArrayAdapter<String> {

    private final Activity context;
    private final ArrayList<String> webDB;//Titulo
    private final ArrayList<String> imageIdDB;
    private final ArrayList<String> resumenArrayDB;
  /*   private final ArrayList<String> descripcionDB;
    private final ArrayList<String> fechaDeInicioDB;
    private final ArrayList<String> fechaDeFinalDB;
    private final ArrayList<String> fechaDePublicacionDB;
    private final ArrayList<String> horaDB;
    private final ArrayList<String> minutosDB;
    private final ArrayList<UsuarioDB> usuarioDB;
*/

/*    public CustomListDB(listaGeneral context
                     ,ArrayList<String> webDB, ArrayList<String> imageIdDB, ArrayList<String> resumenArrayDB
                     ,ArrayList<String> descripcionDB,ArrayList<String> fechaDeInicioDB,ArrayList<String> fechaDeFinalDB
                     ,ArrayList<String> fechaDePublicacionDB,ArrayList<String> horaDB
                     ,ArrayList<String> minutosDB,ArrayList<UsuarioDB> usuarioDB) {
        super(context, R.layout.list_group, webDB);
        this.context = context;
        this.webDB = webDB;
        this.imageIdDB = imageIdDB;
        this.resumenArrayDB = resumenArrayDB;
        this.descripcionDB = descripcionDB;
        this.fechaDeInicioDB = fechaDeInicioDB;
        this.fechaDeFinalDB = fechaDeFinalDB;
        this.fechaDePublicacionDB = fechaDePublicacionDB;
        this.horaDB = horaDB;
        this.minutosDB = minutosDB;
        this.usuarioDB = usuarioDB;
    }
*/
    public CustomListDB(listEventoDB context
            , ArrayList<String> webDB, ArrayList<String> imageIdDB, ArrayList<String> resumenArrayDB) {
        super(context, R.layout.lista_eventos_db_group, webDB);
        this.context = context;
        this.webDB = webDB;
        this.imageIdDB = imageIdDB;
        this.resumenArrayDB = resumenArrayDB;
    }
    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflaterDB = context.getLayoutInflater();
        View rowViewDB= inflaterDB.inflate(R.layout.lista_eventos_db_group, null, true);
        TextView txtTituloDB = (TextView) rowViewDB.findViewById(R.id.txtViewDB);
        TextView txtResumenDB = (TextView) rowViewDB.findViewById(R.id.txtResumenDB);
        ImageView imageViewDB = (ImageView) rowViewDB.findViewById(R.id.imgViewDB);
        //SimpleDraweeView imageViewDB = (SimpleDraweeView) rowViewDB.findViewById(R.id.imgViewDB);
        txtTituloDB.setText(webDB.get(position));
        txtResumenDB.setText(resumenArrayDB.get(position));

        Picasso.with(context).load("http://disfrutemosba.buenosaires.gob.ar/imagenes/imagegallery/"+imageIdDB.get(position)).into(imageViewDB);
        //Uri uri = Uri.parse("http://disfrutemosba.buenosaires.gob.ar/imagenes/imagegallery/"+imageIdDB.get(position));
        //imageViewDB.setImageURI(uri);

        return rowViewDB;
    }
}
