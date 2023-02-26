package com.example.myapplication.greendao;

import static android.content.Context.MODE_PRIVATE;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.IntentSender;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.UserHandle;
import android.view.Display;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.myapplication.BuildConfig;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * tools class,2023.2.26 Sunday
 */
public class Utils {
    /**
     * judge whether is first run app
     * reference: <a href="https://blog.csdn.net/zhaohuiyang_949/article/details/79048510">...</a>
     * @param context   context
     * @return boolean
     */
    public static boolean firstRun(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("FirstRun",0);
        boolean first_run = sharedPreferences.getBoolean("First",true);
        if (first_run){
            sharedPreferences.edit().putBoolean("First",false).apply();
            return true;
        }
        else {
            return false;
        }
    }

}
