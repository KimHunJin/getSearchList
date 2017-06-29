package kr.co.tmon.hunjin.simpledairy.model;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by ysg01129 on 2017-06-29.
 */

public class DiaryData extends RealmObject {

    @PrimaryKey
    private long id;

    private String date;
    private String title;
    private String contents;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }
}
