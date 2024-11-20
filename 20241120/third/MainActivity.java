package com.example.myapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {
    RadioGroup rg;
    RadioButton bad, happy, notbad, soso;
    Button button;
    ImageView image;
    View viewdialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("유소영");
        rg = findViewById(R.id.rg);
        bad = findViewById(R.id.bad);
        happy = findViewById(R.id.happy);
        notbad = findViewById(R.id.notbad);
        soso = findViewById(R.id.soso);
        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewdialog = View.inflate(MainActivity.this, R.layout.imagedialog, null);
                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                image = viewdialog.findViewById(R.id.image);
                if(rg.getCheckedRadioButtonId() == R.id.bad){
                    dlg.setTitle(bad.getText().toString());
                    image.setImageResource(R.drawable.bad);
                }
                else if(rg.getCheckedRadioButtonId() == R.id.happy){
                    dlg.setTitle(happy.getText().toString());
                    image.setImageResource(R.drawable.happy);
                }
                else if(rg.getCheckedRadioButtonId() == R.id.notbad){
                    dlg.setTitle(notbad.getText().toString());
                    image.setImageResource(R.drawable.notbad);
                }
                else if(rg.getCheckedRadioButtonId() == R.id.soso){
                    dlg.setTitle(soso.getText().toString());
                    image.setImageResource(R.drawable.soso);
                }
                dlg.setView(viewdialog);
                dlg.setPositiveButton("닫기", null);
                dlg.show();
            }
        });

    }
}