package com.example.wjc.myapplication;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.iv1)
    ImageView mIv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
//        Bitmap bitmap = Bitmap.createBitmap(500, 200, Bitmap.Config.ARGB_4444);
//        Paint paint = new Paint();
//        paint.setColor(this.getResources().getColor(R.color.colorPrimary));
//        Canvas canvas = new Canvas(bitmap);
//        canvas.drawBitmap(bitmap, 0, 0, paint);  //绘制原图
//        //3.画笔使用LinearGradient 线性渐变渲染
//        LinearGradient lg = new LinearGradient(0, 10, 0, bitmap.getHeight(),
////                0x1Aff0000, 0x00ffff00, Shader.TileMode.MIRROR);
//                0x33261c45, 0x00000000, Shader.TileMode.MIRROR);
//        paint.setShader(lg);
//        paint.setColor(Color.RED);
//
//        //4.指定画笔的Xfermode 即绘制的模式（不同的模式，绘制的区域不同）
//        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_ATOP));
//        paint.setAntiAlias(true);
//        //5.在倒立图区，绘制矩形渲染图层
//        canvas.drawRect(0, 20, 500, bitmap.getHeight(), paint);
//        paint.setXfermode(null);
//        mIv1.setImageBitmap(createGradientBitmap(R.mipmap.ic_launcher));
    }


    @OnClick({R.id.bt_progressBar})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bt_progressBar:
//                startActivity(new Intent(this, ProgressBarActivity.class));
                break;
        }
    }

    private Bitmap createGradientBitmap(Bitmap bmp) {
        int w = bmp.getWidth();
        int h = bmp.getHeight();

        Bitmap b = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(b);

        Paint paint = new Paint();
        paint.setShader(new LinearGradient(0, 0, 0, h, 0xffffffff, 0x00ffffff, Shader.TileMode.CLAMP));
        canvas.drawBitmap(bmp, 0, 0, null);

        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        canvas.drawRect(0, 0, w, h, paint);

        return b;
    }
}
