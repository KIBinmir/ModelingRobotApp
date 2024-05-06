package com.example.modelingrobots;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class RobotView extends View {
    private int viewWidth;
    private int viewHeight;


    public RobotView(Context context) {
        super(context);
    }
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        viewWidth = w;
        viewHeight = h;
    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawARGB(243, 243, 243, 243); // заливаем цветом
        Paint p = new Paint();
        //p.setAntiAlias(true);
        //p.setTextSize(55.0f);
        p.setColor(Color.BLACK);
        //canvas.drawText(points+"", viewWidth - 100, 70, p);
        //canvas.drawLine(x0,y0,x1,y1,p);
        //canvas.drawLine(x1,y1,x2,y2,p);
    }


}