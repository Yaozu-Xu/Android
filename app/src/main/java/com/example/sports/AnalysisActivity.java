package com.example.sports;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;
import org.litepal.crud.DataSupport;
import java.util.List;
import db.Record;

public class AnalysisActivity extends AppCompatActivity {

    Button home;
    Button recordBtn;
    Button analysis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.analysis_layout);

        home = findViewById(R.id.home);
        recordBtn = findViewById(R.id.record);
        analysis = findViewById(R.id.analysis);
        analysis.setTextColor(this.getResources().getColor(R.color.colorOrange));

        home.setOnClickListener(e->{
            Intent intent = new Intent(AnalysisActivity.this, IndexActivity.class);
            startActivity(intent);
        });
        recordBtn.setOnClickListener(e->{
            Intent intent = new Intent(AnalysisActivity.this, RecordActivity.class);
            startActivity(intent);
        });

        TextView run = findViewById(R.id.run_count);
        run.setText(getCount("Running"));

        TextView cyc = findViewById(R.id.cyc_count);
        cyc.setText(getCount("Cycling"));

        TextView swim = findViewById(R.id.swim_count);
        swim.setText(getCount("Swimming"));
    }

    private String getCount(String a){
        List<Record> user_list = DataSupport.where("sport = ?", a).
                    find(Record.class);
        return user_list.size() + " times";
    }

}
