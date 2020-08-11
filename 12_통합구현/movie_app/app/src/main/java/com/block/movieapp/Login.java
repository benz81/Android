package com.block.movieapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.block.movieapp.util.Util;

import org.json.JSONException;
import org.json.JSONObject;

public class Login extends AppCompatActivity {

    EditText editEmail;
    EditText editPasswd;
    Button btnLogin;
    Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editEmail = findViewById(R.id.editEmail);
        editPasswd = findViewById(R.id.editPasswd);
        btnLogin = findViewById(R.id.btnLogin);
        btnRegister = findViewById(R.id.btnRegister);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = editEmail.getText().toString().trim();
                String passwd = editPasswd.getText().toString().trim();

                if(email.contains("@") == false){
                    // 토스트 처리
                    return;
                }
                if(passwd.isEmpty() || passwd.length() < 4 || passwd.length() > 12){
                    // 토스트 처리
                    return;
                }

                JSONObject body = new JSONObject();
                try {
                    body.put("email", email);
                    body.put("passwd", passwd);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                JsonObjectRequest request = new JsonObjectRequest(
                        Request.Method.POST,
                        Util.BASE_URL + "/api/v1/users/login",
                        body,
                        new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {
                                try {
                                    String token = response.getString("token");
                                    Log.i("AAA" , "network token : " +token);
                                    SharedPreferences sp = getSharedPreferences(Util.PREFERENCE_NAME,MODE_PRIVATE);
                                    SharedPreferences.Editor editor = sp.edit();
                                    editor.putString("token", token);
                                    editor.apply();

                                    finish();
                                    return;

                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {

                            }
                        }
                );
                Volley.newRequestQueue(Login.this).add(request);
            }
        });


    }
}