package kr.co.tmon.hunjin.simpledairy.items;

/**
 * Created by ysg01129 on 2017-06-29.
 */

public class DiaryListItem {
    private int id;
    private String title;
    private String date;

    public DiaryListItem(int id, String title, String date) {
        this.id = id;
        this.title = title;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDate() {
        return date;
    }
}
