package com.example.e_commerceapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity {

    Button loginButton;
    EditText userName, passWord;
    ArrayList<User> users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginButton = findViewById(R.id.btn_login);
        userName = findViewById(R.id.input_username);
        passWord = findViewById(R.id.input_password);

        users = new ArrayList<>();
        users.add(new User("bilal", "12345"));
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(userName.getText().toString().toLowerCase().trim().equals(users.get(0).mUsername) &&
                    passWord.getText().toString().equals(users.get(0).mPassword)) {
                    Intent intent = new Intent(LoginActivity.this, ListGamesActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(LoginActivity.this, "Please enter username bilal and password 12345 to login", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
