package com.example.wjc.myapplication;

import android.app.Activity;
import android.util.Log;

import com.example.wjc.myapplication.base.BaseActivity;
import com.example.wjc.myapplication.bean.ActivityTypeBean;
import com.example.wjc.myapplication.itemActivity.RxJavaTestActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {
    private static final String TAG = "MainActivity";


    @Override
    public int setContentLayoutId() {
        return R.layout.activity_base;
    }

    @Override
    public List<ActivityTypeBean> getList() {
        List<ActivityTypeBean> list = new ArrayList<>();
        list.add(new ActivityTypeBean("RxJava 测试", RxJavaTestActivity.class));
        return list;
    }

    public void classLoaderTest() {
        ClassLoader classLoader = getClassLoader();
        ClassLoader classLoader1 = Activity.class.getClassLoader();
        Log.i(TAG, "onCreate: getClassLoader=" + classLoader);
        Log.i(TAG, "onCreate: getClassLoader 父类：" + classLoader.getParent());
        Log.i(TAG, "onCreate:Activity classLoader1=" + classLoader1);
    }
}
