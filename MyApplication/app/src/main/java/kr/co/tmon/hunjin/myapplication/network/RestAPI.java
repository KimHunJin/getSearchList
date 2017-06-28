package kr.co.tmon.hunjin.myapplication.network;


import kr.co.tmon.hunjin.myapplication.network.objects.JsonObject;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by ysg01129 on 2017-06-28.
 */

public interface RestAPI {

    @GET("image?")
    Observable<JsonObject> getSearchResultList(
            @Query("apikey") String key,
            @Query("q") String name,
            @Query("output") String option
    );

}
