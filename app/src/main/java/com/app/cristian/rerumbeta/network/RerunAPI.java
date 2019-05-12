package com.app.cristian.rerumbeta.network;

import com.app.cristian.rerumbeta.modelos.Items;
import com.app.cristian.rerumbeta.modelos.User;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by nicolaspickelny on 4/29/17.
 */
public interface RerunAPI {

//    @Body HashMap<String,String> body
    //webservice/response/client.php?Method=GetEventosByIdCategories&IdCategories=4&Latitud=&Longitud=&OrdenarPor=&Orden=DESC&Limit=30&Offset=0
    @GET("webservice/response/client.php?Method=GetEventosByIdCategories")
    Call<Items> pedirDatosC(@Query("IdCategories") String IdCategories,@Query("OrdenarPor") String OrdenarPor,@Query("Orden") String Orden,@Query("Limit") String Limit);
//@GET("webservice/response/client.php?Method=GetEventosByIdCategories&IdCategories=6&Latitud=&Longitud=&OrdenarPor=FechaPublicacionDesde&Orden=DESC&Limit=20&Offset=0")

    // "webservice/response/client.php?Method=GetEventosListFiltered&IdEvento=&IdEstadoEvento=&Titulo=&Resumen=&Descripcion=&FechaInicio=&FechaFin=&FechaPublicacionDesde=2017-05-01&FechaPublicacionHasta=&FechaProximoEventoDesde=&FechaProximoEventoHasta=&DestacadoHome=&MarcaProximosEventos=&Imagen=&AlbumFlickr=&Facebook=&Youtube=&Twitter=&IdEventoPadre=&IdEventosRelacionados=&Hora=&Minutos=&IdTipoEvento=&DestacadoBoxPrimario=&Latitud=&Longitud=&OrdenarPor=&Orden=DESC&Limit=20&Offset=0"
    @GET("webservice/response/client.php?Method=GetEventosListFiltered")
    Call<Items> pedirDatos(@Query("FechaPublicacionDesde") String fecha, @Query("IdEstadoEvento") String Estado);

    @POST("api/user/login")
    Call<User> logguearse(@Body HashMap params);

    @POST("api/user/register")
    Call<User> registrarse(@Body HashMap params);
}
