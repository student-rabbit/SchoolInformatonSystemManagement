package com.example.pro02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        // setContentView(new Customview(this));
        // setContentView(new BilliardBall(this));
        setContentView(new Myimage(this));// 메모리 업로드
    }
}