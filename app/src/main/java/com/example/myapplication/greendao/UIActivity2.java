package com.example.myapplication.greendao;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.myapplication.R;
import com.example.myapplication.databinding.ActivityUiactivity2Binding;

public class UIActivity2 extends AppCompatActivity {
    private static final String TAG = "UIActivity2:evan";
    ActivityUiactivity2Binding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityUiactivity2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initData();
    }

    private void initData() {
        binding.uiEtName.requestFocus();
        binding.uiAt2BtnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String strName = binding.uiEtName.getText().toString();
                    Log.i(TAG,"strname:" + strName);
                    String strSid = binding.uiEtSid.getText().toString();
                    Student student = new Student();
                    student.setName(strName);
                    student.setsId(Integer.parseInt(strSid));
                    student.setAge(Integer.parseInt(strSid));
                    student.setSex("男");
                    DaoSession daoSession = ((MyApplication) getApplication()).getDaoSession();
                    daoSession.insert(student);
                    Log.i(TAG,"insert success!");
                } catch (Exception e) {
                    Log.i(TAG,"insert error:" + e);
                    throw new RuntimeException(e);
                }
            }
        });
    }
}