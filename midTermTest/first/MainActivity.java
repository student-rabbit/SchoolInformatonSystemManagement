package com.example.midterm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText edt1, edt2;
    TextView txtResult;
    Button btnAdd, btnSub, btnMul, btnDiv, btnRem;
    String num1, num2;  /*문자열 형*/
    Integer res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("초간단 계산기");

        edt1 = findViewById(R.id.edt1);
        edt2 = findViewById(R.id.edt2);
        txtResult = findViewById(R.id.txtResult);
        btnAdd = findViewById(R.id.btnAdd);
        btnSub = findViewById(R.id.btnSub);
        btnMul = findViewById(R.id.btnMul);
        btnDiv = findViewById(R.id.btnDiv);
        btnRem = findViewById(R.id.btnRem);

        /* 클릭 혹은 터치하기 */
        /* 클릭_void 값의 onClick 메소드 */
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num1 = edt1.getText().toString();
                num2 = edt2.getText().toString();
                res = Integer.parseInt(num1) + Integer.parseInt(num2);
                txtResult.setText("결과 : " + res);
            }
        });

        /* 터치_boolean 값의 onTouch 메소드 반드시 return 값이 필요하다. */
        btnSub.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                /*문자*/
                num1 = edt1.getText().toString();
                num2 = edt2.getText().toString();
                res = Integer.parseInt(num1) - Integer.parseInt(num2);
                txtResult.setText("결과 : " + res);
                return false;
            }
        });

        btnMul.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                num1 = edt1.getText().toString();
                num2 = edt2.getText().toString();
                res = Integer.parseInt(num1) * Integer.parseInt(num2);
                txtResult.setText("결과 : " + res);
                return false;
            }
        });
        
        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num1 = edt1.getText().toString();
                num2 = edt2.getText().toString();
                res = Integer.parseInt(num1) / Integer.parseInt(num2);
                txtResult.setText("결과 : " + res);
            }
        });
        
        btnRem.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                num1 = edt1.getText().toString();
                num2 = edt2.getText().toString();
                res = Integer.parseInt(num1) % Integer.parseInt(num2);
                txtResult.setText("결과 : " + res);
                return false;
            }
        });
        
    }
}