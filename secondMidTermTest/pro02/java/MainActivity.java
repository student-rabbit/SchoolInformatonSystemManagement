package com.example.pro01;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("계절별 꽃 선호도 조사");
        Button btnResult = findViewById(R.id.btnResult);
        int voteCount [] = new int[9];
        for (int i = 0; i < 9; i++)
            voteCount[i] = 0;       //0으로 초기화
        ImageView image[] = new ImageView[9];
        Integer imageId[] = {R.id.iv1, R.id.iv2, R.id.iv3, R.id.iv4, R.id.iv5, R.id.iv6, R.id.iv7, R.id.iv8, R.id.iv9};
        String imgName[] = {"벛꽃", "목련", "튤립", "라벤터", "해바라기", "코스모스", "국화", "동백꽃", "호랑가시나무"};
        for (int i = 0; i < imageId.length; i++) {
            final int index;      // 변경하지 않는 상수는 final을 붙인다.
            index = i;
            image[index] = findViewById(imageId[index]);
            image[index].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    voteCount[index]++;
                    Toast.makeText(getApplicationContext(), imgName[index] + "  총: " + voteCount[index] + "표", Toast.LENGTH_SHORT).show();
                } // end of onClick
            }); // end of image[index]
        } // end of for i
        btnResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
                intent.putExtra("Count", voteCount);
                intent.putExtra("Name", imgName);
                startActivity(intent); /*단방향*/
            } // end of onClick
        }); // end of btnResult
    } // end of onCreate
} // end of MainActivity
