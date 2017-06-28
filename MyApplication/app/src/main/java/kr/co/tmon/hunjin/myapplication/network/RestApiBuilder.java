package kr.co.tmon.hunjin.myapplication.network;

import kr.co.tmon.hunjin.myapplication.utils.StaticURL;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ysg01129 on 2017-06-28.
 */

public class RestApiBuilder {

    public static RestAPI buildRetrofitService() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(StaticURL.URL)
                // Data converter
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(new OkHttpClient.Builder().build())
                .build();

        return retrofit.create(RestAPI.class);
    }
}
