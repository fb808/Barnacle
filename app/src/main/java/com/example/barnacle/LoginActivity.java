package com.example.barnacle;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final TextView et_Id = (TextView) findViewById(R.id.et_Id);
        final TextView et_Password = (TextView) findViewById(R.id.et_Password);
        final Button btn_Login = (Button) findViewById(R.id.btn_login);
        final Button btn_SignUp = (Button) findViewById(R.id.btn_SignUp);

        final FirebaseAuth firebaseAuth =  FirebaseAuth.getInstance();

        //가입 버튼이 눌리면
        btn_SignUp.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //intent함수를 통해 register액티비티 함수를 호출한다.
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
            }
        });

        //로그인 버튼이 눌리면
        btn_Login.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                String id = et_Id.getText().toString().trim();
                String pwd = et_Password.getText().toString().trim();
                firebaseAuth.signInWithEmailAndPassword(id,pwd)
                        .addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if(task.isSuccessful()){
                                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                                    startActivity(intent);

                                }else{
                                    Toast.makeText(LoginActivity.this,"로그인 오류",Toast.LENGTH_SHORT).show();
                                }
                            }
                        });

            }
        });

    }


}
