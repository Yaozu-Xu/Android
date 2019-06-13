package com.example.sports;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.litepal.LitePal;

import db.User;

public class RegisterActivity extends BaseActivity {

    Button register_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_layout);

        Typeface font = Typeface.createFromAsset(getAssets(), "fontawesome-webfont.ttf");
        TextView back = findViewById(R.id.register_back);
        back.setTypeface(font);
        back.setOnClickListener(e->{
            Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
            startActivity(intent);
        });


        register_btn = findViewById(R.id.register_submit_btn);
        register_btn.setOnClickListener(e->{
            EditText e1 = findViewById(R.id.edit_1);
            EditText n = findViewById(R.id.edit_name);
            EditText e2 = findViewById(R.id.edit_2);
            String phoneNumber = String.valueOf(e1.getText());
            String name = String.valueOf(n.getText());
            String password = String.valueOf(e2.getText());
            // 数据为空
            if(phoneNumber.equals("null") || name.equals("null") || password.equals("null")){
                Toast.makeText(getApplicationContext(), "can't be blanked", Toast.LENGTH_LONG).show();
            }else{
                LitePal.getDatabase();
                User user = new User();
                user.setName(name);
                user.setPhoneNumber(phoneNumber);
                user.setPassWord(password);
                user.save();
                Toast.makeText(getApplicationContext(), "sign in successfully", Toast.LENGTH_LONG).show();
                // 刷新
                e1.setText("");
                n.setText("");
                e2.setText("");
            }
        });
    }
}
