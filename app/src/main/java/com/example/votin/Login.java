package com.example.votin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity {

    private TextView signUp, forgetPassword;
    private Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        signUp = findViewById(R.id.textSignUp);
        forgetPassword = findViewById(R.id.forgotPasswordText);
        login = findViewById(R.id.loginButton);

        // Sign Up
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intSignUp = new Intent (Login.this, SignUp.class);
                startActivity(intSignUp);
                finish();
            }
        });

        // Forget Password
        forgetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intForgetPassword = new Intent (Login.this, ForgetPassword.class);
                startActivity(intForgetPassword);
                finish();
            }
        });

        // Login
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intHome = new Intent (Login.this, Home.class);
                startActivity(intHome);
                overridePendingTransition(0, 0);
                finish();
            }
        });
    }
}
