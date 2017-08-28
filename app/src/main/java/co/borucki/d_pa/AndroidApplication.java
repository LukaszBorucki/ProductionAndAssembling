package co.borucki.d_pa;

import android.app.Application;
import android.support.v7.app.AppCompatDelegate;

import com.j256.ormlite.android.apptools.OpenHelperManager;

import co.borucki.d_pa.database.Database;
import co.borucki.d_pa.database.DatabaseOrmImpl;
import co.borucki.d_pa.persistence.DpaSharedPreferences;

public class AndroidApplication extends Application {
    private static DpaSharedPreferences mSharedPreferences;
    private static Database mDatabase;

    @Override
    public void onCreate() {
        super.onCreate();
        mSharedPreferences = new DpaSharedPreferences(this);
        mDatabase = OpenHelperManager.getHelper(this, DatabaseOrmImpl.class);
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }

    public static DpaSharedPreferences getSharedPreferences() {
        return mSharedPreferences;
    }

    public static Database getDatabase() {
        return mDatabase;
    }
}
