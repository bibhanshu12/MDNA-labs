package com.example.exno9_22btrcm028bibhanshu;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
public class MainActivity extends Activity {
    TextView tvName;
    TextView tvNumber;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText etName = (EditText) findViewById(R.id.etUserName);
        final EditText etNumber = (EditText)
                findViewById(R.id.editText2);
        final Button btnSave = (Button) findViewById(R.id.btnSave);
        final Button btnLoad = (Button) findViewById(R.id.btnLoad);
        tvName =  findViewById(R.id.tvUserName);
        tvNumber = findViewById(R.id.tvUserNumber);
//        bibhanshu lal karn
        btnSave.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
// Get info out of text boxes
                String name = etName.getText().toString();
                String number = etNumber.getText().toString();
                String eol = System.getProperty("line.separator");
                BufferedWriter writer = null;
                try {
                    writer = new BufferedWriter(new
                            OutputStreamWriter(
                            openFileOutput("userInformation",
                                    MODE_PRIVATE)));
                    writer.write(name + eol);
                    writer.write(number + eol);
                    writer.close();
                    Toast.makeText(getApplicationContext(),
                            "Saved Successfully!",
                            Toast.LENGTH_LONG).show();
                } catch (FileNotFoundException e) {
// TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (IOException e) {
// TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });
        btnLoad.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
// TODO Auto-generated method stub

                BufferedReader reader = null;
                try {
                    reader = new BufferedReader(new
                            InputStreamReader(
                            openFileInput("userInformation")));
                    String line = "";
                    int counter = 0;
                    while ((line = reader.readLine()) != null) {
                        if (counter == 0) {
                            tvName.setText(line);
                            counter++;
                        } else {
                            tvNumber.setText(line);
                        }
                    }
                } catch (FileNotFoundException e) {
// TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (IOException e) {
// TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });
    }
}
