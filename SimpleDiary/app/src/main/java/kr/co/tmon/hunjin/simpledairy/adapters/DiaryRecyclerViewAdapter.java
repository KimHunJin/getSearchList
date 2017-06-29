package kr.co.tmon.hunjin.simpledairy.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import kr.co.tmon.hunjin.simpledairy.R;
import kr.co.tmon.hunjin.simpledairy.holders.RecyclerViewResultViewHolder;
import kr.co.tmon.hunjin.simpledairy.items.DiaryListItem;


/**
 * Created by ysg01129 on 2017-06-29.
 */

public class DiaryRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewResultViewHolder> {

    private View mView;
    private Context mContext;
    private List<DiaryListItem> items;
    private LayoutInflater mLayoutInflater;

    public DiaryRecyclerViewAdapter(Context context) {
        super();
        this.mContext = context;
        items = new ArrayList<>();
    }

    @Override
    public RecyclerViewResultViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        mLayoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mView = mLayoutInflater.inflate(R.layout.item_diary_list, viewGroup, false);

        return new RecyclerViewResultViewHolder(mView);
    }

    @Override
    public void onBindViewHolder(RecyclerViewResultViewHolder holder, int position) {
        holder.setDataOnView(position, items);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void addData(DiaryListItem item) {
        items.add(item);
        notifyDataSetChanged();
    }

    public List<DiaryListItem> getItems() {
        return items;
    }

    public void clear() {
        items.clear();
        notifyDataSetChanged();
    }
}
