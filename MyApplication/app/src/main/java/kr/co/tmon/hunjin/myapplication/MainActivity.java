package kr.co.tmon.hunjin.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

import kr.co.tmon.hunjin.myapplication.adpaters.ResultRecyclerViewAdapter;
import kr.co.tmon.hunjin.myapplication.items.SearchResultRcvItem;
import kr.co.tmon.hunjin.myapplication.network.NetworkRequest;
import kr.co.tmon.hunjin.myapplication.network.RestAPI;
import kr.co.tmon.hunjin.myapplication.network.RestApiBuilder;
import kr.co.tmon.hunjin.myapplication.network.StaticURL;
import rx.Observer;
import rx.Scheduler;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

public class MainActivity extends AppCompatActivity {

    private final static String TAG = MainActivity.class.getSimpleName();

    private RecyclerView mRcvResultList;
    private ResultRecyclerViewAdapter mResultRecyclerViewAdapter;
    private Subscription mSubscription;

    EditText edtSearchImageName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialize();
    }

    void initialize() {
        initRecyclerView();
        edtSearchImageName = (EditText)findViewById(R.id.edt_search_image_name);
        mResultRecyclerViewAdapter = new ResultRecyclerViewAdapter(this);
        mRcvResultList.setAdapter(mResultRecyclerViewAdapter);
    }

    void initRecyclerView() {
        mRcvResultList = (RecyclerView)findViewById(R.id.rcv_result_list);
        mRcvResultList.setHasFixedSize(true);
        mRcvResultList.setLayoutManager(new LinearLayoutManager(this));
    }

    void getNetwork(String imageName) {
        Map map = new HashMap<String, String>();
        map.put("apikey", StaticURL.API_KEY);
        map.put("q",imageName);
        map.put("output","json");

        RestAPI restAPI = RestApiBuilder.buildRetrofitService();
        mSubscription = NetworkRequest.performAsyncRequest(restAPI.getSearchResultList(map), (data) -> {

        }, (error) -> {

        });

    }

    public void onClick(View v) {
        getNetwork(edtSearchImageName.getText().toString());
    }
}
