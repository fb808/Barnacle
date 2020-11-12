package com.example.barnacle;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class SelfCheckActivity extends AppCompatActivity {

    ImageView imageView;
    EditText birth;
    CheckBox checkBox1, checkBox2, checkBox3, checkBox4, checkBox5;
    CheckBox checkBox6, checkBox7, checkBox8, checkBox9, checkBox10;
    CheckBox checkBox11, checkBox12, checkBox13;
    Button submit;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.self_check);

        imageView = (ImageView) findViewById(R.id.imageView) ;
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SelfCheckActivity.this, MainActivity.class);
                SelfCheckActivity.this.startActivity(intent);
            }

        });
    }
}
