package com.mozio.toddsyndrome;

import android.app.Application;

import com.activeandroid.ActiveAndroid;
import com.activeandroid.Configuration;

/**
 * Created by guilhermeduartemattos on 2/13/16.
 */
public class ToddSyndromeApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Configuration dbConfiguration = new Configuration.Builder(this).setDatabaseName("ToddSyndrome.db").create();
        ActiveAndroid.initialize(dbConfiguration);
    }
}
