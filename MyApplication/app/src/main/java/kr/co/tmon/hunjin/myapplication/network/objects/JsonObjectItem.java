package kr.co.tmon.hunjin.myapplication.network.objects;

import com.google.gson.annotations.SerializedName;

/**
 * Created by ysg01129 on 2017-06-28.
 */

public class JsonObjectItem {
    @SerializedName("pubDate")
    String pubDate;

    @SerializedName("title")
    String title;

    @SerializedName("thumbnail")
    String thumbnail;

    @SerializedName("cp")
    String cp;

    @SerializedName("height")
    String height;

    @SerializedName("link")
    String link;

    @SerializedName("width")
    String width;

    @SerializedName("image")
    String image;

    @SerializedName("cpname")
    String cpname;

    public String getPubDate() {
        return pubDate;
    }

    public String getTitle() {
        return title;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public String getCp() {
        return cp;
    }

    public String getHeight() {
        return height;
    }

    public String getLink() {
        return link;
    }

    public String getWidth() {
        return width;
    }

    public String getImage() {
        return image;
    }

    public String getCpname() {
        return cpname;
    }
}
