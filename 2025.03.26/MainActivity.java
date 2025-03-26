package com.example.pro01;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Time;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    TextView txtresult;
    EditText edtdate, edttime;
    Button btndate, btntime, btnwrite, btnread, btnrawread, btncardread;
    AlertDialog.Builder dlg;
    View dialogdate, dialogtime;
    DatePicker datepic;
    TimePicker timepic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtresult = findViewById(R.id.txtresult);
        edtdate = findViewById(R.id.edtdate);
        edttime = findViewById(R.id.edttime);
        btndate = findViewById(R.id.btndate);
        btntime = findViewById(R.id.btntime);
        btnwrite = findViewById(R.id.btnwrite);
        btnread = findViewById(R.id.btnread);
        btnrawread = findViewById(R.id.btnread);
        btncardread = findViewById(R.id.btncardread);

        btnwrite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    FileOutputStream out = openFileOutput("date1.txt", Context.MODE_PRIVATE);
                    String str = new String("안녕하세요.\n 안드로이드 프로그램입니다.\n");
                    out.write(str.getBytes());
                    out.close();
                } catch (IOException t) {
                    Log.i("error", t.toString());
                }
            } // end of onclick
        }); // end of btnwrite

        btnread.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    FileInputStream in = openFileInput("date1.txt");
                    byte txt[] = new byte[in.available()]; // 글자 사이즈에 맞게 입력
                    in.read(txt);
                    String str = new String(txt);
                    txtresult.setText("읽은 내용: " + str);
                    in.close();
                } catch (IOException t) {
                    Log.i("error", t.toString());
                }
            }
        });

        btnrawread.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    InputStream in = getResources().openRawResource(R.raw.date1);
                    byte txt[] = new byte[in.available()]; // 글자 사이즈에 맞게 입력
                    in.read(txt);
                    String str = new String(txt);
                    txtresult.setText("내장 메모리(raw)에서 읽은 내용: " + str);
                    in.close();
                } catch (IOException t) {
                    Log.i("error", t.toString());
                }
            }
        });

        ActivityCompat.requestPermissions(this, new String[]{
                android.Manifest.permission.WRITE_EXTERNAL_STORAGE}, MODE_PRIVATE); // 허용 메시지 출력
        
        btncardread.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    FileInputStream in = new FileInputStream("/sdcard/date3.txt");
                    byte txt[] = new byte[in.available()]; // 글자 사이즈에 맞게 입력
                    in.read(txt);
                    String str = new String(txt);
                    txtresult.setText("card에서 읽은 내용: " + str);
                    in.close();
                } catch (IOException t) {
                    Log.i("error", t.toString());
                }
            }
        });

        Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR); // 년
        int month = c.get(Calendar.MONTH); //월
        int day = c.get(Calendar.DAY_OF_MONTH); // 일


        btndate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dlg = new AlertDialog.Builder(MainActivity.this); //대화 상자 표시
                dialogdate = (View)View.inflate(MainActivity.this, R.layout.datelayout, null); // 메모리에 업로드 // <<중요>>
                datepic = dialogdate.findViewById(R.id.datepic); // <<중요>>
                datepic.init(year, month, day, null);

                dlg.setTitle("날짜를 선택하시오");
                // dlg.setMessage("내용");
                dlg.setView(dialogdate); // <<중요>>
                dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        int y = datepic.getYear();
                        int m = datepic.getMonth() + 1;
                        int d = datepic.getDayOfMonth();
                        edtdate.setText("예약일: "+ y + "년 " + m + "월 " + d + "일");
                    }
                });
                dlg.setNegativeButton("취소", null);
                dlg.show();
            } // end of onclick.btndate
        }); // end of btndate

        
        btntime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dlg = new AlertDialog.Builder(MainActivity.this);
                dialogtime = (View)View.inflate(MainActivity.this, R.layout.timelayout, null); // <<중요>>
                timepic = dialogtime.findViewById(R.id.timepic); // <<중요>>
                dlg.setTitle("시간을 선택하시오");
                // dlg.setMessage("내용");
                dlg.setView(dialogtime); // <<중요>>
                dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        int h = timepic.getHour();
                        int min = timepic.getMinute();
                        edttime.setText("예약시간: "+ h + "시 " + min + "분");
                    }
                });
                dlg.setNegativeButton("취소", null);
                dlg.show();
            } // end of onclick.btntime
        }); // end of btntime

    }
}