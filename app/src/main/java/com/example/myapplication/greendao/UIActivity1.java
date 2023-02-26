package com.example.myapplication.greendao;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.myapplication.R;

public class UIActivity1 extends AppCompatActivity {
    private static final String TAG = "UIActivity1:evan";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uiactivity1);
        if(Utils.firstRun(this)){
            Log.i(TAG,"first in app");
        }else{
            Log.i(TAG,"not first in app");
        };
    }
}