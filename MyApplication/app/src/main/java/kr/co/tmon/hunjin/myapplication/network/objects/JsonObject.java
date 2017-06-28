package kr.co.tmon.hunjin.myapplication.network.objects;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by ysg01129 on 2017-06-28.
 */

public class JsonObject {

    @SerializedName("channel")
    List<JsonObjectChannel> list;

    public List<JsonObjectChannel> getList() {
        return list;
    }

    @SerializedName("test")
    String name;

    public String getName() {
        return name;
    }
}
