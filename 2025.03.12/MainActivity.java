package com.example.apptest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    // 전역 위젯 변수
/*    Button btn1, btn2;
    TextView txt1, txt2, txt3;
    ImageView img1, img2;
*/

    Button b;
    TextView title, act, story, story2;
    ImageView img;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);     // 메모리 올리기
        setTitle("좋아하는 영화-유소영");
        title=findViewById(R.id.title);
        act=findViewById(R.id.act);
        img=findViewById(R.id.img);
        story=findViewById(R.id.story);
        story2=findViewById(R.id.story2);
        b=(Button) findViewById(R.id.b);

        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "2024 IU HEREH WORLD TOUR CONCERT ENCORE : THE WINNING", Toast.LENGTH_LONG).show();
            }
        });
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish(); // 현재 액티비티 종료
            }
        });
    }
}
        // 지역 위젯 변수
        // Button b1;

/*        btn1=(Button) findViewById(R.id.btn1);
        btn2=(Button) findViewById(R.id.btn2);

        txt1=findViewById(R.id.txt1);
        txt2=findViewById(R.id.txt2);
        txt3=findViewById(R.id.txt3);

        img1=findViewById(R.id.img1);
        img2=findViewById(R.id.img2);

        // 동작
        txt2.setText("안녕?");

        // 이벤트 설명: 클릭, 더블클릭, 드래그, 터치 등. 리스너
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "한국대학교", Toast.LENGTH_LONG).show();
            } // end of onclick of btn1
        }); // end of btn1 ClickListener

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "컴퓨터공학과", Toast.LENGTH_LONG).show();
            } // end of onclick of btn2
        }); // end of btn2 ClickListener

        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "퇴마록 재미있어?", Toast.LENGTH_LONG).show();
                txt3.setText("퇴마록");
            } // end of onclick of img1
        }); // end of btn2 ClickListener

        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "아이유 노래 좋아!", Toast.LENGTH_LONG).show();
                txt3.setText("아이유");
            } // end of onclick of img1
        }); // end of btn2 ClickListener

    } // end of onCreate
    public void test(){} // 메소드
    class MyTest{}  // 클래스
} // end of class MainActicity

*/