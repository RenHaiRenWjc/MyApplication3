package com.example.wjc.myapplication;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import dalvik.system.DexClassLoader;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        ClassLoader classLoader = getClassLoader();
        ClassLoader classLoader1 = Activity.class.getClassLoader();
        Log.i(TAG, "onCreate: getClassLoader=" + classLoader);
        Log.i(TAG, "onCreate: getClassLoader 父类：" + classLoader.getParent());
        Log.i(TAG, "onCreate:Activity classLoader1=" + classLoader1);
    }


}
