package com.example.exno10_22btrcm028bibhanshu;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class SubActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_main);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
// Inflate the menu; this adds items to the action bar if it ispresent.
                getMenuInflater().inflate(R.menu.sub, menu);
        return true;
    }
}