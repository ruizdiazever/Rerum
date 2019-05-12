package com.app.cristian.rerumbeta.network;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

/**
 * Created by nicolaspickelny on 4/29/17.
 */


public class RetrofitAPIService {

    private static RerunAPI instance;
    private static Retrofit retrofit;



    private static String base = "http://disfrutemosba.buenosaires.gob.ar/";

    public static RerunAPI getInstance() {
        if (instance == null) {

            //Gson gson = new GsonBuilder().create();
//            retrofit = new Retrofit.Builder()
//                    .baseUrl("http://localhost:3000")
//                    .addConverterFactory(GsonConverterFactory.create())
////                    .client(new OkHttpClient.Builder()
////                            .addInterceptor(new LoggingInterceptor())
////                            .build())
//                    .build();

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(base)
                    .client(new OkHttpClient())
                    .addConverterFactory(SimpleXmlConverterFactory.create())
                    .build();

            instance = retrofit.create(RerunAPI.class);
        }
        return instance;

    }

    public static Retrofit getRetrofit() {
        return retrofit;
    }

    public static void setRetrofit(Retrofit retrofit) {
        RetrofitAPIService.retrofit = retrofit;
    }
}
