package com.example.barnacle;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SignUpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        TextView btn_login = (TextView) findViewById(R.id.btn_login);

        //버튼이 눌리면 activity_login 으로 돌아감
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent loginIntent = new Intent(SignUpActivity.this, LoginActivity.class);
                SignUpActivity.this.startActivity(loginIntent);

            }
        });
    }
}
