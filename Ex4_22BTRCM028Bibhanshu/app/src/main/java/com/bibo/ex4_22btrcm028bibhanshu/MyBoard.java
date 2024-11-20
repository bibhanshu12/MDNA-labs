package com.bibo.ex4_22btrcm028bibhanshu;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;
public class MyBoard extends View {
    public MyBoard(Context context) {
        super(context);
// TODO Auto-generated constructor stub
    }
    @Override
    protected void onDraw(Canvas canvas) {
// TODO Auto-generated method stub
        super.onDraw(canvas);
        Paint paint = new Paint();
//        canvas.drawCircle(100, 250, 100, paint);
//        canvas.drawRect(250, 50, 400, 250, paint);
//        canvas.drawRect(50, 450, 150, 550, paint);
//        canvas.drawLine(250, 500, 350, 500, paint);
//        canvas.drawOval(new RectF(20, 20, 50, 100), paint);

        canvas.drawCircle(canvas.getWidth() / 2, canvas.getHeight() / 3, 100, paint);

        // Centered Rectangle Below Circle
        canvas.drawRect(canvas.getWidth() / 2 - 150, canvas.getHeight() / 2, canvas.getWidth() / 2 + 150, canvas.getHeight() / 2 + 200, paint);

        // Small Square in the Bottom Left Corner
        canvas.drawRect(50, canvas.getHeight() - 200, 150, canvas.getHeight() - 100, paint);

        // Horizontal Line Above the Rectangle
        canvas.drawLine(canvas.getWidth() / 2 - 150, canvas.getHeight() / 2 - 50, canvas.getWidth() / 2 + 150, canvas.getHeight() / 2 - 50, paint);

        // Oval in the Top Left Corner
        canvas.drawOval(new RectF(20, 20, 100, 200), paint);

        // Arc in the Bottom Right Corner
        canvas.drawArc(new RectF(canvas.getWidth() - 400, canvas.getHeight() - 400, canvas.getWidth() - 100, canvas.getHeight() - 100), 45, 65, true, paint);

    }
}
