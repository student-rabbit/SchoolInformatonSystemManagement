package com.example.pro04;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button tiger, lion, cat;
    private final int F1=1, F2=2, F3=3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tiger = findViewById(R.id.tiger);
        lion = findViewById(R.id.lion);
        cat = findViewById(R.id.cat);

        tiger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                frameView(F1);
            }
        });

        lion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                frameView(F2);
            }
        });

        cat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                frameView(F3);
            }
        });
    } // end of oncreate

    public void frameView(int flag){
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

            switch (flag){
                case 1:
                    Tigerjava tigerjava = new Tigerjava();
                    transaction.replace(R.id.frame, tigerjava);
                    transaction.commit();
                    break;
                case 2:
                    Lionjava lionjava = new Lionjava();
                    transaction.replace(R.id.frame, lionjava);
                    transaction.commit();
                    break;
                case 3:
                    Catjava catjava = new Catjava();
                    transaction.replace(R.id.frame, catjava);
                    transaction.commit();
                    break;
            }
    } // end of frameView
} // end of class