package com.example.vengalrao.happyhospital;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class ThirdPage extends AppCompatActivity {

    Button b;
    CheckBox c;
    EditText e1,e2,e3,e4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third_page);
        b=(Button)findViewById(R.id.b3);
        c=(CheckBox)findViewById(R.id.cpage3);
        e1=(EditText)findViewById(R.id.e31);
        e2=(EditText)findViewById(R.id.e32);
        e3=(EditText)findViewById(R.id.e33);
        e4=(EditText)findViewById(R.id.e34);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db=openOrCreateDatabase("info3",MODE_PRIVATE,null);
                db.execSQL("drop table patient;");
                db.execSQL("create table patient( e1 varChar(20),e2 varChar(20),e3 varChar(20),e4 varChar(20),c varChar(20));");
                if(c.isChecked())
                    db.execSQL("insert into patient values('"+e1.getText().toString()+"','"+e2.getText().toString()+"','"+e3.getText().toString()+"','"+e4.getText().toString()+"','true'"+");");
                else
                    db.execSQL("insert into patient values('"+e1.getText().toString()+"','"+e2.getText().toString()+"','"+e3.getText().toString()+"','"+e4.getText().toString()+"','false'"+");");               db.close();

                Intent intent=new Intent(ThirdPage.this,FourthPage.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
