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

import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import dalvik.system.DexClassLoader;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.observables.ConnectableObservable;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        RxJavaColdTest();
    }

    public void classLoaderTest() {
        ClassLoader classLoader = getClassLoader();
        ClassLoader classLoader1 = Activity.class.getClassLoader();
        Log.i(TAG, "onCreate: getClassLoader=" + classLoader);
        Log.i(TAG, "onCreate: getClassLoader 父类：" + classLoader.getParent());
        Log.i(TAG, "onCreate:Activity classLoader1=" + classLoader1);
    }

    /**
     * 冷： 观察者订阅了，才会开始执行发射数据流的代码
     * Observable  和 Observer 是一对一的关系
     * 对 Cold Observable 而已，有多个Observer的时候，
     * 它们各自的事件是独立的
     * 事件是什么？
     * 事件类型         作用
     * onNext()        观察者会回调它的onNext()方法
     * onError()        onError事件发送之后，其他事件不会继续发送
     * onComplete()     onComplete事件发送之后，其他事件不会继续发送
     * <p>
     * 热 ：.publish()、 ((ConnectableObservable<Long>) coldObservable).connect();
     * 一创建完就开始发射数据
     */
    public void RxJavaColdTest() {
        Log.i(TAG, "RxJavaColdTest: ");
        Observable<Long> coldObservable = Observable.create(new ObservableOnSubscribe<Long>() {
            @Override
            public void subscribe(ObservableEmitter<Long> emitter) throws Exception {
                Observable.interval(10, TimeUnit.MILLISECONDS, Schedulers.computation())
                        .take(10).subscribe(emitter::onNext);
            }
        }).publish();
        ((ConnectableObservable<Long>) coldObservable).connect();

        coldObservable.subscribe(new Consumer<Long>() {
            @Override
            public void accept(Long aLong) throws Exception {
                Log.i(TAG, "accept: --long=" + aLong);
            }
        });

        try {
            Thread.sleep(30);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        coldObservable.subscribe(new Observer<Long>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Long aLong) {
                Log.d(TAG, "onNext: long=" + aLong);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {
                Log.i(TAG, "onComplete: ");
            }
        });

        coldObservable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<Long>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Long aLong) {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });


        Observable.just("1").map(new Function<String, String>() {
            @Override
            public String apply(String s) throws Exception {
                return null;
            }
        })

                .subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(String s) {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }

        });


    }


}
