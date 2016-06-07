package com.example.vengalrao.happyhospital;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;

public class FourthPage extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner spinner;
    CheckBox c;
    EditText e1;
    String[] s={"Hospital1","Hospital2","Hospital3","Hospital4","Hospital5"};
    String k;
    Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth_page);
        spinner=(Spinner)findViewById(R.id.spin);
        c=(CheckBox)findViewById(R.id.c41);
        e1=(EditText)findViewById(R.id.e41);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,s);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(this);
        b=(Button)findViewById(R.id.b41);
        b.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                SQLiteDatabase db=openOrCreateDatabase("info4",MODE_PRIVATE,null);
                db.execSQL("drop table if exists patient;");
                db.execSQL("create table patient( e1 varChar(20),spin varChar(20),c varChar(20));");
                if(c.isChecked())
                    db.execSQL("insert into patient values('"+e1.getText().toString()+"','"+k+"','true'"+");");
                else
                    db.execSQL("insert into patient values('"+e1.getText().toString()+"','"+k+"','false'"+");");
                db.close();

                Intent intent=new Intent(FourthPage.this,FifthPage.class);
                startActivity(intent);
                finish();
            }
        });

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        k=spinner.getItemAtPosition(position).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        k=spinner.getItemAtPosition(0).toString();
    }
}
