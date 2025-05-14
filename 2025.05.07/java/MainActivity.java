package com.example.pro01;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("그리드 뷰");
        final GridView gv = findViewById(R.id.grid1);
        MyGrid gadapter = new MyGrid(this);
        gv.setAdapter(gadapter);
        Button btngo = findViewById(R.id.btngo);
        btngo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), GalleryActivity.class);
                startActivity(intent);
            } // end of onClick
        }); // end of btngo
    } // end of onCreate
    public class MyGrid extends BaseAdapter {   // baseadapter는 추상 클래스. ctrl + I -> 필요한 메소드 자동 추가
        Context context;    // 시스템 자원을 접근하는 추상 클래스
        MyGrid (Context c) {    // 생성자 초기화
            context = c;
        }
        Integer [] posterID = {R.drawable.lego1, R.drawable.lego2, R.drawable.lego3, R.drawable.lego4, R.drawable.lego5, R.drawable.lego6, R.drawable.lego7, R.drawable.lego8, R.drawable.lego9, R.drawable.lego10,R.drawable.lego1, R.drawable.lego2, R.drawable.lego3, R.drawable.lego4, R.drawable.lego5, R.drawable.lego6, R.drawable.lego7, R.drawable.lego8, R.drawable.lego9, R.drawable.lego10,R.drawable.lego1, R.drawable.lego2, R.drawable.lego3, R.drawable.lego4, R.drawable.lego5, R.drawable.lego6, R.drawable.lego7, R.drawable.lego8, R.drawable.lego9, R.drawable.lego10,R.drawable.lego1, R.drawable.lego2, R.drawable.lego3, R.drawable.lego4, R.drawable.lego5, R.drawable.lego6, R.drawable.lego7, R.drawable.lego8, R.drawable.lego9, R.drawable.lego10 };
        
        @Override
        public int getCount() { // 갯수 반환
            return posterID.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        // getView() : 그리드뷰에 보일 이미지 뷰를 생성하여 보여줌
        @Override
        public View getView(int position, View view, ViewGroup viewGroup) {
            ImageView imageView = new ImageView(context);
            imageView.setLayoutParams(new GridView.LayoutParams(200, 300));    // 크기
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER); // 그리드의 중앙에 배치
            imageView.setPadding(2, 0, 2, 100);   // 여백
            imageView.setImageResource(posterID[position]); // 이미지 불러오기

            final  int pos = position;
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // 메모리에 업로드
                    View dialogView = View.inflate(MainActivity.this, R.layout.dialog, null);
                    AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                    ImageView ivPoster = dialogView.findViewById(R.id.ivposter);
                    ivPoster.setImageResource(posterID[pos]);
                    dlg.setTitle("큰 포스터");
                    dlg.setView(dialogView);
                    dlg.setNegativeButton("닫기", null);
                    dlg.show();
                } // end of onClick
            }); // end of imageView
            return imageView;
        } // end of getView
    } // end of class for MyGrid
} // end of MainActivity
/*    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("리스트 뷰");

        final String mid [] = {"JAVA","C","mongoDB","mariaDB", "MSSQL","MYSQL", "DEV-C++", "PostgreSQL", "JAVA","C","mongoDB","mariaDB", "MSSQL","MYSQL", "DEV-C++", "PostgreSQL", "JAVA","C","mongoDB","mariaDB", "MSSQL","MYSQL", "DEV-C++", "PostgreSQL"};

*//*
        ListView list = findViewById(R.id.list1);
*//*
        Spinner spin = findViewById(R.id.spin1);
        TextView txt = findViewById(R.id.txt);
*//*
        ArrayAdapter <String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, mid);
        list.setAdapter(adapter);
*//*
        ArrayAdapter <String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, mid);
        spin.setAdapter(adapter);
        spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(), mid[i], Toast.LENGTH_SHORT).show();
                txt.setText("선택: " + mid[i]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });  // end of spin
*//*        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(), mid[i], Toast.LENGTH_SHORT).show();
            } // end of onItemClick
        }); // end of list
*//*
    } // end of onCreate
*/