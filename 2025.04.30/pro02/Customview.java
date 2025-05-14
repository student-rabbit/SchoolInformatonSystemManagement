package com.example.pro02;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Customview extends View {
    private List<Circle> circles = new ArrayList<>();
    private Paint paint;


    Customview(Context context)
    {
        super(context);
        paint = new Paint();
    }
    @Override
    protected void onDraw(@NonNull Canvas canvas) {
        super.onDraw(canvas);
        for(Circle circle: circles)
        {
            paint.setColor(circle.color);
            canvas.drawCircle(circle.x, circle.y, circle.radius, paint);
        }
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if(event.getAction() == MotionEvent.ACTION_DOWN)
        {
            Random random = new Random();
            float radius = random.nextInt(300); // 0~299까지의 반지름
            int color = Color.rgb(random.nextInt(256), random.nextInt(256), random.nextInt(256));
            float x = event.getX();
            float y = event.getY();
            circles.add(new Circle(x, y, radius, color));
            invalidate();
            return  true;
        }
        return super.onTouchEvent(event);
    }
    private class Circle{
        float x, y, radius;
        int color;
        Circle(float x, float y, float radius, int color) {
            this.x = x;
            this.y = y;
            this.radius = radius;
            this.color = color;
        }
    }
}
