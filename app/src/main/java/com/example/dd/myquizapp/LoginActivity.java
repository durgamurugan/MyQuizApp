package com.example.dd.myquizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    EditText edusr,edpasswd;
    Button blogin;
    TextView tvReg;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new DatabaseHelper(this);
        edusr = findViewById(R.id.edtxtusername);
        edpasswd = findViewById(R.id.edtxtpassword);
        blogin = findViewById(R.id.btnlogin);
        tvReg = findViewById(R.id.textview_register);

        tvReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerIntent = new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(registerIntent);


            }
        });
        blogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = edusr.getText().toString().trim();
                String pwd = edpasswd.getText().toString().trim();
                Boolean res = db.checkUser(user,pwd);
                if(res == true)
                {
                    Intent Homepage = new Intent(LoginActivity.this,Quiz1Activity.class);
                    startActivity(Homepage);
                }
                else
                {
                    Toast.makeText(LoginActivity.this, "Login Error!!!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    }

