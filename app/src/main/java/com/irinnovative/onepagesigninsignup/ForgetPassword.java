package com.irinnovative.onepagesigninsignup;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class ForgetPassword extends AppCompatActivity {
    Button btnBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);
        btnBack=(Button)findViewById(R.id.btnback);//返回按钮
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(ForgetPassword.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}