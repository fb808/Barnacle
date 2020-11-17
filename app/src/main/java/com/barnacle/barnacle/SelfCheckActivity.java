package com.barnacle.barnacle;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SelfCheckActivity extends AppCompatActivity {

    ImageView imageView;
    EditText birth;
    TextView txtResult;
    CheckBox checkBox1, checkBox2, checkBox3, checkBox4, checkBox5;
    CheckBox checkBox6, checkBox7, checkBox8, checkBox9, checkBox10;
    CheckBox checkBox11, checkBox12;
    Button submit;
    private String[] vaccin = new String[]
            {"인플루엔자(Flu)", "폐렴구균(PPSV)", "폐렴구균(PCV)", "파상풍/디프테리아(백일해)/(Tdap/Td)", "A형간염(HepA)",
                    "B형간염(HepB)", "수두(Var)", "홍역/유행성 이하선염/풍진 (MMR)", "대상포진(HZV)", "수막구균(MCV4)",
                    "b형 헤모필루스 인플루엔자(Hib)", "폴리오(IPV)"}; //12개, 0~11
    int birth_num;
    boolean[] disease;
    CheckBox[] setOfCheckBoxes;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.self_check);

        imageView = (ImageView) findViewById(R.id.imageView);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SelfCheckActivity.this, MainActivity.class);
                SelfCheckActivity.this.startActivity(intent);
            }

        });

//        setOfCheckBoxes = new CheckBox[]{
//            (CheckBox) findViewById(R.id.checkBox1),
//            (CheckBox) findViewById(R.id.checkBox2),
//            (CheckBox) findViewById(R.id.checkBox3),
//            (CheckBox) findViewById(R.id.checkBox4),
//            (CheckBox) findViewById(R.id.checkBox5),
//            (CheckBox) findViewById(R.id.checkBox6),
//            (CheckBox) findViewById(R.id.checkBox7),
//            (CheckBox) findViewById(R.id.checkBox8),
//            (CheckBox) findViewById(R.id.checkBox9),
//            (CheckBox) findViewById(R.id.checkBox10),
//            (CheckBox) findViewById(R.id.checkBox11),
//            (CheckBox) findViewById(R.id.checkBox12),
//            (CheckBox) findViewById(R.id.checkBox13)
//        };

//        for(int i = 0; i < setOfCheckBoxes.length; i++){
//            setOfCheckBoxes[i].setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener) this);
//        }

        checkBox1 = (CheckBox) findViewById(R.id.checkBox1);
        checkBox2 = (CheckBox) findViewById(R.id.checkBox2);
        checkBox3 = (CheckBox) findViewById(R.id.checkBox3);
        checkBox4 = (CheckBox) findViewById(R.id.checkBox4);
        checkBox5 = (CheckBox) findViewById(R.id.checkBox5);
        checkBox6 = (CheckBox) findViewById(R.id.checkBox6);
        checkBox7 = (CheckBox) findViewById(R.id.checkBox7);
        checkBox8 = (CheckBox) findViewById(R.id.checkBox8);
        checkBox9 = (CheckBox) findViewById(R.id.checkBox9);
        checkBox10 = (CheckBox) findViewById(R.id.checkBox10);
        checkBox11 = (CheckBox) findViewById(R.id.checkBox11);
        checkBox12 = (CheckBox) findViewById(R.id.checkBox12);

//        disease = new boolean[13];
//        String result = "";
//
//        for (int i = 0; i < setOfCheckBoxes.length; i++) {
//            disease[i] = setOfCheckBoxes[i].isChecked();
//        }

        txtResult = (TextView)findViewById(R.id.txtResult);

//        birth = (EditText) findViewById(R.id.birth);
//        birth_num = Integer.parseInt(birth.getText().toString());
//
//        long now = System.currentTimeMillis();
//        Date mDate = new Date(now);
//        SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy");
//        String getTime = simpleDate.format(mDate);
//        int timeNow = Integer.parseInt(getTime);
//
//        final int age = (timeNow - birth_num + 1);

   }

    //버튼
    public void mOnPopupClick(View v){
        //데이터 담아서 팝업(액티비티) 호출
        Intent intent = new Intent(this, PopupActivity.class);
        intent.putExtra("data", "Test Popup");
        startActivityForResult(intent, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                //데이터 받기
                String result = data.getStringExtra("result");
                txtResult.setText(result);
            }
        }
    }

}
