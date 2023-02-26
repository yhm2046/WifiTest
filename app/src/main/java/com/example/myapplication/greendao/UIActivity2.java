package com.example.myapplication.greendao;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.myapplication.R;
import com.example.myapplication.databinding.ActivityUiactivity2Binding;

public class UIActivity2 extends AppCompatActivity {
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
    }
}