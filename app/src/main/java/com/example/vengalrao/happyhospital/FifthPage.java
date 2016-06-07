package com.example.vengalrao.happyhospital;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class FifthPage extends AppCompatActivity {

    TextView textView;
    Cursor c;
    String string;
    Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fifth_page);
        textView=(TextView)findViewById(R.id.tView51);
        b=(Button)findViewById(R.id.blast);
        SQLiteDatabase db=openOrCreateDatabase("info1",MODE_PRIVATE,null);
        c=db.rawQuery("select * from patient",null);
        if (c!= null && c.moveToNext()) {
            string = c.getString(c.getColumnIndex("name"));
            textView.append("Name: "+string+"\n");
            string = c.getString(c.getColumnIndex("c"));
            textView.append("Gender: "+string+"\n");
            string=c.getString(c.getColumnIndex("age"));
            textView.append("Age: "+string+"\n");
            string=c.getString(c.getColumnIndex("phone"));
            textView.append("Phone Number: "+string+"\n");
            string=c.getString(c.getColumnIndex("email"));
            textView.append("Email-Id: "+string+"\n");
            string=c.getString(c.getColumnIndex("address"));
            textView.append("Address: "+string+"\n");
        }
        db.close();

        db=openOrCreateDatabase("info2",MODE_PRIVATE,null);
        c=db.rawQuery("select * from patient",null);
        if (c!= null && c.moveToNext()) {
            string = c.getString(c.getColumnIndex("ailments1"));
            textView.append("Ailments: "+string+"\n");
            string=c.getString(c.getColumnIndex("ailments2"));
            textView.append(string+"\n");
            string=c.getString(c.getColumnIndex("ailments3"));
            textView.append(string+"\n");
            string=c.getString(c.getColumnIndex("ailments4"));
            textView.append(string+"\n");
            string=c.getString(c.getColumnIndex("checkpage2"));
            textView.append("Previously suffered from any ailments: "+string+"\n");
        }
        db.close();

        db=openOrCreateDatabase("info3",MODE_PRIVATE,null);
        c=db.rawQuery("select * from patient",null);
        if (c!= null && c.moveToNext()) {
            string=c.getString(c.getColumnIndex("c"));
            textView.append("Currently using this medicine: "+string+"\n");
            string = c.getString(c.getColumnIndex("e1"));
            textView.append("Name of medicine: "+string+"\n");
            string=c.getString(c.getColumnIndex("e2"));
            textView.append("Genetic problems: "+string+"\n");
            string=c.getString(c.getColumnIndex("e3"));
            textView.append("Previously suffered from: "+string+"\n");
            string=c.getString(c.getColumnIndex("e4"));
            textView.append("Allergies: "+string+"\n");
        }
        db.close();

        db=openOrCreateDatabase("info4",MODE_PRIVATE,null);
        c=db.rawQuery("select * from patient",null);
        if (c!= null && c.moveToNext()) {
            string=c.getString(c.getColumnIndex("spin"));
            textView.append("Prefered Hospital: "+string+"\n");
            string=c.getString(c.getColumnIndex("c"));
            textView.append("Visited hospital before: "+string+"\n");
            string = c.getString(c.getColumnIndex("e1"));
            textView.append("Prefered Doctor: "+string+"\n");


        }
        db.close();
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(FifthPage.this,"Sucessfully Submitted",Toast.LENGTH_LONG).show();
                finish();
            }
        });
    }
}
