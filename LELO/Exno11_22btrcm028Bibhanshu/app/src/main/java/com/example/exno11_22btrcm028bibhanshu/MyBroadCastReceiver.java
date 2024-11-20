package com.example.exno11_22btrcm028bibhanshu;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class MyBroadCastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d("Alarm", "Alarm triggered!");
        Toast.makeText(context, "Times Up!!!!", Toast.LENGTH_LONG).show();
    }
}