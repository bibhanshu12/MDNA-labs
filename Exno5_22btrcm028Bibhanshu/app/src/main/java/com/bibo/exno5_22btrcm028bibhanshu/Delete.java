package com.bibo.exno5_22btrcm028bibhanshu;

import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Delete extends Activity
{
    EditText Id;
    Button del;
    SQLiteDatabase db;
    @Override

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);
        Id = (EditText)findViewById(R.id.editText1);
        del = (Button)findViewById(R.id.button1);
        del.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View arg0)
            {
// TODO Auto-generated method stub
//Getting the Values from EditText
                String s1 = Id.getText().toString();
//Delete Operation
                db = openOrCreateDatabase("myDataBase.db",
                        MODE_PRIVATE, null);
//Query for Deleting Table
                db.execSQL("delete from sample where id='"+s1+"';");
                Toast.makeText(Delete.this, "ID :"+s1+" "+"Deleted", Toast.LENGTH_LONG).show();
                        db.close();
            }
        });
    }
}