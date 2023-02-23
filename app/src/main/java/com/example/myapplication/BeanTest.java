package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * 类的常用操作
 */
public class BeanTest extends AppCompatActivity {
    private static final String TAG = "BeanTest:evan";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        copyBean();
    }

    /**
     * 复制类的实例
     */
    void copyBean(){
        Student student1 = new Student();
        student1.setSex("man");
        student1.setName("Michael");
        student1.setAge(36);

        try {
            Student student2 = CloneUtil.clone(student1);
            Log.i(TAG,"student1:" + student1.getName() + ","
                    + student1.getAge() + ","
                    + student1.getSex());
            Log.i(TAG,"student2:" + student2.getName() + ","
                    + student2.getAge() + ","
                    + student2.getSex());
        } catch (Exception e) {
            Log.i(TAG,"copyBean error: " + e);
            throw new RuntimeException(e);
        }

    }

    /**
     * 复制对象的方法
     * reference:<a href="https://www.cnblogs.com/kexinxin/p/11610110.html">...</a>
     */
    public static class CloneUtil{
        public static <T extends Serializable> T clone(T obj) throws Exception{
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(obj);

            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(byteArrayInputStream);
            return (T) ois.readObject();
        }
    }
}