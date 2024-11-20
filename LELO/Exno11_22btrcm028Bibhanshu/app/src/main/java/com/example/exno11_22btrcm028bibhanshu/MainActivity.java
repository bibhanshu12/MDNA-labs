package com.example.exno11_22btrcm028bibhanshu;
import android.Manifest;
import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class MainActivity extends Activity {
    public static int count = 0;
    Button b;
    static ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iv = findViewById(R.id.imageView1);
        iv.setVisibility(View.INVISIBLE);

        b = findViewById(R.id.button1); // Button to initiate the alarm
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
                    checkAlarmPermission();
                } else {
                    Log.e("Alarm", "This feature is only available for Android 12 and above.");
                }
            }
        });
    }

    private void checkAlarmPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
            if (!alarmManager.canScheduleExactAlarms()) {
                Log.e("Alarm", "App is not allowed to schedule exact alarms.");
                openAppSettings(); // Direct the user to settings to enable the permission
                return;
            }

            // Check if the exact alarm permission is granted
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.SCHEDULE_EXACT_ALARM)
                    != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.SCHEDULE_EXACT_ALARM}, 1);
            } else {
                startAlert();
            }
        }
    }

    private void startAlert() {
        iv.setVisibility(View.INVISIBLE);
        EditText text = findViewById(R.id.editText1);
        int time;

        try {
            time = Integer.parseInt(text.getText().toString());
        } catch (NumberFormatException e) {
            Log.e("Alarm", "Invalid time input");
            return;
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S &&
                ContextCompat.checkSelfPermission(this, Manifest.permission.SCHEDULE_EXACT_ALARM)
                        != PackageManager.PERMISSION_GRANTED) {
            Log.e("Alarm", "Exact Alarm permission not granted!");
            return;
        }

        Intent intent = new Intent(this, MyBroadCastReceiver.class);
        PendingIntent pendIntent = PendingIntent.getBroadcast(
                this.getApplicationContext(), 0, intent,
                PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_IMMUTABLE);

        Log.d("Alarm", "Setting alarm for " + time + " seconds");

        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        if (alarmManager != null) {
            try {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    alarmManager.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP,
                            System.currentTimeMillis() + (time * 1000), pendIntent);
                } else {
                    alarmManager.setExact(AlarmManager.RTC_WAKEUP,
                            System.currentTimeMillis() + (time * 1000), pendIntent);
                }
            } catch (SecurityException e) {
                Log.e("Alarm", "Failed to schedule exact alarm: " + e.getMessage());
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 1) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Log.d("Alarm", "Exact Alarm permission granted!");
                startAlert(); // Call startAlert after permission granted
            } else {
                Log.e("Alarm", "Exact Alarm permission denied!");
            }
        }
    }

    // New method to open the app settings page for the user to manually enable the exact alarm permission
    private void openAppSettings() {
        Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
        Uri uri = Uri.fromParts("package", getPackageName(), null);
        intent.setData(uri);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
}
