package com.example.pro01;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    final static int LINE = 1, CIRCLE = 2, RECT = 3, COLOR = 4;
    static int curShape = LINE;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // setContentView(R.layout.activity_main);
        setContentView(new MyGraphicView(this));
        setTitle("간단한 그림판");
    } // end of onCreate

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        menu.add(0,1,0,"   선  그리기");
        menu.add(0,2,0,"   원  그리기");
        menu.add(0,3,0,"사각형 그리기");
        menu.add(0,4,0,"   색  변경");

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {
            case 1: curShape=LINE; return true;
            case 2: curShape=CIRCLE; return true;
            case 3: curShape=RECT; return true;
            case 4: curShape=COLOR;   return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private static class MyGraphicView extends View {
        int startx = -1, starty = -1, stopx = -1, stopy = -1;
        MyGraphicView(Context context) // 생성자
        {
            super(context);
        }
        @Override
        public boolean onTouchEvent(MotionEvent event) {
            switch (event.getAction())
            {
                case MotionEvent.ACTION_DOWN:       // 마우스 눌렀을 때
                    startx = (int) event.getX();    // X점 좌표
                    starty = (int) event.getY();    // Y점 좌표
                    break;
                case MotionEvent.ACTION_MOVE:       // 마우스를 이동
                case MotionEvent.ACTION_UP:         // 마우스를 뗏을 때
                    stopx = (int)event.getX();
                    stopy = (int)event.getY();
                    this.invalidate();              // <중요> ondraw()를 다시 호출, 다시그리기
                    break;
            }
            return true;
        } // end of onTouchEvent

        @Override
        protected void onDraw(@NonNull Canvas canvas) {
            super.onDraw(canvas);
            Paint paint = new Paint();
            paint.setColor(Color.DKGRAY);
            paint.setStrokeWidth(20);
            switch (curShape)
            {
                case LINE:
                    canvas.drawLine(startx, starty, stopx, stopy, paint);    // 시작 좌표
                    break;
                case CIRCLE:
                    canvas.drawCircle(startx,starty,200,paint);
                    break;
                case RECT:
                    canvas.drawRect(startx,starty,stopx,stopy,paint);
                    break;
                case COLOR:
                    canvas.drawColor(Color.rgb(100,20,50));
                    canvas.drawLine(startx,starty,stopx,stopy,paint);
                    break;
            }
        }

        /*
        @Override
        protected void onDraw(@NonNull Canvas canvas) {
            super.onDraw(canvas);
            Paint paint = new Paint();
            paint.setColor(Color.MAGENTA);  // 도형의 색상
            paint.setStrokeWidth(10);       // 도형의 두께
            paint.setAntiAlias(true);       // 도형 끝을 부드럽게

            canvas.drawLine(100,100,900,100,paint);
            paint.setColor(Color.BLUE);  // 도형의 색상
            canvas.drawLine(100,100,900,900,paint);
            int x = canvas.getWidth();  // 가로
            int y = canvas.getHeight(); // 세로
            paint.setColor(Color.GREEN);
            canvas.drawLine(-x,y/2,x/2,1000,paint);
            paint.setColor(Color.GRAY); // 원 그리기
            canvas.drawCircle(x/2, y/2, 300,paint);
            paint.setColor(Color.GREEN);
            canvas.drawRect(800,800,400+500, 500+700, paint);
            paint.setColor(Color.rgb(30,20,10));
            paint.setTextSize(40);
            canvas.drawText("안녕하세요.", 300,300,paint);
            canvas.drawText("Hello.", 300,340,paint);
        } // end of onDraw
*/

    } // end of MyGraphicView
} // end of MainActivity