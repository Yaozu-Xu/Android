package com.example.sports;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

public class IndexBaseActivity extends AppCompatActivity {

    Button home;
    Button recordBtn;
    Button analysis;

    @Override
    protected void onCreate(Bundle savedInstanceState)	{
        super.onCreate(savedInstanceState);
        ActivityCollector.addActivity(this);

        home = findViewById(R.id.home);
        recordBtn = findViewById(R.id.record);
        analysis = findViewById(R.id.analysis);
    }

    @Override
    protected void onDestroy()	{
        super.onDestroy();
        ActivityCollector.removeActivity(this);
    }
}
