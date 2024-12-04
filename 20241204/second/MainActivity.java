package com.example.second;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("메뉴 만들기");
        image = findViewById(R.id.image);
    } // end of  oncreate

    // 메뉴를 등록하기 위한 메소드
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu1, menu);
        return true;
    } // end of oncreateoprionsmenu

    // 메뉴를 동작
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        super.onOptionsItemSelected(item);
        if(item.getItemId() == R.id.rabbit) {
            image.setImageResource(R.drawable.rabbit);
            return true;
        }
        if(item.getItemId() == R.id.tiger) {
            image.setImageResource(R.drawable.tiger);
            return true;
        }
        if(item.getItemId() == R.id.lion) {
            image.setImageResource(R.drawable.lion);
            return true;
        }
        return false;
    }
} // end of mainactivity