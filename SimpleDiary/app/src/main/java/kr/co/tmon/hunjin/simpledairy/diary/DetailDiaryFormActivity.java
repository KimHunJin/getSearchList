package kr.co.tmon.hunjin.simpledairy.diary;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

import io.realm.Realm;
import kr.co.tmon.hunjin.simpledairy.R;
import kr.co.tmon.hunjin.simpledairy.model.DiaryData;
import kr.co.tmon.hunjin.simpledairy.utils.BaseRealmActivity;
import kr.co.tmon.hunjin.simpledairy.utils.GetCurrentDateTime;

public class DetailDiaryFormActivity extends BaseRealmActivity {

    private static final String TAG = DetailDiaryFormActivity.class.getSimpleName();

    private Realm realm;

    private EditText edtTitle;
    private EditText edtContents;
    private TextView txtDate;

    private int status = 0;
    private long id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_diary_form);

        init();

    }

    void init() {
        status = 0;
        edtTitle = (EditText) findViewById(R.id.edt_diary_title);
        edtContents = (EditText) findViewById(R.id.edt_diary_contents);
        txtDate = (TextView) findViewById(R.id.txt_diary_date);
        Intent it = getIntent();
        id = it.getExtras().getLong("id");

        realm = Realm.getInstance(getRealmConfiguration());

        DiaryData results = getDiaryList(id + 1);
        setTitle(results.getTitle());
        setData(results.getTitle(), results.getContents(), results.getDate());
    }

    void setData(String title, String contents, String date) {
        edtTitle.setText(title);
        edtContents.setText(contents);
        txtDate.setText(date);
    }


    DiaryData getDiaryList(long id) {
        return realm.where(DiaryData.class)
                .equalTo("id", id)
                .findFirst();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.item_modify, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.modify_writing: {
                // TODO: 2017-06-29 modify event
                if (status == 0) {
                    // TODO: 2017-06-29 is available
                    status = 1;
                    edtTitle.setEnabled(true);
                    edtContents.setEnabled(true);
                } else {
                    // TODO: 2017-06-29 change
                    if (edtTitle.getText().toString().isEmpty() || edtContents.getText().toString().isEmpty()) {
                        return false;
                    }
                    status = 0;
                    edtTitle.setEnabled(false);
                    edtContents.setEnabled(false);
                    updateData();

                }
                return true;
            }
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    void updateData() {
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                DiaryData results = getDiaryList(id + 1);
                results.setTitle(edtTitle.getText().toString().trim());
                results.setContents(edtContents.getText().toString().trim());
                results.setDate(GetCurrentDateTime.getCurrentDateTime());
            }
        });
        setTitle(edtTitle.getText().toString().trim());
    }
}
