package com.yctech.myapp.component;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

public class MoveRect extends View {
    private Paint mPaint;
    private Canvas mCanvas;
    private int count = 5;
    private Handler mHandler;
    public MoveRect(Context context) {
        super(context);
        init();
    }

    public MoveRect(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }
    protected void init() {
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setStyle(Paint.Style.FILL);
        mHandler = new Handler();
        new MoveThread().start();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mCanvas = canvas;
        mPaint.setColor(Color.BLUE);
        Log.i("goddess",count+"");
        mCanvas.drawRect(0, 0, 100,count++, mPaint);
    }
    class MoveThread extends Thread{
        @Override
        public void run() {
            super.run();
            for (;;)
            {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if(null!=mCanvas)
                {
                    if(count >= 300)
                    {
                        count = 10;
                    }
                    MoveRect.this.postInvalidate();
                }
            }
        }
    }
}
