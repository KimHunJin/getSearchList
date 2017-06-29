package kr.co.tmon.hunjin.simpledairy.utils;

import android.support.v7.app.AppCompatActivity;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by HunJin on 2017-06-29.
 */

public class BaseRealmActivity extends AppCompatActivity {
    private RealmConfiguration realmConfiguration;

    protected RealmConfiguration getRealmConfiguration() {
        if (realmConfiguration == null) {
            realmConfiguration = new RealmConfiguration
                    .Builder()
                    .deleteRealmIfMigrationNeeded()
                    .build();
        }
        return realmConfiguration;
    }

    protected void resetRealm() {
        Realm.deleteRealm(getRealmConfiguration());
    }
}
