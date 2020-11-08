package com.example.barnacle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        TextView btn_SignUp = (TextView) findViewById(R.id.btn_SignUp);

        //버튼이 눌리면 activity_sign_up 으로 가게함
        btn_SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent signUpIntent = new Intent(LoginActivity.this, SignUpActivity.class);
                LoginActivity.this.startActivity(signUpIntent);

            }
        });
    }
}