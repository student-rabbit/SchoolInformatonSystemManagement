package com.example.pro01;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 메모리 올리기<중요>
        setContentView(R.layout.second);
        setTitle("두번째 액티비티");
        Button btnReturn;
        btnReturn = findViewById(R.id.btnReturn);
        TextView txResult = findViewById(R.id.txResult);
        Intent secondIntent = getIntent();
        int x = secondIntent.getIntExtra("FIRSTNUM", 0);
        int y = secondIntent.getIntExtra("SECONDNUM", 0);
        String giho = secondIntent.getStringExtra("CALC");
        int r = 0; // r은 지역변수
        if(giho.equals("+")) { r = x + y; }
        else if (giho.equals("-")) { r = x-y; }
        else if (giho.equals("*")) { r = x * y; }
        else if (giho.equals("/")) { r = x/y; }
        else if (giho.equals("%")) { r = x%y; }
        txResult.setText(""+r);
        int result = r;
        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent out = new Intent(getApplicationContext(), MainActivity.class);
                out.putExtra("RESULT",result);
                setResult(RESULT_OK, out);  // 응답 보내기
                finish(); // 중요
            } // end of onClick
        }); // end of btnReturn
    } // end of onCreate
} // end of SecondActicity