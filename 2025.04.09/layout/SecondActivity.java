package com.example.pro01;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);
        setTitle("선호도 조사 결과");

        Intent outintent = getIntent();
        /*대괄호 [] 위치는 자율*/
        String [] strName = outintent.getStringArrayExtra("Name");
        int voteResult[] = outintent.getIntArrayExtra("Count");

        TextView tv[] = new TextView[strName.length];
        RatingBar rbar[] = new RatingBar[strName.length];
        Integer tvId [] = {R.id.tv1, R.id.tv2, R.id.tv3, R.id.tv4, R.id.tv5, R.id.tv6, R.id.tv7, R.id.tv8, R.id.tv9};
        Integer rbarId [] = {R.id.rbar1, R.id.rbar2, R.id.rbar3, R.id.rbar4, R.id.rbar5, R.id.rbar6, R.id.rbar7, R.id.rbar8, R.id.rbar9};

        for (int i = 0; i < rbar.length; i++) {     // id 찾기
            tv[i] = findViewById(tvId[i]);
            rbar[i] = findViewById(rbarId[i]);
        }
        for (int i = 0; i < rbar.length; i++) {     // 제목과 별 갯수 넣기
            tv[i].setText(strName[i]);
            rbar[i].setRating(voteResult[i]);
        }

        Button btnReturn = findViewById(R.id.btnReturn);
        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();       // 현재 액티비티 종료, 앱 전체 종료를 원하면 System.ex입력
            } // end of onClick
        }); // end of btnReturn
    } // end of onCreate
} // end of SecondActivity
