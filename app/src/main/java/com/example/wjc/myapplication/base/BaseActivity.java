package com.example.wjc.myapplication.base;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.wjc.myapplication.bean.ActivityTypeBean;
import com.example.wjc.myapplication.R;

import java.util.List;

/**
 * ClassName:com.example.wjc.myapplication
 * Description:
 * JcChen on 2019/6/16 10:16
 */
public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(setContentLayoutId());
        Adapter adapter = new Adapter(this);
        adapter.setDates(getList());
        RecyclerView recyclerView = findViewById(R.id.rl_base);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

    public abstract int setContentLayoutId();
    public abstract List<ActivityTypeBean> getList();

    private class Adapter extends BaseAdapter<ActivityTypeBean> {
        public Adapter(Context context) {
            super(context);
        }

        @Override
        public int getLayoutId() {
            return R.layout.item_base;
        }

        @Override
        public void onBindItemHolder(BaseViewHolder holder, int position) {
            TextView testName = (TextView) holder.getView(R.id.tv_test_name);
            testName.setText(mDates.get(position).getName());
            testName.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    context.startActivity(new Intent(context, mDates.get(position).getIntentClass()));
                }
            });
        }
    }
}
