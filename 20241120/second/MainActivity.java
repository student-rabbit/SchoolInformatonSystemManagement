package com.example.myapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button userbtn;
    EditText dlgname, dlgmail;
    TextView userid, usermail;
    View viewdialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userbtn = findViewById(R.id.userbtn);
        userid = findViewById(R.id.userid);
        usermail = findViewById(R.id.usermail);
        userbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewdialog = (View) View.inflate(MainActivity.this, R.layout.dialog1, null);
                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                dlg.setTitle("상용자 정보 입력");
                dlg.setIcon(R.mipmap.ic_launcher);
                dlg.setView(viewdialog);
                dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dlgname = viewdialog.findViewById(R.id.dlgname);
                        dlgmail = viewdialog.findViewById(R.id.dlgmail);
                        userid.setText(dlgname.getText().toString());
                        usermail.setText(dlgmail.getText().toString());
                    } // end of onclick
                }); // end of Positive
                dlg.setNegativeButton("취소", null);
                dlg.show();
            } // end of onclick
        }); // end of userbtn onclicklistener
    } // end of oncrate
} // end of mainacticity