package com.example.pro01;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.Gallery;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class GalleryActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gallery);
        setTitle("갤러리 포스터");

        Button btngrid = findViewById(R.id.btngrid);
        btngrid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            } // end of onClick
        }); // end of btngo
        Gallery gallery = findViewById(R.id.gallery1);
        MyGallery galadapter = new MyGallery(this);
        gallery.setAdapter(galadapter);
    } // end of onCreate
    public class MyGallery extends BaseAdapter{
        Context context;

        MyGallery(Context c) {
            context = c;
        }

        Integer [] posterID = {R.drawable.lego1, R.drawable.lego2, R.drawable.lego3, R.drawable.lego4, R.drawable.lego5, R.drawable.lego6, R.drawable.lego7, R.drawable.lego8, R.drawable.lego9, R.drawable.lego10,R.drawable.lego1, R.drawable.lego2, R.drawable.lego3, R.drawable.lego4, R.drawable.lego5, R.drawable.lego6, R.drawable.lego7, R.drawable.lego8, R.drawable.lego9, R.drawable.lego10,R.drawable.lego1, R.drawable.lego2, R.drawable.lego3, R.drawable.lego4, R.drawable.lego5, R.drawable.lego6, R.drawable.lego7, R.drawable.lego8, R.drawable.lego9, R.drawable.lego10,R.drawable.lego1, R.drawable.lego2, R.drawable.lego3, R.drawable.lego4, R.drawable.lego5, R.drawable.lego6, R.drawable.lego7, R.drawable.lego8, R.drawable.lego9, R.drawable.lego10 };

        @Override
        public int getCount() {
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

        @Override
        public View getView(int position, View view, ViewGroup viewGroup) {
            ImageView imageView = new ImageView(context);
            imageView.setLayoutParams(new Gallery.LayoutParams(200, 300));    // 크기
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER); // 그리드의 중앙에 배치
            imageView.setPadding(2, 0, 2, 100);   // 여백
            imageView.setImageResource(posterID[position]); // 이미지 불러오기
            final  int pos = position;
            imageView.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    ImageView ivposter = findViewById(R.id.ivposter2);
                    ivposter.setScaleType(ImageView.ScaleType.FIT_CENTER);
                    ivposter.setImageResource(posterID[pos]);
                    return false;
                } // end of onTouch
            }); // end of imageView
            return imageView;
        }
    }
} // end of GalleryActivity
