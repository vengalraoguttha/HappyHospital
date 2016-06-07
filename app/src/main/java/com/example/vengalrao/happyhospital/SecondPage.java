package com.example.vengalrao.happyhospital;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class SecondPage extends AppCompatActivity {

    Button b;
    CheckBox c;
    EditText e1,e2,e3,e4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_page);
        e1=(EditText)findViewById(R.id.e1);
        e2=(EditText)findViewById(R.id.e2);
        e3=(EditText)findViewById(R.id.e3);
        e4=(EditText)findViewById(R.id.e4);
        c=(CheckBox)findViewById(R.id.c1);
        b=(Button)findViewById(R.id.b1);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db=openOrCreateDatabase("info2",MODE_PRIVATE,null);
                db.execSQL("drop table patient;");
                db.execSQL("create table patient( ailments1 varChar(20),ailments2 varChar(20),ailments3 varChar(20),ailments4 varChar(20),checkpage2 varChar(20));");
                if(c.isChecked())
                db.execSQL("insert into patient values('"+e1.getText().toString()+"','"+e2.getText().toString()+"','"+e3.getText().toString()+"','"+e4.getText().toString()+"','true'"+");");
                else
                    db.execSQL("insert into patient values('"+e1.getText().toString()+"','"+e2.getText().toString()+"','"+e3.getText().toString()+"','"+e4.getText().toString()+"','false'"+");");
                db.close();

                Intent intent=new Intent(SecondPage.this,ThirdPage.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
