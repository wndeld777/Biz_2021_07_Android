package com.callor.hello;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.widget.Button;

import com.callor.hello.model.UserDTO;
import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText input_id = null;
    private TextInputEditText input_pw = null;
    private TextInputEditText input_name = null;
    private TextInputEditText input_tel = null;
    private TextInputEditText input_addr = null;
    private Button btn_save = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input_id = findViewById(R.id.input_id);
        input_pw = findViewById(R.id.input_pw);
        input_name = findViewById(R.id.input_name);
        input_tel = findViewById(R.id.input_tel);
        input_addr = findViewById(R.id.input_adr);
        btn_save = findViewById(R.id.btn_save);

        btn_save.setOnClickListener(view -> {
            String id = input_id.getText().toString();
            String pw = input_pw.getText().toString();
            String name = input_name.getText().toString();
            String tel = input_tel.getText().toString();
            String addr = input_addr.getText().toString();

            UserDTO user = new UserDTO();
            user.user_id = id;
            user.password = pw;
            user.user_name = name;
            user.tel = tel;
            user.addr = addr;

            Intent join_intent = new Intent(MainActivity.this, LoginActivity.class);
            join_intent.putExtra("USER", user);
            startActivity(join_intent);

        });

    }
}