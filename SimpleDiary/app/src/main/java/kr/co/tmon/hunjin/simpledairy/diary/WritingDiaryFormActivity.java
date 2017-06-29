package kr.co.tmon.hunjin.simpledairy.diary;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;

import io.realm.Realm;
import kr.co.tmon.hunjin.simpledairy.utils.BaseRealmActivity;
import kr.co.tmon.hunjin.simpledairy.R;
import kr.co.tmon.hunjin.simpledairy.model.DiaryData;
import kr.co.tmon.hunjin.simpledairy.utils.GetCurrentDateTime;

public class WritingDiaryFormActivity extends BaseRealmActivity {

    private EditText edtTitle;
    private EditText edtContents;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_writing_diary_form);

        initialize();
    }

    void initialize() {
        edtTitle = (EditText) findViewById(R.id.edt_diary_writing_title);
        edtContents = (EditText) findViewById(R.id.edt_diary_writing_contents);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.item_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.save_writing: {
                saveData();
                return true;
            }
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    void saveData() {
        String title = edtTitle.getText().toString();
        String contents = edtContents.getText().toString();

        if (title.isEmpty() || contents.isEmpty()) {
            return;
        }

        Realm realm = Realm.getInstance(getRealmConfiguration());
        realm.beginTransaction();

        Number curId = realm.where(DiaryData.class).max("id");
        long id = (curId == null) ? 1 : curId.longValue() + 1;
        DiaryData diaryData = realm.createObject(DiaryData.class, id);
        diaryData.setTitle(edtTitle.getText().toString().trim());
        diaryData.setContents(edtContents.getText().toString().trim());
        diaryData.setDate(GetCurrentDateTime.getCurrentDateTime());

        realm.commitTransaction();

        finish();

    }
}
