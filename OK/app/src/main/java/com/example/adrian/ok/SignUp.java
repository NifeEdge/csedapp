package com.example.adrian.ok;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SignUp extends AppCompatActivity {

    public void initListeners() {
        Button btnRegister = (Button)findViewById(R.id.btnRegister);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                register(view);
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        initListeners();
    }

    public void register(View view) {
        Log.d("Example","Called register method");

        String firstName = ((EditText)findViewById(R.id.f_name)).getText().toString();
        String lastName = ((EditText)findViewById(R.id.l_name)).getText().toString();
        String username = ((EditText)findViewById(R.id.username)).getText().toString();
        String password = ((EditText)findViewById(R.id.password)).getText().toString();

        User found = AppDatabase.getInstance(getApplicationContext()).userDao().getUserByUsername(username);

        if(found == null) {
            User newUser = new User(firstName, lastName, username, password);
            AppDatabase.getInstance(getApplicationContext()).userDao().createUser(newUser);

            Log.d("Example", "Registered new user (" + username + ")");

            Intent showLogin = new Intent(SignUp.this, Login.class);
            startActivity(showLogin);
        } else {
            Log.d("Example", "That user already exists");
        }
    }
}
