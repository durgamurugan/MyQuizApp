package com.example.dd.myquizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    DatabaseHelper db;
    EditText edusr,edpasswd,edcnfpasswd;
    Button bRegister;
    TextView tvlogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        db = new DatabaseHelper(this);
        edusr = findViewById(R.id.edtxtusername);
        edpasswd = findViewById(R.id.edtxtpassword);
        edcnfpasswd = findViewById(R.id.edtxt_cnf_password);
        bRegister = findViewById(R.id.btnRegister);
        tvlogin = findViewById(R.id.textview_login);

        tvlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent LoginIntent = new Intent(RegisterActivity.this,LoginActivity.class);
                startActivity(LoginIntent);
            }
        });

        bRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = edusr.getText().toString().trim();
                String pwd = edpasswd.getText().toString().trim();
                String cnf_pwd = edcnfpasswd.getText().toString().trim();
                if (pwd.equals(cnf_pwd))
                {
                    long val = db.addUser(user,pwd);
                    if(val > 0)
                    {
                        Toast.makeText(RegisterActivity.this, "Registered Successfuly", Toast.LENGTH_SHORT).show();
                        Intent moveToLogin = new Intent(RegisterActivity.this,LoginActivity.class);
                        startActivity(moveToLogin);
                    }
                    else
                    {
                        Toast.makeText(RegisterActivity.this, "Registration Error!!!", Toast.LENGTH_SHORT).show();
                    }
                }

                else
                {
                    Toast.makeText(RegisterActivity.this, "Password Error!!!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    }

