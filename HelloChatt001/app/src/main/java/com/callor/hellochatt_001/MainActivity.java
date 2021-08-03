package com.callor.hellochatt_001;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

import adapter.ChattAdapter;
import model.Chatt;

public class MainActivity extends AppCompatActivity {

    private EditText txt_msg;
    private AppCompatButton btn_send;
    private RecyclerView chatt_list_view;

    private ChattAdapter chattAdapter;
    private List<Chatt> chattList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt_msg = findViewById(R.id.txt_msg);
        btn_send = findViewById(R.id.btn_send);
        chatt_list_view = findViewById(R.id.chatt_list_view);

        chattList = new ArrayList<Chatt>();

        Chatt chatt = new Chatt();
        chatt.setName("홍길동");
        chatt.setMsg("반갑습니다");
        chattList.add(chatt);

        chatt = new Chatt();
        chatt.setName("성춘향");
        chatt.setMsg("안녕하세요");
        chattList.add(chatt);

        chatt = new Chatt();
        chatt.setName("이몽룡");
        chatt.setMsg("오늘은 좋은날");
        chattList.add(chatt);

        chattAdapter = new ChattAdapter(chattList);

        chatt_list_view.setAdapter(chattAdapter);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        chatt_list_view.setLayoutManager(layoutManager);
    }
}