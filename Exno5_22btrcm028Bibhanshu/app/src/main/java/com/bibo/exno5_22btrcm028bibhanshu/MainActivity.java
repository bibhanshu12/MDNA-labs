package com.bibo.exno5_22btrcm028bibhanshu;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity
{
    //Defining the Views
    Button create, insert, update, delete, retrive;
    //Defining the Database
    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//Referring the Views
        create = (Button) findViewById(R.id.button1);
        insert = (Button) findViewById(R.id.button2);
        update = (Button) findViewById(R.id.button3);
        delete = (Button) findViewById(R.id.button4);
        retrive = (Button) findViewById(R.id.button5);
//Creating Database
        create.setOnClickListener(new OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
// TODO Auto-generated method stub
//Statement for Creating Database
                db = openOrCreateDatabase("myDataBase.db",
                        MODE_PRIVATE, null);
//Query for Creating Table
                db.execSQL("create table if not exists sample(id varchar,name varchar,number varchar);");
                Toast.makeText(MainActivity.this, "Created", Toast.LENGTH_LONG).show();
                db.close();
            }
        });
//Navigating to insert class for inserting Data into Database
        insert.setOnClickListener(new OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
// TODO Auto-generated method stub
                Intent Inset = new Intent(MainActivity.this,
                        Insert.class);
                startActivity(Inset);
            }
        });
//Navigating to update class for updating Data into Database
        update.setOnClickListener(new OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
// TODO Auto-generated method stub
                Intent Update = new Intent(MainActivity.this,
                        Update.class);
                startActivity(Update);
            }
        });
//Navigating to delete class for deleting Data from Database
        delete.setOnClickListener(new OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
// TODO Auto-generated method stub
                Intent Delete = new Intent(MainActivity.this,
                        Delete.class);
                startActivity(Delete);
            }
        });
//Navigating to retrieve class for retrieving Data from Database
        retrive.setOnClickListener(new OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
// TODO Auto-generated method stub
                Intent Retrive = new Intent(MainActivity.this,
                        Retrive.class);
                startActivity(Retrive);
            }
        });
    }
}
