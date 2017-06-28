package kr.co.tmon.hunjin.myapplication.network.objects;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by ysg01129 on 2017-06-28.
 */

public class JsonObjectChannel {
    @SerializedName("result")
    String result;

    @SerializedName("pageCount")
    String pageCount;

    @SerializedName("title")
    String title;

    @SerializedName("totlaCount")
    String totalCount;

    @SerializedName("description")
    String description;

    @SerializedName("item")
    List<JsonObjectItem> items;

    public List<JsonObjectItem> getItems() {
        return items;
    }

    public String getResult() {
        return result;
    }

    public String getPageCount() {
        return pageCount;
    }

    public String getTitle() {
        return title;
    }

    public String getTotalCount() {
        return totalCount;
    }

    public String getDescription() {
        return description;
    }


}
