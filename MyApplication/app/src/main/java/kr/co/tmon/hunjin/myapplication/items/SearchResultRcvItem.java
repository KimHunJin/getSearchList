package kr.co.tmon.hunjin.myapplication.items;

/**
 * Created by ysg01129 on 2017-06-28.
 */

public class SearchResultRcvItem {
    private int mId;
    private String mImageURL;
    private String mTitle;

    public SearchResultRcvItem(int id, String imageURL, String title) {
        this.mId = id;
        this.mImageURL = imageURL;
        this.mTitle = title;
    }

    public int getmId() {
        return mId;
    }

    public String getmImageURL() {
        return mImageURL;
    }

    public String getmTitle() {
        return mTitle;
    }
}
