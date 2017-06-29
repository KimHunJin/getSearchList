package kr.co.tmon.hunjin.simpledairy.holders;

import android.view.View;
import android.widget.TextView;

import java.util.List;

import kr.co.tmon.hunjin.simpledairy.R;
import kr.co.tmon.hunjin.simpledairy.items.DiaryListItem;


/**
 * Created by ysg01129 on 2017-06-29.
 */

public class RecyclerViewResultViewHolder extends GenericViewHolder {

    private TextView txtTitle;
    private TextView txtDate;
    private View view;

    public RecyclerViewResultViewHolder(View itemView) {
        super(itemView);

        this.view = itemView;
        txtTitle = (TextView) view.findViewById(R.id.txt_item_title);
        txtDate = (TextView) view.findViewById(R.id.txt_item_date);

    }

    public void setDataOnView(int position, List<DiaryListItem> items) {
        DiaryListItem item = items.get(position);
        txtTitle.setText(item.getTitle());
        txtDate.setText(item.getDate());
    }
}
