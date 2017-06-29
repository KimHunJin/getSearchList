package kr.co.tmon.hunjin.simpledairy.diary;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import io.realm.Realm;
import io.realm.RealmResults;
import kr.co.tmon.hunjin.simpledairy.R;
import kr.co.tmon.hunjin.simpledairy.adapters.DiaryRecyclerViewAdapter;
import kr.co.tmon.hunjin.simpledairy.items.DiaryListItem;
import kr.co.tmon.hunjin.simpledairy.model.DiaryData;

public class MainActivity extends AppCompatActivity {

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
        realm = Realm.getDefaultInstance();
    }

    RealmResults<DiaryData> getDiaryList() {
        return realm.where(DiaryData.class).findAll();
    }

    @Override
    protected void onResume() {
        super.onResume();
        addRecyclerView();
    }
}
