package com.example.barnacle;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class SignUpRequest extends StringRequest {

    //서버 url 설정 (php 파일 연동)
    final static private String URL = "http://barnacle.dothome.co.kr/Register.php";
    private Map<String, String> map;
    //private private Map<String, String> parameters;

    public SignUpRequest(String UserId, String UserPassword, String UserEmail, Response.Listener<String> listener) {
        super(Method.POST, URL, listener, null);

        map = new HashMap<>();
        map.put("UserId", UserId);
        map.put("UserPassword", UserPassword);
        map.put("UserEmail", UserEmail);
    }

    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        return map;
    }
}
