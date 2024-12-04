package com.example.four;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    EditText edtfilename, edtmemo;
    Button btnread, btnwrite, btndel;
    String fName = null; /*전역변수 파일이름 정의*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtfilename = findViewById(R.id.edtfilename);
        edtmemo = findViewById(R.id.edtmemo);
        btnread = findViewById(R.id.btnread);
        btnwrite = findViewById(R.id.btnwrite);
        btndel = findViewById(R.id.btndel);

        /* 동작의 순서는 항상 쓰기 -> 읽기 -> 제거*/

        // 쓰기, 파일에 저장 FileOutputStream 클래스가 필요
        btnwrite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FileOutputStream outf = null;
                fName = edtfilename.getText().toString();
                try {
                    outf = openFileOutput(fName + ".txt", Context.MODE_PRIVATE);
                    String data = edtmemo.getText().toString();
                    outf.write(data.getBytes());
                    outf.close();
                    Toast.makeText(getApplicationContext(), "저장 완료", Toast.LENGTH_LONG).show();
                } catch (IOException e) {
                    Toast.makeText(getApplicationContext(), "저장 에러", Toast.LENGTH_LONG).show();
                } // end of try catch 반드시 예외처리 문이 필요하다!!!!!!
            } // end of onclick
        }); // end of btnwrite
        
        // 읽기, 파일에서 읽기 FileInputStream 클래스가 필요
        btnread.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FileInputStream inf = null;
                fName = edtfilename.getText().toString();
                try {
                    inf = openFileInput(fName + ".txt");
                    byte [] txt = new byte[inf.available()];
                    inf.read(txt);
                    edtmemo.setText(new String(txt)); /*텍스트의 내용을 이곳에다가 집어넣어.*/
                    inf.close();
                    Toast.makeText(getApplicationContext(), "읽기 완료", Toast.LENGTH_LONG).show();
                } catch (IOException e) {
                    Toast.makeText(getApplicationContext(), "읽기 에러", Toast.LENGTH_LONG).show();
                } // end of try catch 반드시 예외처리 문이 필요하다!!!!!!
            } // end of onclick
        }); // end of btnread
        
        // 파일 삭제_try catch는 선택이다.
        btndel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fName = edtfilename.getText().toString();
                if(deleteFile(fName + ".txt")) {
                    Toast.makeText(getApplicationContext(), "삭제 완료", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(), "삭제 오류!", Toast.LENGTH_LONG).show();
                } // end of if~else
            } // end of onclick
        }); // end of btndel

    } // end of oncreate
} // end of mainactivity