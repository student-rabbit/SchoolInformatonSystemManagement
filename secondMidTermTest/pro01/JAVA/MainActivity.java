package com.example.pro01;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("main 액티비티");
        Button btnCalc;
        EditText edtFirst, edtSecond;
        RadioGroup rdGroup;
        btnCalc = findViewById(R.id.btnCalc);
        edtFirst = findViewById(R.id.edtFirst);
        edtSecond = findViewById(R.id.edtSecond);
        rdGroup = findViewById(R.id.rdGroup);

        btnCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*중요*/
                Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
                /*입력값을 정수로 변환 - Integer.parseInt*/
                int num1 = Integer.parseInt(edtFirst.getText().toString());
                int num2 = Integer.parseInt(edtSecond.getText().toString());
                intent.putExtra("FIRSTNUM", num1);
                intent.putExtra("SECONDNUM", num2);
                if(rdGroup.getCheckedRadioButtonId()==R.id.rdoAdd) {
                    intent.putExtra("CALC", "+");
                } else if (rdGroup.getCheckedRadioButtonId()==R.id.rdoSub) {
                    intent.putExtra("CALC", "-");
                } else if (rdGroup.getCheckedRadioButtonId()==R.id.rdoMul) {
                    intent.putExtra("CALC", "*");
                } else if (rdGroup.getCheckedRadioButtonId()==R.id.rdoDiv) {
                    intent.putExtra("CALC", "/");
                } else if (rdGroup.getCheckedRadioButtonId()==R.id.rdoSom) {
                    intent.putExtra("CALC", "%");
                } // end of else if rdGroup
                startActivityForResult(intent, 0);// /*중요-양방향 인텐트*/ startActivity(intent);
            } // end of onClick
        }); // end of btnCalc
    } // end of onCreate
    // 양방향 인텐트에서 값 받아오기-주거니받거니
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK) {
            int zzz = data.getIntExtra("RESULT", 0);
            Toast.makeText(getApplicationContext(), "결과= " + zzz , Toast.LENGTH_SHORT).show();
        }
    } // end of onActivityResult
} // end of MainActivity