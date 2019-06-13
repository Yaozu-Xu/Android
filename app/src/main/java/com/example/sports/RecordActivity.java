package com.example.sports;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import org.litepal.crud.DataSupport;
import java.util.List;


import db.Record;

public class RecordActivity extends AppCompatActivity {

    private List<Record> recordList;
    Button home;
    Button recordBtn;
    Button analysis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.record_layout);

        home = findViewById(R.id.home);
        recordBtn = findViewById(R.id.record);
        analysis = findViewById(R.id.analysis);
        getRecordData();
        // 当前标签改变颜色
        recordBtn.setTextColor(this.getResources().getColor(R.color.colorOrange));
        // 导航栏
        home.setOnClickListener(e->{
            Intent intent = new Intent(RecordActivity.this, IndexActivity.class);
            startActivity(intent);
        });
        analysis.setOnClickListener(e->{
            Intent intent = new Intent(RecordActivity.this, AnalysisActivity.class);
            startActivity(intent);
        });

        // View
        RecyclerView recyclerView =	(RecyclerView) findViewById(R.id.recycler_view);
        LinearLayoutManager layoutManager =	new	LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        RecordAdapter adapter = new RecordAdapter(recordList);
        recyclerView.setAdapter(adapter);
    }

    private void getRecordData(){
        recordList = DataSupport.order("sport").find(Record.class);
    }
}
