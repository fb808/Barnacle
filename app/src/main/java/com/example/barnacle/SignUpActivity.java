package com.example.barnacle;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class SignUpActivity extends AppCompatActivity {

    private EditText et_setId, et_setPassword, et_confirmPassword, et_setEmail;
    private TextView btn_checkId, btn_signUp, btn_login;
    private AlertDialog dialog;
    private boolean validate = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        //아이디값 찾아주기
        et_setId = (EditText) findViewById(R.id.et_SetId);
        et_setPassword = (EditText) findViewById(R.id.et_SetPassword);
        et_setEmail = (EditText) findViewById(R.id.et_SetEmail);
        btn_checkId = (TextView) findViewById(R.id.btn_checkId);
        btn_signUp = (TextView) findViewById(R.id.btn_SignUp);
        btn_login = (TextView) findViewById(R.id.btn_login);

        //아이디 중복체크
        btn_checkId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userId = et_setId.getText().toString();
                if(validate){
                    return; //검증완료
                }

                if (userId.equals("")) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(SignUpActivity.this);
                    dialog = builder.setMessage("아이디를 입력하세요.").setPositiveButton("확인", null).create();
                    dialog.show();
                    return;
                }

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");

                            if (success) {
                                AlertDialog.Builder builder = new AlertDialog.Builder(SignUpActivity.this);
                                dialog = builder.setMessage("사용할 수 있는 아이디입니다.").setPositiveButton("확인", null).create();
                                dialog.show();
                                et_setId.setEnabled(false); //아이디값 고정
                                validate = true; //검증 완료
                                btn_checkId.setBackgroundColor(getResources().getColor(R.color.theme));
                            }
                            else {
                                AlertDialog.Builder builder = new AlertDialog.Builder(SignUpActivity.this);
                                dialog = builder.setMessage("이미 존재하는 아이디입니다.").setNegativeButton("확인", null).create();
                                dialog.show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };

                ValidateRequest validateRequest = new ValidateRequest(userId, responseListener);
                RequestQueue queue = Volley.newRequestQueue(SignUpActivity.this);
                queue.add(validateRequest);
            }
        });

        //회원가입 버튼 클릭 시 수행
        btn_signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String userId = et_setId.getText().toString();
                final String userPassword = et_setPassword.getText().toString();
                final String userEmail = et_setEmail.getText().toString();
                final String confirmPassword = et_confirmPassword.getText().toString();

                //아이디 중복체크 확인
                if (!validate){
                    AlertDialog.Builder builder = new AlertDialog.Builder(SignUpActivity.this);
                    dialog = builder.setMessage("중복된 아이디가 있는지 확인하세요.").setNegativeButton("확인", null).create();
                    dialog.show();
                    return;
                }

                //한 칸이라도 입력 안했을 경우
                if (userId.equals("") || userPassword.equals("") || userEmail.equals("") || confirmPassword.equals("")) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(SignUpActivity.this);
                    dialog = builder.setMessage("모두 입력해주세요.").setNegativeButton("확인", null).create();
                    dialog.show();
                    return;
                }

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject( response );
                            boolean success = jsonObject.getBoolean( "success" );

                            //회원가입 성공시
                            if(userPassword.equals(confirmPassword)) {
                                if (success) {
                                    Toast.makeText(getApplicationContext(), String.format("%s님 환영합니다.", userId), Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(SignUpActivity.this, LoginActivity.class);
                                    startActivity(intent);

                                    //회원가입 실패시
                                } else {
                                    Toast.makeText(getApplicationContext(), "회원가입에 실패하였습니다.", Toast.LENGTH_SHORT).show();
                                    return;
                                }
                            } else {
                                AlertDialog.Builder builder = new AlertDialog.Builder(SignUpActivity.this);
                                dialog = builder.setMessage("비밀번호가 동일하지 않습니다.").setNegativeButton("확인", null).create();
                                dialog.show();
                                return;
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                };

                //서버로 Volley를 이용해서 요청
                SignUpRequest signUpRequest = new SignUpRequest(userId, userPassword, userEmail, responseListener);
                RequestQueue queue = Volley.newRequestQueue( SignUpActivity.this );
                queue.add(signUpRequest);
            }
        });

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
