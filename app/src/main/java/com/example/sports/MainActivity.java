package com.example.sports;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import org.litepal.crud.DataSupport;
import java.util.List;
import db.Record;
import db.User;


public class MainActivity extends BaseActivity {

    private Button loginBtn;
    private Button regJumpBtn;
    private String phoneNumber;
    private String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);
        // 绑定按钮事件
        loginBtn = findViewById(R.id.login_btn);
        loginBtn.setOnClickListener(e->{
            // 账号密码框
            EditText phoneText = findViewById(R.id.edit_1);
            phoneNumber = String.valueOf(phoneText.getText());
            EditText pwdText = findViewById(R.id.edit_2);
            password = String.valueOf(pwdText.getText());
            // 查询数据
            List<User> user_list = DataSupport.where("phonenumber = ? and password = ?", phoneNumber, password).
                    find(User.class);
            if(user_list.size() > 0){
                Log.d("login data", user_list.toString());
                Intent intent = new Intent(MainActivity.this, IndexActivity.class);
                String n = user_list.get(0).getName();
                intent.putExtra("userName", n);
                startActivity(intent);
            }else{
                Toast.makeText(getApplicationContext(), "password wrong or phone wrong", Toast.LENGTH_LONG).show();
            }
        });
//        loginBtn.setOnClickListener(e->{
//
//            Intent intent = new Intent(MainActivity.this, IndexActivity.class);
//            intent.putExtra("userName", "xyz");
//            startActivity(intent);
//        });
        regJumpBtn = findViewById(R.id.register_btn);
        regJumpBtn.setOnClickListener(e->{
            Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
            startActivity(intent);
        });
    }

    public void init(){
        String[] sports = {"Cycling", "Swimming", "Running"};
        String[] km = {"3km", "1km", "2km"};
        for(int i=0; i<13; i++){
            int index = (int) (Math.random() * sports.length);
            int index1 = (int) (Math.random() * km.length);
            Record record = new Record();
            record.setRecordTime(Record.getCurrentTime());
            record.setDuration("3h 15min");
            record.setSport(sports[index]);
            record.setDistance(km[index1]);
            record.setName("xyz");
            record.save();
        }

    }
}
