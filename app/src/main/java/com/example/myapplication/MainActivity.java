package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.util.Log;

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
            Log.i(TAG,"name ------> " + wifiInfo.getSSID());

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