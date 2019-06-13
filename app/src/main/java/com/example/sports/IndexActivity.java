package com.example.sports;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.litepal.LitePal;

import db.Record;

public class IndexActivity extends AppCompatActivity {

    Button home;
    Button recordBtn;
    Button analysis;
    Button createBtn;
    TextView userText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.index_layout);
        Intent received = getIntent();
        String userName = received.getStringExtra("userName");

        home = findViewById(R.id.home);
        recordBtn = findViewById(R.id.record);
        analysis = findViewById(R.id.analysis);
        userText = findViewById(R.id.name_text);
        createBtn = findViewById(R.id.record_create_btn);
        // 设置当前标签
        home.setTextColor(this.getResources().getColor(R.color.colorOrange));
        // 设置用户名
        userText.setText(userName);
        // 导航栏按钮
        recordBtn.setOnClickListener(e->{
            Intent intent = new Intent(IndexActivity.this, RecordActivity.class);
            startActivity(intent);
        });
        analysis.setOnClickListener(e->{
            Intent intent = new Intent(IndexActivity.this, AnalysisActivity.class);
            startActivity(intent);
        });
        // 创建记录
        createBtn.setOnClickListener(e->{
            // 弹出框
            AlertDialog.Builder builder = new AlertDialog.Builder(IndexActivity.this);
            View alertView = LayoutInflater.from(IndexActivity.this).inflate(R.layout.alert_layout, null);
            AlertDialog dialog = builder.setTitle("New Record").setView(alertView).show();
            // 找到元素
            EditText duration_text = alertView.findViewById(R.id.duration_text);
            EditText distance_text = alertView.findViewById(R.id.distance_text);
            Spinner sp = alertView.findViewById(R.id.sports_spinner);
            Button submitBtn = alertView.findViewById(R.id.record_submit_btn);
            // 绑定事件
            submitBtn.setOnClickListener(e1->{
                // 取值
                String duration = String.valueOf(duration_text.getText());
                String distance = String.valueOf(distance_text.getText());
                String sport = sp.getSelectedItem().toString();
                // 数据库操作
                LitePal.getDatabase();
                Record record = new Record();
                record.setRecordTime(Record.getCurrentTime());
                record.setDuration(duration);
                record.setSport(sport);
                record.setDistance(distance);
                record.setName(userName);
                record.save();
                dialog.dismiss();
                Toast.makeText(getApplicationContext(), "Create new record", Toast.LENGTH_LONG).show();
            });
        });
    }
}
