package com.example.midtermthird;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView txt;
    RadioGroup rg;
    RadioButton dog, cat, rabbit;
    Button btnSelect;
    ImageView image;
    CheckBox chk;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("애완동물 사진 보기");

        txt = findViewById(R.id.txt);
        rg = findViewById(R.id.rg);
        dog = findViewById(R.id.dog);
        cat = findViewById(R.id.cat);
        rabbit = findViewById(R.id.rabbit);
        btnSelect = findViewById(R.id.btnSelect);
        image = findViewById(R.id.image);
        chk = findViewById(R.id.chk);

        /*체크를 체크하면*/
        chk.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    txt.setVisibility(View.VISIBLE);
                    rg.setVisibility(View.VISIBLE);
                    btnSelect.setVisibility(View.VISIBLE);
                    image.setVisibility(View.VISIBLE);
                } else {
                    txt.setVisibility(View.INVISIBLE);
                    rg.setVisibility(View.INVISIBLE);
                    btnSelect.setVisibility(View.INVISIBLE);
                    image.setVisibility(View.INVISIBLE);
                }
            }
        });
        
        /*버튼을 클릭하면*/
        btnSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (rg.getCheckedRadioButtonId() == R.id.dog)
                {
                    image.setImageResource(R.drawable.dog);
                } else if (rg.getCheckedRadioButtonId() == R.id.cat)
                {
                    image.setImageResource(R.drawable.cat);
                } else if (rg.getCheckedRadioButtonId() == R.id.rabbit)
                {
                    image.setImageResource(R.drawable.rabbit);
                } else {
                    Toast.makeText(getApplicationContext(), "선택 없음", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}