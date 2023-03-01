package com.example.myapplication.tctest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class TCTestActivity extends AppCompatActivity {
    private static final String TAG = "TCTestActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        main();
    }

    private void main() {
        byte[] content = { (byte)0x00, (byte)0x01,
                (byte)0xfa, (byte)0x60, (byte)0x1f,
                (byte)0x00, (byte)0x00, (byte)0x01};
        Log.i(TAG,"转换后:" + byte2hex(content));
    }

    /**
     * byte数组转成字符串显示
     *
     * @param b
     * @return
     */
    public String byte2hex(byte[] b) {
        StringBuilder sb = new StringBuilder();
        String stmp = "";
        for (int n = 0; n < b.length; n++) {
            stmp = Integer.toHexString(b[n] & 0XFF);
            if (stmp.length() == 1) {
                sb.append("0" + stmp);
            } else {
                sb.append(stmp);
            }


        }
        return sb.toString();
    }
}