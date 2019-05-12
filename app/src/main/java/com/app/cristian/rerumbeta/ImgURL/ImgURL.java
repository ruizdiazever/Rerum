package com.app.cristian.rerumbeta.ImgURL;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Cristian on 21/05/2017.
 */

public class ImgURL {
    //Tag para el control de trazas de LOG
    private static String APP_TAG = "ECTDownloadData";
    //Constante String con la URL de la imagen a descargar
    private static String IMG_URL = "http://www.dijon.cl/wp-content/uploads/2016/08/B95.jpg";
    //Boton de Descargar Imagen
   private static Bitmap imagenDeInternet;
    //Image View para mostrar la Imagen Descargada

    public ImgURL() {
    }

    public  static Bitmap getImagenDeInternet() {
        new DownloadImageTask().execute(IMG_URL);
        return imagenDeInternet;
    }
/*public Bitmap getImgurlAux() {


        return imgurlAux;
    }
*/

    private static class DownloadImageTask extends AsyncTask<String, Integer, Bitmap> {
        /** El sistema Android ejecuta las sentencias del método doInBackground
         * en fondo a traves de un un Worker thread y le pasa los parámetros en la llamada
         * al método AsyncTask.execute()*/
        @Override
        protected Bitmap doInBackground(String... urls) {
            return downloadImagen(urls[0]);

        }

        /** El sistema Android llama a este método para realizar los trabajos necesarios
         * en el UI thread y le entrega el resultado obtenido de la ejecución realizada
         * en el método doInBackground() */
        protected void onPostExecute(Bitmap result) {
            //Ya aquí estamos en el UI Thread o Main Thread por lo que podemos actualizar la
            //imagen del Image View para mostrala la imagen descargada
            //mImageView.setImageBitmap(result);
           // imagenDeInternet=result;
        }

        private Bitmap downloadImagen(String baseUrl) {
            Bitmap myBitmap = null;
            try
            {
                //Se define el objeto URL
                URL url = new URL(baseUrl);
                //Se arma y configura un objeto de conexión HttpURLConnection
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setDoInput(true);
                connection.connect();
                //Recibimos la respuesta de la petición en formato InputStream
                InputStream input = connection.getInputStream();
                //Decodificamos el InputStream a un objeto BitMap
                myBitmap = BitmapFactory.decodeStream(input);
                imagenDeInternet=myBitmap;
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
            return myBitmap;
        }
    }

}


