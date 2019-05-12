package com.app.cristian.rerumbeta.AdapterList;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.cristian.rerumbeta.R;
import com.app.cristian.rerumbeta.listaGeneral;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;


/**
 * Created by Cristian on 17/05/2017.
 */

public class CustomList extends ArrayAdapter<String> {

    Activity context;
    ArrayList<String> tituloArray;
    ArrayList<String> urlImageArray;
    ArrayList<String> resumenArray;

    public CustomList(listaGeneral context,
                      ArrayList<String> tituloArray, ArrayList<String> urlImageArray, ArrayList<String> resumenArray) {
        super(context, R.layout.list_group, tituloArray);
        Fresco.initialize(context);
        this.context = context;
        this.tituloArray = tituloArray;
        this.urlImageArray = urlImageArray;
        this.resumenArray = resumenArray;

    }
    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView= inflater.inflate(R.layout.list_group, null, true);
        TextView txtTitle = (TextView) rowView.findViewById(R.id.txtView);
        TextView txtResumen = (TextView) rowView.findViewById(R.id.txtResumen);
        ImageView imageViews = (ImageView) rowView.findViewById(R.id.imgView);
        //SimpleDraweeView draweeView = (SimpleDraweeView) rowView.findViewById(R.id.imgView);
        txtTitle.setText(tituloArray.get(position));
        txtResumen.setText(resumenArray.get(position));
        //imageView.setImageResource(Integer.parseInt(imageId.get(position)));
        Picasso.with(context).load("http://disfrutemosba.buenosaires.gob.ar/imagenes/imagegallery/"+urlImageArray.get(position)).into(imageViews);
        //Uri uri = Uri.parse("http://disfrutemosba.buenosaires.gob.ar/imagenes/imagegallery/"+urlImageArray.get(position));

        //draweeView.setImageURI(uri);
        //imageView.setBackgroundResource(imageId[position]);
        //imageView.setImageResource(imageId[position]);

        return rowView;
    }
}