package com.example.bloodbank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class userlogin extends AppCompatActivity {
    Button Signup,login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userlogin);
        Signup=findViewById(R.id.signup);
        login=findViewById(R.id.login);
        Signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent4=new Intent(getApplicationContext(), sign.class);
                startActivity(intent4);
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent5=new Intent(getApplicationContext(),choose.class);
                startActivity(intent5);
            }
        });

    }
}
