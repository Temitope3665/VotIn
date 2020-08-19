package com.example.votin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ForgetPassword extends AppCompatActivity {

    private Button sendEMail, goToLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);

        goToLogin = findViewById(R.id.goToLoginBtn);


        // Go to Login
        goToLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intGoToLogin = new Intent(ForgetPassword.this, Login.class);
                startActivity(intGoToLogin);
                finish();
            }
        });

    }
}
