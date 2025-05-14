package com.example.pro02;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

import androidx.annotation.NonNull;

public class Myimage extends View {
    Myimage(Context context)
    {
        super(context);
    }
    @Override
    protected void onDraw(@NonNull Canvas canvas) {
        super.onDraw(canvas);
        Bitmap image = BitmapFactory.decodeResource(getResources(), R.drawable.lego);
        canvas.drawBitmap(image,0,0, null);
        Bitmap image2 = BitmapFactory.decodeResource(getResources(), R.drawable.lego2);
        canvas.drawBitmap(image2,this.getWidth()/2,this.getHeight()/2, null);
        int cenx = this.getWidth()/2; // 그려지는 화면의 중심좌표 구하기
        int ceny = this.getHeight()/2;
        int picx = (this.getWidth() - image.getWidth())/2; // 화면의 중앙
        int picy = (this.getHeight() - image.getHeight())/2; // 화면의 중앙


        // 회전
        canvas.rotate(45, cenx, ceny);
        canvas.drawBitmap(image,0,0, null);
        // 이동
        canvas.translate(-50, 10);
        canvas.drawBitmap(image2,picx,picy, null);
        // 확대
        canvas.scale(2, 2, cenx, ceny);
        canvas.drawBitmap(image2,picx,picy, null);
        // 기울이기
        canvas.skew(0.3f, 0.3f);
        canvas.drawBitmap(image2,picx,picy, null);
        // 이미지를 뿌옇게 : 뽀샵
        BlurMaskFilter bmsk;
        Paint paint = new Paint();
        bmsk = new BlurMaskFilter(30,BlurMaskFilter.Blur.NORMAL);
        paint.setMaskFilter(bmsk);
        canvas.drawBitmap(image2,picx,picy, paint);

        image.recycle();    // 비트맵 리소스 해제

    }
}
