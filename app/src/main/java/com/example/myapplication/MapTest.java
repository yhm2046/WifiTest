package com.example.myapplication;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;
import java.util.Optional;

/**
 * map数据结构的增删改查
 */
public class MapTest extends AppCompatActivity {
    private static final String TAG = "MapTest:evan";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        HashMap<String, Integer> map = new HashMap<>();

        // Add some key-value pairs
        map.put("John", 25);
        map.put("Jane", 30);
        map.put("Bob", 27);

        // Delete
        Log.i(TAG,"map size:" + map.size());
        map.remove("Bob");

//        Modify
        map.put("Jane",33);
        Log.i(TAG,"after remove size:" + map.size());
        Log.i(TAG,"map is " +map);
//Find
        if (map.containsKey("John")) {
            int age = Optional.ofNullable(map.get("John")).orElse(0);
            Log.i(TAG,"John's age is: " + age);
        }
    }
}
