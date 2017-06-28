package kr.co.tmon.hunjin.myapplication.network;


import java.util.Map;

import kr.co.tmon.hunjin.myapplication.network.objects.JsonObject;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;
import rx.Observable;

/**
 * Created by ysg01129 on 2017-06-28.
 */

public interface RestAPI {

    @GET("/image")
    Observable<JsonObject> getSearchResultList(@QueryMap Map<String, String> options);

}
