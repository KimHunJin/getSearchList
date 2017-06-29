package kr.co.tmon.hunjin.simpledairy;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import io.realm.Realm;
import io.realm.RealmResults;
import kr.co.tmon.hunjin.simpledairy.adapters.DiaryRecyclerViewAdapter;
import kr.co.tmon.hunjin.simpledairy.diary.DetailDiaryFormActivity;
import kr.co.tmon.hunjin.simpledairy.diary.WritingDiaryFormActivity;
import kr.co.tmon.hunjin.simpledairy.items.DiaryListItem;
import kr.co.tmon.hunjin.simpledairy.model.DiaryData;
import kr.co.tmon.hunjin.simpledairy.utils.BaseRealmActivity;
import kr.co.tmon.hunjin.simpledairy.utils.RecyclerViewOnItemClickListener;

public class MainActivity extends BaseRealmActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    private Realm realm;
    private RecyclerView rcvDiaryList;
    private DiaryRecyclerViewAdapter diaryRecyclerViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("Diary");

        init();
    }

    void init() {
        diaryRecyclerViewAdapter = new DiaryRecyclerViewAdapter(this);
        initRealm();
        initRecyclerView();
        itemClick();
    }

    void initRecyclerView() {
        rcvDiaryList = (RecyclerView) findViewById(R.id.rcv_diary_list);
        rcvDiaryList.setHasFixedSize(true);
        rcvDiaryList.setLayoutManager(new LinearLayoutManager(this));
        rcvDiaryList.setAdapter(diaryRecyclerViewAdapter);

        addRecyclerView();
    }

    void addRecyclerView() {
        RealmResults<DiaryData> results = getDiaryList();
        clearData();
        Log.e(TAG, results.size() + "");
        for (int index = 0; index < results.size(); index++) {
            String title = getTitle(results.get(index));
            String date = getDate(results.get(index));
            addData(index, title, date);
        }
    }

    void clearData() {
        diaryRecyclerViewAdapter.clear();
    }

    void addData(int index, String title, String date) {
        diaryRecyclerViewAdapter.addData(new DiaryListItem(index, title, date));
    }

    String getTitle(DiaryData results) {
        return results.getTitle();
    }

    String getDate(DiaryData results) {
        return results.getDate();
    }

    void initRealm() {
        Realm.init(this);
        realm = Realm.getInstance(getRealmConfiguration());
    }

    RealmResults<DiaryData> getDiaryList() {
        return realm.where(DiaryData.class).findAll();
    }

    public void click(View v) {
        startActivity(new Intent(this, WritingDiaryFormActivity.class));
    }

    @Override
    protected void onResume() {
        super.onResume();
        addRecyclerView();
    }

    void itemClick() {
        rcvDiaryList.addOnItemTouchListener(new RecyclerViewOnItemClickListener(this, rcvDiaryList, new RecyclerViewOnItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                Intent it = new Intent(getApplicationContext(), DetailDiaryFormActivity.class);
                long id = diaryRecyclerViewAdapter.getItems().get(position).getId();
                Log.e(TAG,id+"");
                it.putExtra("id", id);
                startActivity(it);
            }

            @Override
            public void onItemLongClick(View v, int position) {

            }
        }));
    }
}
