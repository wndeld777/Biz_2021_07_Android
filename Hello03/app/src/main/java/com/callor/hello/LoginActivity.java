package com.callor.hello;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.callor.hello.model.UserDTO;

public class LoginActivity extends AppCompatActivity {

    private TextView user_id = null;
    private TextView password = null;
    private TextView user_name = null;
    private TextView tel = null;
    private TextView addr = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        user_id = findViewById(R.id.txt_userid);
        password = findViewById(R.id.txt_userpw);
        user_name = findViewById(R.id.txt_username);
        tel = findViewById(R.id.txt_usertel);
        addr = findViewById(R.id.txt_useraddr);

        Intent intent = getIntent();
        UserDTO user = (UserDTO) intent.getSerializableExtra("USER");
        user_id.setText(user.user_id);
        password.setText(user.password);
        user_name.setText(user.user_name);
        tel.setText(user.tel);
        addr.setText(user.addr);



    }
}