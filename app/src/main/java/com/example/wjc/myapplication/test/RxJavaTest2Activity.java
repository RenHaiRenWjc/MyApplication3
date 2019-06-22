package com.example.wjc.myapplication.test;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.wjc.myapplication.R;
import com.example.wjc.myapplication.Utils.LogUtils;
import com.example.wjc.myapplication.test.interfaceImp.TestDisposable;
import com.example.wjc.myapplication.test.interfaceImp.TestObservableOnSubscribe;
import com.example.wjc.myapplication.test.interfaceImp.TestObserver;
import com.example.wjc.myapplication.test.interfaceImp.TestScheduler;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class RxJavaTest2Activity extends AppCompatActivity {
    private static final String TAG = "RxJavaTest2Activity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rx_java_test2);
        ButterKnife.bind(this);


    }

    @OnClick(R.id.tv_test)
    public void onViewClicked() {
        TestObservable.create(new TestObservableOnSubscribe() {
            @Override
            public void subscribe() {

            }
        }).subscribeOn(new TestScheduler() {
            @Override
            public TestWorker createWorker() {
                return null;
            }
        }).observeOn(new TestScheduler() {
            @Override
            public TestWorker createWorker() {
                return null;
            }
        }).subscribe(new TestObserver<String>() {
            @Override
            public void onComplete() {

            }

            @Override
            public void onError(Throwable throwable) {

            }

            @Override
            public void onNext(String s) {

            }

            @Override
            public void onSubscribe(TestDisposable d) {
                LogUtils.i(TAG, "onSubscribe: ");
            }
        });
    }
}
