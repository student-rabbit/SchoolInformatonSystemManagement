package com.example.pro01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button plus, cancle, mul;
    EditText num1, num2;
    TextView result;
    Integer res;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        plus=findViewById(R.id.plus);
        mul=findViewById(R.id.mul);
        cancle=findViewById(R.id.cancle);
        num1=findViewById(R.id.num1);
        num2=findViewById(R.id.num2);
        result=findViewById(R.id.result);
        num1.setText("" + (int)((Math.random()*100)+1));
        num2.setText("" + (int)((Math.random()*100)+1));

        plus.setOnClickListener(this);
        cancle.setOnClickListener(this);
        mul.setOnClickListener(this);

//        plus.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                res = Integer.parseInt(num1.getText().toString()) + Integer.parseInt(num2.getText().toString());
//                result.setText("합" + res.toString());
//            }
//        }); // end of plus click
//
//        cancle.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                num1.setText("");
//                num2.setText("");
//                result.setText("");
//            }
//        }); // end of cancle click
    } // end of oncreate

    @Override
    public void onClick(View view) {
        if (view == plus){
            res = Integer.parseInt(num1.getText().toString()) + Integer.parseInt(num2.getText().toString());
            result.setText("합" + res.toString());
        }
        else if (view == mul) {
            res = Integer.parseInt(num1.getText().toString()) * Integer.parseInt(num2.getText().toString());
            result.setText("합" + res.toString());
        }
        else if (view == cancle) {
            num1.setText("");
            num2.setText("");
            result.setText("");
        }

    }
} // end of class