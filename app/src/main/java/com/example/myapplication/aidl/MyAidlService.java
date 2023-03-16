package com.example.myapplication.aidl;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import androidx.annotation.Nullable;

/**
 * 2023.3.14    Tuesday
 * 实现AIDL接口
 */
public class MyAidlService extends Service {
    private final IMyAidlInterface mBinder = new IMyAidlInterface(){
        @Override
        public int add(int a, int b) {
            return a + b;
        }
    };
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
