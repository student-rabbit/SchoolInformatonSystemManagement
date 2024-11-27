package com.example.second;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    DatePicker dp;
    EditText edtdiary;
    Button btnwrite;
    String fileName="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dp = findViewById(R.id.datepicker);
        edtdiary = findViewById(R.id.edtdiary);
        btnwrite = findViewById(R.id.btnwrite);

        btnwrite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    FileOutputStream outf = openFileOutput(fileName, Context.MODE_PRIVATE);
                    String str = edtdiary.getText().toString();
                    outf.write(str.getBytes());
                    outf.close();
                    Toast.makeText(getApplicationContext(),fileName  + "저장되었습니다.", Toast.LENGTH_LONG).show();
                }catch (IOException a) {
                    Toast.makeText(getApplicationContext(),fileName  + "가 error", Toast.LENGTH_LONG).show();
                } // end of try catch
            } // end of onclick
        }); // end of btnwrite click

        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);

        dp.init(year, month, day, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker datePicker, int cyear, int cmonth, int cday) {
                fileName = Integer.toString(cyear) + "-" + Integer.toString(cmonth + 1) + "-" + Integer.toString(cday) + ".txt";
                String str = readDialy(fileName);
                edtdiary.setText(str);
                btnwrite.setEnabled(true);
            } // end of ondatechange
        }); // end of init
    } // end of oncreate
    private String readDialy(String fname) {
        String diaryStr = null;
        try {
            FileInputStream intf = openFileInput(fname);
            byte txt[] = new byte[intf.available()];
            intf.read(txt);
            intf.close();
            /*String str = new String(txt);*/
            diaryStr = (new String(txt));
            btnwrite.setText("수정하기");
        } catch (IOException e) {
            edtdiary.setHint("일기 없음");
            btnwrite.setText("새로 저장");
        } // end of try catch
        return  null;
    } // end of readDialy
} // end of MainActivity