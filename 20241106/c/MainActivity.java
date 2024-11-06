package com.example.myappsecond;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity {
    Button pre, next;
    ViewFlipper vf;
    ImageView sad;
    EditText ids, pws;
    Button log;
    TextView result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pre = findViewById(R.id.pre);
        next = findViewById(R.id.next);
        vf = findViewById(R.id.vf);
        ids = findViewById(R.id.ids);
        pws = findViewById(R.id.pws);
        log = findViewById(R.id.log);
        result = findViewById(R.id.result);

        pre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vf.showPrevious(); // 이전화면
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vf.showNext(); // 다음화면
            }
        });
        
        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String n1 = ids.getText().toString();
                String n2 = pws.getText().toString();
                if (n1.equals("sad") && n2.equals("today")) {
                    result.setText("로그인 성공");
                    result.setTextColor(Color.WHITE);
                }
                else{
                    result.setText("로그인 실패");
                }
            }
        });

    } // end of onCreate method
} // end of main class