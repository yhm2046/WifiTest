package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.util.Log;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity:evan";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        main();
    }

    /**
     * 打印某个类所有的字段
     * @param obj
     */
    public static void printAllFields(Object obj){
        Class    cls=obj.getClass();
        Field[] fields=cls.getDeclaredFields();
        System.out.println("共有"+fields.length+"个属性");
        for (Field field:fields) {
            field.setAccessible(true);
            try {
                System.out.println(field.getName()+":"+field.get(obj));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
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
                //f.getName()得到对应字段的属性名，f.get(o)得到对应字段属性值,f.getGenericType()得到对应字段的类型
//                System.out.println("属性名："+f.getName()+"；属性值："+f.get(o)+";字段类型：" + f.getGenericType());
                Log.i(TAG,"属性名："+f.getName()+"；属性值："+f.get(o)+";字段类型：" + f.getGenericType());
            } catch (IllegalArgumentException | IllegalAccessException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                Log.i(TAG,"ReflectUtil error:"+e.toString());
            }
        }
    }

    private void main() {
        // Get the NetworkInterface for the WiFi connection
        try {
            Log.i(TAG,"come in main..");
            NetworkInterface wifiInterface = NetworkInterface.getByName("wlan0");
    //遍历
//            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
//
//            while (networkInterfaces.hasMoreElements()) {
//                NetworkInterface wifiInterface1 = networkInterfaces.nextElement();
//                Log.i(TAG,"wifiInterface:" + wifiInterface1.getName());
//            }
//            Log.i(TAG,"222222222222222");
            WifiManager wifiManager = (WifiManager) this.getSystemService(WIFI_SERVICE);
            WifiInfo wifiInfo = wifiManager.getConnectionInfo();
//            Log.i(TAG,"name ------> " + wifiInfo.get);
//            reflect(wifiInfo);
//遍历所有方法
            Class<?> wifiInfoClass = Class.forName(android.net.wifi.WifiInfo.class.getName());
            Method[] methods = wifiInfoClass.getDeclaredMethods();
            Log.i(TAG,"total function is " + methods.length);
            for (Method method : methods) {
                Log.i(TAG," " + method.getName());

            }
            ////////////////
            Object o = android.net.wifi.WifiInfo.class;
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

//            end
            // Get the IP address of the WiFi interface
            InetAddress wifiAddress = wifiInterface.getInetAddresses().nextElement();
            // Create a socket using the WiFi interface
            java.net.Socket socket = new java.net.Socket(wifiAddress, 80);
            // Send data over the socket
            socket.getOutputStream().write("Hello World".getBytes());
            // Close the socket
            socket.close();
        } catch (Exception e) {
            Log.i(TAG,"main error :" + e);
//            throw new RuntimeException(e);
        }

    }
}