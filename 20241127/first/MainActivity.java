package com.example.first;

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
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {
    Button btnwrite, btnread, btndel, btnraw;
    EditText edtraw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnread = findViewById(R.id.btnread);
        btnwrite = findViewById(R.id.btnwrite);
        btndel = findViewById(R.id.btndel);
        btnraw = findViewById(R.id.btnraw);
        edtraw = findViewById(R.id.edtraw);

        // 쓰기 버튼 클릭
        btnwrite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*예외가 발생했을 때 실행할 문장*/
                try {
                    FileOutputStream outf = openFileOutput("file4.txt", Context.MODE_PRIVATE);
                    String str = "피자가 맛있옹";
                    outf.write(str.getBytes());
                    outf.close();
                    Toast.makeText(getApplicationContext(), "파일저장완료", Toast.LENGTH_LONG).show();
                } // 예외가 발생할 수 있는 부분
                catch (IOException e) {
                    Toast.makeText(getApplicationContext(), "저장에러", Toast.LENGTH_LONG).show();
                } // 예외가 발생했을 때 처리하는 부분
            } // end of onclick
        }); // end of btnWrite click

        // 읽기 버튼 클릭
        btnread.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    FileInputStream inf = openFileInput("file4.txt");
                    byte [] txt = new byte[30];
                    inf.read(txt);
                    String str = new String(txt);
                    Toast.makeText(getApplicationContext(), str, Toast.LENGTH_LONG).show();
                } // 예외가 발생할 수 있는 부분
                catch (IOException e) {
                    Toast.makeText(getApplicationContext(), "error", Toast.LENGTH_LONG).show();
                } // 예외가 발생했을 때 처리하는 부분
            } // end of onclick
        }); // end of btnread click

        btndel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
/* 방법 1 아래의 try는 방법 2
                if(deleteFile("file2.txt"))
                    Toast.makeText(getApplicationContext(), "파일삭제완료", Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(getApplicationContext(), "삭제error", Toast.LENGTH_LONG).show();*/
                try {
                    deleteFile("file4.txt");
                    Toast.makeText(getApplicationContext(), "파일삭제완료", Toast.LENGTH_LONG).show();
                } catch (Exception e){
                    Toast.makeText(getApplicationContext(), "삭제error", Toast.LENGTH_LONG).show();
                } // end of try catch
            } // end of onclick
        }); // end of btndel click

        btnraw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    InputStream inf = getResources().openRawResource(R.raw.hi);
                    byte [] txt = new byte[500];
                    inf.read(txt);
                    edtraw.setText(new String(txt));
                    inf.close();
                } catch (IOException e){
                    Toast.makeText(getApplicationContext(), "파일이 존재하지 않습니다.", Toast.LENGTH_LONG).show();
                } // end of try catch
            } // end of onclick
        }); // end of btnraw click
    } // end of oncreate
} // end of MainActivity