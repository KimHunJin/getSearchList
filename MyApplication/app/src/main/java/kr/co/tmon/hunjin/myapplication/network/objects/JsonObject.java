package kr.co.tmon.hunjin.myapplication.network.objects;

import com.google.gson.annotations.SerializedName;

/**
 * Created by ysg01129 on 2017-06-28.
 */

public class JsonObject {

    @SerializedName("channel")
    JsonObjectChannel list;


    public JsonObjectChannel getList() {
        return list;
    }
}
