package com.example.third;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*대화상자 뜨게 하는 아래의 코드 이 문제는 선택용*/
                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                dlg.setTitle("대화상자 제목");
                dlg.setMessage("내용");
                dlg.setIcon(R.mipmap.ic_launcher);
                dlg.setPositiveButton("확인", null);
                dlg.show();
            } // end of onclick
        }); // end of onclicklistener
    } // end of oncreate
}