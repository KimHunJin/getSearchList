package kr.co.tmon.hunjin.myapplication.adpaters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import kr.co.tmon.hunjin.myapplication.R;
import kr.co.tmon.hunjin.myapplication.holder.RecyclerViewResultViewHolder;
import kr.co.tmon.hunjin.myapplication.items.SearchResultRcvItem;

/**
 * Created by ysg01129 on 2017-06-28.
 */

public class ResultRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewResultViewHolder> {

    private View mView;
    private Context mContext;
    private List<SearchResultRcvItem> items;
    private LayoutInflater mLayoutInflater;

    public ResultRecyclerViewAdapter(Context context) {
        super();
        this.mContext = context;
        items = new ArrayList<>();
    }

    @Override
    public RecyclerViewResultViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        mLayoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mView = mLayoutInflater.inflate(R.layout.item_search_result_rcv, viewGroup, false);

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

    public void addData(SearchResultRcvItem item) {
        items.add(item);
        notifyDataSetChanged();
    }

    public void clear() {
        items.clear();
        notifyDataSetChanged();
    }
}
