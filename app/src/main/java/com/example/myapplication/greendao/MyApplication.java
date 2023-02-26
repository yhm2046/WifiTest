package com.example.myapplication.greendao;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;


public class MyApplication extends Application {
    private static final String TAG = "MyApplication:evan";
    public static MyApplication instances;
    private DaoSession daoSession;
    @Override
    public void onCreate() {
        super.onCreate();
        instances = this;
        initGreenDao();
    }
    /**
     * 初始化GreenDao,直接在Application中进行初始化操作
     */
    private void initGreenDao() {
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, "aserbao.db");
        SQLiteDatabase db = helper.getWritableDatabase();
        DaoMaster daoMaster = new DaoMaster(db);
        daoSession = daoMaster.newSession();
    }

    public DaoSession getDaoSession() {
        return daoSession;
    }

    public static MyApplication getInstaces(){
        return instances;
    }
}
