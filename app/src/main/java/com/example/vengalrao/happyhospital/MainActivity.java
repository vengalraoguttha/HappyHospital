package com.example.vengalrao.happyhospital;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    Button button;
    EditText name,phone,age,email,address;
    RadioButton male,female;
    RadioGroup group;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        male=(RadioButton)findViewById(R.id.male);
        female=(RadioButton)findViewById(R.id.female);
        button=(Button)findViewById(R.id.buttonmain);
        name =(EditText)findViewById(R.id.nametext);
        phone=(EditText)findViewById(R.id.phone);
        age=(EditText)findViewById(R.id.agetext);
        email=(EditText)findViewById(R.id.emailtext);
        address=(EditText)findViewById(R.id.addresstext);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db=openOrCreateDatabase("info1",MODE_PRIVATE,null);
                db.execSQL("drop table patient;");
                db.execSQL("create table patient( name varChar(20),age varChar(20),phone varChar(20),email varChar(20),address varChar(20),c varChar(20));");
                if(male.isChecked())
                db.execSQL("insert into patient values('" + name.getText().toString() + "','" + age.getText().toString() + "','" + phone.getText().toString() + "','" + email.getText().toString() + "','" + address.getText().toString()+"','"+"male" + "')");
                else
                    db.execSQL("insert into patient values('" + name.getText().toString() + "','" + age.getText().toString() + "','" + phone.getText().toString() + "','" + email.getText().toString() + "','" + address.getText().toString()+"','"+"female" + "')");

                String string=null;
                Cursor c=db.rawQuery("select * from patient",null);
                if (c!= null && c.moveToNext()) {
                    string = c.getString(c.getColumnIndex("name"));
                }
                Log.d("msg", string);
                db.close();
                Intent intent=new Intent(MainActivity.this,SecondPage.class);
                startActivity(intent);
                finish();

            }
        });
    }
}
