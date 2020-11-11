package com.example.barnacle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView to_learn, self_check, write, map, ex_app;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        to_learn = (TextView) findViewById(R.id.to_learn);
        to_learn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(MainActivity.this, 새로운.class);
//                MainActivity.this.startActivity(intent);
            }
        });

        self_check = (TextView) findViewById(R.id.self_check);
        self_check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(MainActivity.this, 새로운.class);
//                MainActivity.this.startActivity(intent);
            }
        });

        write = (TextView) findViewById(R.id.write);
        write.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(MainActivity.this, 새로운.class);
//                MainActivity.this.startActivity(intent);
            }
        });

        map = (TextView) findViewById(R.id.map);
        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(MainActivity.this, 새로운.class);
//                MainActivity.this.startActivity(intent);
            }
        });

        ex_app = (TextView) findViewById(R.id.ex_app);
        ex_app.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(MainActivity.this, 새로운.class);
//                MainActivity.this.startActivity(intent);
            }
        });


    }
}