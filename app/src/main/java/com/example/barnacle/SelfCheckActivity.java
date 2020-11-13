package com.example.barnacle;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class SelfCheckActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {

    ImageView imageView;
    EditText birth;
    CheckBox checkBox1, checkBox2, checkBox3, checkBox4, checkBox5;
    CheckBox checkBox6, checkBox7, checkBox8, checkBox9, checkBox10;
    CheckBox checkBox11, checkBox12, checkBox13;
    Button submit;
    private String[] vaccin = new String[]{"인플루엔자(Flu)", "폐렴구균(PPSV)", "폐렴구균(PCV)", "파상풍/디프테리아(백일해)/(Tdap/Td)", "A형간염(HepA)", "B형간염(HepB)",
            "수두(Var)", "홍역/유행성 이하선염/풍진 (MMR)", "대상포진(HZV)", "수막구균(MCV4)", "b형 헤모필루스 인플루엔자(Hib)", "폴리오(IPV)"};
    int birth_num;
    boolean[] disease;
    CheckBox[] setOfCheckBoxes;

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

        birth = (EditText) findViewById(R.id.birth);
        birth_num = Integer.parseInt(birth.getText().toString()); //정수값 가져오기

        setOfCheckBoxes = new CheckBox[]{
            (CheckBox) findViewById(R.id.checkBox1),
            (CheckBox) findViewById(R.id.checkBox2),
            (CheckBox) findViewById(R.id.checkBox3),
            (CheckBox) findViewById(R.id.checkBox4),
            (CheckBox) findViewById(R.id.checkBox5),
            (CheckBox) findViewById(R.id.checkBox6),
            (CheckBox) findViewById(R.id.checkBox7),
            (CheckBox) findViewById(R.id.checkBox8),
            (CheckBox) findViewById(R.id.checkBox9),
            (CheckBox) findViewById(R.id.checkBox10),
            (CheckBox) findViewById(R.id.checkBox11),
            (CheckBox) findViewById(R.id.checkBox12),
            (CheckBox) findViewById(R.id.checkBox13)
        };

        for(int i = 0; i < setOfCheckBoxes.length; i++){
            setOfCheckBoxes[i].setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener) this);
        }

//        checkBox1 = (CheckBox) findViewById(R.id.checkBox1);
//        checkBox2 = (CheckBox) findViewById(R.id.checkBox2);
//        checkBox3 = (CheckBox) findViewById(R.id.checkBox3);
//        checkBox4 = (CheckBox) findViewById(R.id.checkBox4);
//        checkBox5 = (CheckBox) findViewById(R.id.checkBox5);
//        checkBox6 = (CheckBox) findViewById(R.id.checkBox6);
//        checkBox7 = (CheckBox) findViewById(R.id.checkBox7);
//        checkBox8 = (CheckBox) findViewById(R.id.checkBox8);
//        checkBox9 = (CheckBox) findViewById(R.id.checkBox9);
//        checkBox10 = (CheckBox) findViewById(R.id.checkBox10);
//        checkBox11 = (CheckBox) findViewById(R.id.checkBox11);
//        checkBox12 = (CheckBox) findViewById(R.id.checkBox12);
//        checkBox13 = (CheckBox) findViewById(R.id.checkBox13);
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
        disease = new boolean[13];
        String result = "";

        for(int i = 0; i < setOfCheckBoxes.length; i++){
            disease[i] = setOfCheckBoxes[i].isChecked();
        }
        for (int i = 0; i<setOfCheckBoxes.length; i++){
            if (disease[i]){


            }

        }

    }
}
