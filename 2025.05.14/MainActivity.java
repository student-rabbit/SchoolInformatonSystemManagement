package com.example.pro01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    MyDBHelper mydb;
    EditText edtName, edtNum, edtNameResult, edtNumResult;
    Button btnInit, btnInsert, btnSelect, btnDelete, btnUpdate;
    SQLiteDatabase sqlDB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);
        setContentView(R.layout.activity_main);
        setTitle("그룹 관리 데이터베이스");
        mydb = new MyDBHelper(this);
        edtName = findViewById(R.id.edtName);
        edtNum = findViewById(R.id.edtNum);
        edtNameResult = findViewById(R.id.edtNameResult);
        edtNumResult = findViewById(R.id.edtNumResult);
        btnInit = findViewById(R.id.btnInit);
        btnInsert = findViewById(R.id.btnInsert);
        btnSelect = findViewById(R.id.btnSelect);
        btnDelete = findViewById(R.id.btnDelete);
        btnUpdate = findViewById(R.id.btnUpdate);
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sqlDB = mydb.getWritableDatabase();
                sqlDB.execSQL("delete from grouptable where gname='" + edtName.getText().toString() + "';");
                sqlDB.close();
            } // end of onclick
        }); // end of delete

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sqlDB = mydb.getWritableDatabase();
                sqlDB.execSQL("update grouptable set gnumber=" + edtNum.getText().toString() + " where gname='" + edtName.getText().toString() + "';");
                sqlDB.close();
            } // end of onClick
        }); // end of update

        btnInit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sqlDB = mydb.getWritableDatabase();
                mydb.onUpgrade(sqlDB, 1, 2);
                sqlDB.close();
            } // end of onClick
        }); // end of Init

        btnSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sqlDB = mydb.getReadableDatabase();
                Cursor cursor;
                cursor = sqlDB.rawQuery("select * from grouptable;", null);
                String strname = "---------------" + "\r\n";
                String strnum = "---------------" + "\r\n";
                while (cursor.moveToNext()) {
                    strname += cursor.getString(0) + "\r\n";
                    strnum += cursor.getString(1) + "\r\n";
                }
                edtNameResult.setText(strname);
                edtNumResult.setText(strnum);
                cursor.close();
                sqlDB.close();
            } // end of onClick
        }); // end of select

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sqlDB = mydb.getWritableDatabase();
                sqlDB.execSQL("insert into grouptable values ('" + edtName.getText().toString() + "', " + edtNum.getText().toString() + ");");
                sqlDB.close();
            } // end of onClick
        }); // end of insert

    } // end of onCreate
    public class MyDBHelper extends SQLiteOpenHelper {
        public MyDBHelper(Context context) {
            super(context, "groupDB", null, 1);
        } // end of MyDBHelper

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("create table grouptable (gname char(20) primary key, gnumber integer);");
        } // end of onCreate

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldversion, int newversion) {
            db.execSQL("drop table if exists grouptable");
            onCreate(db);
        } // end of onUpgrade
    } // end of SQl
} // end of MainActivity