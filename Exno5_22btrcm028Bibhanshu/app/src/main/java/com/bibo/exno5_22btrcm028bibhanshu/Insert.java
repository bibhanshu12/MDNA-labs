package com.bibo.exno5_22btrcm028bibhanshu;

import android.app.Activity;
import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
public class Insert extends Activity
{
    EditText id,name,number;
    Button insert;
    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_insert);
        id = (EditText)findViewById(R.id.editText1);
        name = (EditText)findViewById(R.id.editText2);
        number = (EditText)findViewById(R.id.editText3);
        insert = (Button)findViewById(R.id.button1);
        insert.setOnClickListener(new OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
// TODO Auto-generated method stub
//Getting the Values from EditText
                String s1 = id.getText().toString();
                String s2 = name.getText().toString();
                String s3 = number.getText().toString();
//Insert Operation
                db = openOrCreateDatabase("myDataBase.db",
                        MODE_PRIVATE, null);
//Query for Inserting Table
                db.execSQL("insert into sample values('"+s1+"','"+s2+"','"+s3+"');");
                Toast.makeText(Insert.this, "Inserted", Toast.LENGTH_LONG).show();
                db.close();
            }
        });
    }
}