package com.example.myapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    LinearLayout baseLayout;
    Button button1, button2, button3, button4, button5;
    ImageView img;
    TextView txTitle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("메뉴 만들기");
        baseLayout = findViewById(R.id.baseLayout);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        registerForContextMenu(button2);
        registerForContextMenu(button3);
        registerForContextMenu(button4);
        txTitle = findViewById(R.id.txTitle);
        img = findViewById(R.id.img);
    } // end of onCreate

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        // 메뉴 파일을 등록
        MenuInflater menuInflater = getMenuInflater();
        if (v == button2) {
            menuInflater.inflate(R.menu.manu2, menu);
        } // end of if
        if (v == button3) {
            menuInflater.inflate(R.menu.manu3, menu);
        } // end of if
        if (v == button4) {
            menuInflater.inflate(R.menu.manu4, menu);
        } // end of if
//        if (v == img) {
//            menuInflater.inflate(R.menu.manu5, menu);
//        } // end of if

    } // end of oncreatecontextmenu

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        super.onContextItemSelected(item);
        // 메뉴가 동작
        if(item.getItemId() == R.id.itemRed) {
            baseLayout.setBackgroundColor(Color.parseColor("fff"));
            return true;
        } // end of if
        else if(item.getItemId() == R.id.itemGreen) {
            baseLayout.setBackgroundColor(Color.GREEN);
            return true;
        } // end of if
        else if(item.getItemId() == R.id.itemBlue) {
            baseLayout.setBackgroundColor(Color.BLUE);
            return true;
        } // end of if
        else if(item.getItemId() == R.id.itemWhite) {
            baseLayout.setBackgroundColor(Color.WHITE);
            return true;
        } // end of if
        else if(item.getItemId() == R.id.subSize) {
            button1.setScaleX(2);
            button1.setScaleY(2);
            return true;
        } // end of if
        else if(item.getItemId() == R.id.subRotate) {
            button1.setRotation(45);
            return true;
        } // end of if
        else if(item.getItemId() == R.id.itemreset) {
            button1.setRotation(0);
            baseLayout.setBackgroundColor(Color.WHITE);
            button1.setScaleX(1);
            button1.setScaleY(1);
            txTitle.setTextColor(Color.BLACK);
            txTitle.setTextSize(20);
            return true;
        } // end of if
        else if(item.getItemId() == R.id.trTxColor) {
            txTitle.setTextColor(Color.RED);
            return true;
        } // end of if
        else if(item.getItemId() == R.id.trTxSize) {
            txTitle.setTextSize(30);
            return true;
        } // end of if
        return false;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        // 메뉴를 등록
        MenuInflater menuInflater = getMenuInflater();  // 불러오기
        menuInflater.inflate(R.menu.manu5, menu);
        return true;
    } // end of oncreateoptionmenu

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        super.onOptionsItemSelected(item);
        // 메뉴가 동작
//        if(item.getItemId() == R.id.itemRed) {
//            baseLayout.setBackgroundColor(Color.parseColor("fff"));
//            return true;
//        } // end of if
//        else if(item.getItemId() == R.id.itemGreen) {
//            baseLayout.setBackgroundColor(Color.GREEN);
//            return true;
//        } // end of if
//        else if(item.getItemId() == R.id.itemBlue) {
//            baseLayout.setBackgroundColor(Color.BLUE);
//            return true;
//        } // end of if
//        else if(item.getItemId() == R.id.itemWhite) {
//            baseLayout.setBackgroundColor(Color.WHITE);
//            return true;
//        } // end of if
//        else if(item.getItemId() == R.id.subSize) {
//            button1.setScaleX(2);
//            button1.setScaleY(2);
//            return true;
//        } // end of if
//        else if(item.getItemId() == R.id.subRotate) {
//            button1.setRotation(45);
//            return true;
//        } // end of if
//        else if(item.getItemId() == R.id.itemreset) {
//            button1.setRotation(0);
//            button1.setScaleX(1);
//            button1.setScaleY(1);
//            txTitle.setTextColor(Color.BLACK);
//            txTitle.setTextSize(20);
//            return true;
//        } // end of if
//        else if(item.getItemId() == R.id.trTxColor) {
//            txTitle.setTextColor(Color.RED);
//            return true;
//        } // end of if
//        else if(item.getItemId() == R.id.trTxSize) {
//            txTitle.setTextSize(30);
//            return true;
//        } // end of if
         if(item.getItemId() == R.id.imgFirst) {
            img.setImageResource(R.drawable.cath);
            return true;
        } // end of if
        else if(item.getItemId() == R.id.imgSecond) {
            img.setImageResource(R.drawable.starbucks1);
            return true;
        } // end of if
        else if(item.getItemId() == R.id.imgThird) {
            img.setImageResource(R.drawable.starbucks2);
            return true;
        } // end of if
        return false;
    } // end of onoptionsitemselected
}