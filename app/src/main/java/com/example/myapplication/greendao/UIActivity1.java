package com.example.myapplication.greendao;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.myapplication.R;
import com.example.myapplication.databinding.ActivityUiactivity1Binding;

import java.util.List;
import java.util.Random;

public class UIActivity1 extends AppCompatActivity {
    private static final String TAG = "UIActivity1:evan";
    private ActivityUiactivity1Binding binding;
    DaoSession daoSession;
    StudentDao studentDao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityUiactivity1Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        daoSession = ((MyApplication) getApplication()).getDaoSession();
        studentDao = MyApplication.getInstaces().getDaoSession().getStudentDao();
        if(Utils.firstRun(this)){
//            插入数据
            Log.i(TAG,"first in app");
            for (int i = 0; i < 10; i++) {
                Student student = new Student();
                student.setName("学生" + i);
                student.setAge(new Random().nextInt(100));
                student.setsId(new Random().nextInt(100));
                if(i % 2 == 0)
                    student.setSex("male");
                 else
                     student.setSex("female");
                daoSession.insert(student);
            }

        }else{
            Log.i(TAG,"not first in app");
        }

        binding.uiActivity1BtnJump.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UIActivity1.this,UIActivity2.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        //        查找所有数据
        List<Student> st = daoSession.loadAll(Student.class);
        if (st.size()>0)
            for (int i = 0;i < st.size();i ++)
                Log.i(TAG,"st" + i + " id:" + st.get(i).getId()
                        + " sex:" + st.get(i).getSex()
                        + " name:" + st.get(i).getName()
                        + " age:" + st.get(i).getAge()
                        + " sid:" + st.get(i).getSId());
        else
            Log.i(TAG,"st data is null");
    }
}