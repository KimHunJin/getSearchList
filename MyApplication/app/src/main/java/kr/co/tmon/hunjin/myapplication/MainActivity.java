package kr.co.tmon.hunjin.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import kr.co.tmon.hunjin.myapplication.adpaters.ResultRecyclerViewAdapter;
import kr.co.tmon.hunjin.myapplication.items.SearchResultRcvItem;
import kr.co.tmon.hunjin.myapplication.network.NetworkRequest;
import kr.co.tmon.hunjin.myapplication.network.RestAPI;
import kr.co.tmon.hunjin.myapplication.network.RestApiBuilder;
import kr.co.tmon.hunjin.myapplication.utils.StaticURL;
import kr.co.tmon.hunjin.myapplication.utils.RecyclerViewOnItemClickListener;
import rx.Subscription;

public class MainActivity extends AppCompatActivity {

    private final static String TAG = MainActivity.class.getSimpleName();

    private RecyclerView mRcvResultList;
    private ResultRecyclerViewAdapter mResultRecyclerViewAdapter;
    private Subscription mSubscription;

    private EditText edtSearchImageName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("이미지 검색");

        initialize();

        itemClick();
    }

    void initialize() {
        initRecyclerView();
        edtSearchImageName = (EditText) findViewById(R.id.edt_search_image_name);
        mResultRecyclerViewAdapter = new ResultRecyclerViewAdapter(this);
        mRcvResultList.setAdapter(mResultRecyclerViewAdapter);
    }

    void initRecyclerView() {
        mRcvResultList = (RecyclerView) findViewById(R.id.rcv_result_list);
        mRcvResultList.setHasFixedSize(true);
        mRcvResultList.setLayoutManager(new LinearLayoutManager(this));
    }

    void getNetwork(String imageName) {

        RestAPI restAPI = RestApiBuilder.buildRetrofitService();

        mSubscription = NetworkRequest.performAsyncRequest(
                restAPI.getSearchResultList(
                        StaticURL.API_KEY, imageName, "json"
                ), (data) -> {

                    int size = data.getList().getItems().size();
                    for (int itemIndex = 0; itemIndex < size; itemIndex++) {
                        String imageUrl = data.getList().getItems().get(itemIndex).getThumbnail();
                        String title = data.getList().getItems().get(itemIndex).getTitle();
                        String link = data.getList().getItems().get(itemIndex).getLink();
                        mResultRecyclerViewAdapter.addData(new SearchResultRcvItem(itemIndex, imageUrl, title, link));

                    }
                }, (error) -> {
                    Log.e(TAG, "error : " + error);
                });
    }

    void itemClick() {
        mRcvResultList.addOnItemTouchListener(new RecyclerViewOnItemClickListener(this, mRcvResultList, new RecyclerViewOnItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(mResultRecyclerViewAdapter.getItems().get(position).getmLink()));
                startActivity(intent);
            }

            @Override
            public void onItemLongClick(View v, int position) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(mResultRecyclerViewAdapter.getItems().get(position).getmLink()));
                startActivity(intent);
            }
        }));
    }

    public void onClick(View v) {
        mResultRecyclerViewAdapter.clear();
        getNetwork(edtSearchImageName.getText().toString());
    }
}
