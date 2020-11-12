package com.example.barnacle;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button to_login, to_learn, self_check, write, map, ex_app;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        to_login = (Button) findViewById(R.id.login_out);
//        to_login.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
//                MainActivity.this.startActivity(intent);
//            }
//        });

        to_learn = (Button) findViewById(R.id.to_learn);
        to_learn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ToLearnActivity.class);
                MainActivity.this.startActivity(intent);
            }
        });

        self_check = (Button) findViewById(R.id.self_check);
        self_check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SelfCheckActivity.class);
                MainActivity.this.startActivity(intent);
            }
        });

//        write = (Button) findViewById(R.id.write);
//        write.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
////                Intent intent = new Intent(MainActivity.this, 새로운.class);
////                MainActivity.this.startActivity(intent);
//            }
//        });

        map = (Button) findViewById(R.id.map);
        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MapActivity.class);
                MainActivity.this.startActivity(intent);
            }
        });

        ex_app = (Button) findViewById(R.id.ex_app);
        ex_app.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(MainActivity.this, 새로운.class);
//                MainActivity.this.startActivity(intent);
            }
        });

//        Google_Login = (SignInButton) findViewById(R.id.Google_Login);
////        Google_Login.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View view) {
////                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
////                MainActivity.this.startActivity(intent);
////            }
////        });


    }
}