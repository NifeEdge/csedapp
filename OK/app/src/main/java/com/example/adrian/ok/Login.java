package com.example.adrian.ok;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Login extends AppCompatActivity {

    public void initListeners(){
        Button btnRegister = (Button)findViewById(R.id.btnRegister);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent showRegister = new Intent(Login.this, SignUp.class);
                startActivity(showRegister);
            }
        });

        Button btnLogin = (Button)findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login(view);
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initListeners();
    }

    public void login(View view) {
        Log.d("Example","Called login method");

        String username = ((EditText)findViewById(R.id.username)).getText().toString();
        String password = ((EditText)findViewById(R.id.password)).getText().toString();

        User found = AppDatabase.getInstance(getApplicationContext()).userDao().getUserByUsername(username);

        if(found != null && found.getPassword().equals(password)) {
            Log.d("Example", "Login was success");
        } else {
            Log.d("Example", "Login was failure");
        }
    }
}
