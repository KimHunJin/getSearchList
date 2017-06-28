package kr.co.tmon.hunjin.myapplication.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import kr.co.tmon.hunjin.myapplication.R;
import kr.co.tmon.hunjin.myapplication.items.SearchResultRcvItem;

/**
 * Created by ysg01129 on 2017-06-28.
 */

public class RecyclerViewResultViewHolder extends GenericViewHolder {

    private ImageView mImageResult;
    private TextView mTxtTitle;
    private View mView;

    public RecyclerViewResultViewHolder(View itemView) {
        super(itemView);

        this.mView = itemView;
        mImageResult = (ImageView) mView.findViewById(R.id.img_item_search_result_thumbnail);
        mTxtTitle = (TextView) mView.findViewById(R.id.txt_item_search_result_title);
    }

    public void setDataOnView(int position, List<SearchResultRcvItem> items) {
        SearchResultRcvItem item = items.get(position);
        Glide.with(mView.getContext()).load(item.getmImageURL()).into(mImageResult);
        mTxtTitle.setText(item.getmTitle());

    }
}
