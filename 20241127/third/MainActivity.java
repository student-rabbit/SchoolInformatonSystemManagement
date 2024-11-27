package com.example.memo;

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
    Button btnwrite, btnread, btndel;
    EditText edtdiary,filelink;
    String fileName="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("유소영_간단메모장");
        btnread = findViewById(R.id.btnread);
        btnwrite = findViewById(R.id.btnwrite);
        btndel = findViewById(R.id.btndel);
        filelink = findViewById(R.id.filelink);
        edtdiary = findViewById(R.id.edtdiary);

        // 쓰기 버튼 클릭
        btnwrite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    fileName = filelink.getText().toString();
                    FileOutputStream outf = openFileOutput(fileName, Context.MODE_PRIVATE);
                    String str = edtdiary.getText().toString();
                    outf.write(str.getBytes());
                    outf.close();
                    Toast.makeText(getApplicationContext(),fileName  + "저장되었습니다.", Toast.LENGTH_LONG).show();
                }catch (IOException a) {
                    Toast.makeText(getApplicationContext(),fileName  + "가 error", Toast.LENGTH_LONG).show();
                } // 예외가 발생했을 때 처리하는 부분
            } // end of onclick
        }); // end of btnWrite click

        // 읽기 버튼 클릭
        btnread.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    fileName = filelink.getText().toString();
                    FileInputStream inf = openFileInput(fileName);
                    byte[] txt = new byte[inf.available()];
                    inf.read(txt);
                    String str = new String(txt);
                    edtdiary.setText(str);
                    Toast.makeText(getApplicationContext(), fileName, Toast.LENGTH_LONG).show();
                    inf.close();
                } // 예외가 발생할 수 있는 부분
                catch (IOException b) {
                    Toast.makeText(getApplicationContext(), "error", Toast.LENGTH_LONG).show();
                } // 예외가 발생했을 때 처리하는 부분
            } // end of onclick
        }); // end of btnread click

        // 삭제 버튼 클릭
        btndel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    deleteFile(fileName);
                    Toast.makeText(getApplicationContext(), "파일삭제완료", Toast.LENGTH_LONG).show();
                } catch (Exception e){
                    Toast.makeText(getApplicationContext(), "삭제error", Toast.LENGTH_LONG).show();
                } // end of try catch
            } // end of onclick
        }); // end of btndel click

    } // end of oncreate
} // end of MainActivity