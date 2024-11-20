package com.example.myapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button button1, button2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);

        button2.setOnClickListener(new View.OnClickListener() {
            String ani[] = {"고양이", "강아지", "표범", "호랑이"};
            boolean check[] = {false, false, false, false};
            @Override
            public void onClick(View view) {
                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                dlg.setTitle("목록형 대화상자");
                dlg.setIcon(R.mipmap.ic_launcher);

                dlg.setMultiChoiceItems(ani, check, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                        button2.setText(ani[i]);
                    } // end of onclick
                }); // end of multichoiceItems

               /*
                dlg.setItems(ani, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        button2.setText(ani[i]);
                        Toast.makeText(getApplicationContext(), ani[i]+"선택", Toast.LENGTH_LONG).show();
                    } // end of onclick
                }); // end of setItems
               */

              /*
               dlg.setSingleChoiceItems(ani, 0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        button2.setText(ani[i]);
                    } // end of onclick
                }); // end of setsingleChoiceItems
               */

                dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getApplicationContext(), "확인눌렀어", Toast.LENGTH_LONG).show();
                    }
                });

                dlg.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getApplicationContext(), "취소눌렀어", Toast.LENGTH_LONG).show();
                    }
                });

                dlg.show();
                
            } // end of onclick
        }); // end of button2 clicklistenser

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                dlg.setTitle("제목");
                dlg.setMessage("내용");
                dlg.setIcon(R.mipmap.ic_launcher); // 기본적으로 제공되는 아이콘
                /*dlg.setPositiveButton("확인", null); // 긍정의 버튼_null 은 동작은 안 한다.*/
                dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getApplicationContext(), "확인눌렀어", Toast.LENGTH_LONG).show();
                    }
                }); // end of 긍정의 버튼

                /*dlg.setNegativeButton("취소", null); // 취소의 버튼*/
                dlg.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getApplicationContext(), "취소눌렀어", Toast.LENGTH_LONG).show();
                    }
                }); // end of 취소의 버튼

                dlg.show(); // 반드시 마지막에는 show가 입력되어야 한다.

            } // end of onclick
        }); // end of button1 clicklistenser

    } // end of oncreate
} // end of main class