package com.example.myapplication.greendao;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.myapplication.R;
import com.example.myapplication.databinding.ActivityUiactivity1Binding;

public class UIActivity1 extends AppCompatActivity {
    private static final String TAG = "UIActivity1:evan";
    private ActivityUiactivity1Binding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityUiactivity1Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        if(Utils.firstRun(this)){
            Log.i(TAG,"first in app");
        }else{
            Log.i(TAG,"not first in app");
        };
        binding.uiActivity1BtnJump.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UIActivity1.this,UIActivity2.class);
                startActivity(intent);
            }
        });
    }
}