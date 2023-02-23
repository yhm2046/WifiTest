package com.example.myapplication;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Optional;

/**
 * 反射的例子
 */
public class ReflectTest extends AppCompatActivity {
    private static final String TAG = "MapTest:evan";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Student student = new Student();
        student.setAge(33);
        student.setName("Michael");
        student.setSex("Man");
        reflect(student);
    }

    //遍历类中所有字段信息 https://blog.csdn.net/weixin_34346099/article/details/94036015
    public static void reflect(Object o){
        //获取参数类
        Class cls = o.getClass();
        //将参数类转换为对应属性数量的Field类型数组（即该类有多少个属性字段 N 转换后的数组长度即为 N）
        Field[] fields = cls.getDeclaredFields();
        for(int i = 0;i < fields.length; i ++){
            Field f = fields[i];
            f.setAccessible(true);
            try {
                Log.i(TAG,"属性名："+f.getName()+"；属性值："+f.get(o)+";字段类型：" + f.getGenericType());
            } catch (IllegalArgumentException | IllegalAccessException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                Log.i(TAG,"ReflectUtil error:"+e.toString());
            }
        }
    }
}
