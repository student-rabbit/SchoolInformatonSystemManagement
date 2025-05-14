package com.example.pro02;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.NonNull;

public class BilliardBall extends View {
    private ShapeDrawable mDrawable;
    // 객체 그래픽 초기화
    int x = 50, y = 50, width = 100, height = 100;
    // 그래픽 객체의 중심 좌표
    int cx, cy;
    // 그래픽 객체가 움직이는 방향: 1은 증가, -1은 감소
    int dir_x = 1, dir_y = 1;
    // x, y의 변화량
    int dx = 5, dy = 15;

    // 화면의 가로와 세로 크기
    int screen_width = Resources.getSystem().getDisplayMetrics().widthPixels;   // 가로
    int screen_height = Resources.getSystem().getDisplayMetrics().heightPixels;   // 세로
    BilliardBall(Context context)
    {
        // 타원 그래픽 객체 생성
        super(context);
        mDrawable = new ShapeDrawable(new OvalShape());
        // 그래픽 색 지정
        mDrawable.getPaint().setColor(Color.RED);
    }
    @Override
    protected void onDraw(@NonNull Canvas canvas) { // 그래픽 출력
        // super.onDraw(canvas);
        cx = x + width/2;// 그래픽 중심 좌표
        cy = y + height/2;
        if(cx <= width/2)// x방향의 전환
            dir_x = 1;
        else if (cx >=screen_width-width/2)
            dir_x = -1;
        if(cx <= height/2)// y방향의 전환
            dir_y = 1;
        else if (cx >=screen_height-height/2)
            dir_y = -1;
        x += dir_x * dx;
        y += dir_y * dy;
        canvas.drawColor(Color.BLACK);
        // 그래픽 객체의 크기
        mDrawable.setBounds(x, y, x + width, y + height);
        // 그래픽 객체를 캔버스에 출력
        mDrawable.draw(canvas);
        // 그래픽 객체를 지우고 다시 onDraw() 메소드 호출
        invalidate();
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);
    }
}
