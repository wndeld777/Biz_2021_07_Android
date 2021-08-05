package com.callor.cacao;


import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.Toolbar;
import androidx.preference.Preference;
import androidx.preference.PreferenceManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import com.callor.cacao.adapter.ChattAdapter;
import com.callor.cacao.model.Chatt;
import com.callor.cacao.service.FirebaseServiceImplV1;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText txt_msg;
    private AppCompatButton btn_send;

    private RecyclerView chat_list_view;
    private ChattAdapter chattAdapter;
    private List<Chatt> chattList;

    private DatabaseReference dbRef;

    private  String nickname = "익명";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);

        nickname = preferences.getString("nick_name","익명");
        String alarm = preferences.getString("alarm","ON");

        Log.d("닉네임",nickname);
        Log.d("알람",alarm);


        /**
         * custom 된 toolbar 를 ActionBar 로 설정하기 위한 코드
         */
        Toolbar main_toolbar = findViewById(R.id.main_toolbar);
        setSupportActionBar(main_toolbar);

        /**
         *  새로운 Activity 가 열렸을때 이전 Activity(page)로 돌아가기 아이콘을 표시하기
         *  MainActivity 에서는 의미가 없기 때문에 사용하지 않는다
         */
//        ActionBar actionBar = getSupportActionBar();
//        actionBar.setDisplayHomeAsUpEnabled(true);


        txt_msg = findViewById(R.id.txt_msg);
        btn_send = findViewById(R.id.btn_send);
        chat_list_view =  findViewById(R.id.chatt_List_view);
        chattList = new ArrayList<Chatt>();

        //chattAdapter = new ChattAdapter(chattList);

        // 1-1 App에 등록된 nickname을 Apdapter에 데이터와 함께 전달하기
        chattAdapter = new ChattAdapter(chattList,nickname);

        chat_list_view.setAdapter(chattAdapter);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        chat_list_view.setLayoutManager(layoutManager);

        FirebaseDatabase dbConn = FirebaseDatabase.getInstance();
        dbRef = dbConn.getReference("chatting");

        ChildEventListener childEventListener = new FirebaseServiceImplV1(chattAdapter);
        dbRef.addChildEventListener(childEventListener);

        btn_send.setOnClickListener(view->{

            String msg = txt_msg.getText().toString();
            if(msg != null && !msg.isEmpty()){

                String toastMsg = String.format("메시지 : %s",msg);
                Toast.makeText(MainActivity.this, toastMsg, Toast.LENGTH_SHORT).show();

                Chatt chatVO = new Chatt();
                chatVO.setMsg(msg);
                chatVO.setName(nickname);

                dbRef.push().setValue(chatVO);
                txt_msg.setText("");
            }
        });

    }

    /**
     * Custom 한 Toolbar 가 (Main)Activity 에 적용될때
     * setSupportActionbar() method 가 실행될때
     * event 가 발생하고 자동으로 호출되는 method
     *
     * Toolbar 를 사용하여 ActionBar 를 Custom 하는 이유중에 하나가
     * onCreateOptionMenu() method 를 Override 하여
     * 더욱 세밀한 Customizing 을 하기 위해서 이다
     *
     * ToolBar 에 사용자 정의형 menu 를 설정하여
     * 다른 기능을 수행하도록 하는 UI 를 구현할수 있다
     * @param menu
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.main_tool_menu,menu);

        return true;
    }

    /**
     * ActionBar 에 설정된 Option Menu 의 특정한 항목(item)을 클릭하면 호출되는 method
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int menu_item = item.getItemId();
        if(menu_item == R.id.app_bar_settings){
            Toast.makeText(this, "설정메뉴 클릭됨", Toast.LENGTH_SHORT).show();

            Intent setting_intent = new Intent(MainActivity.this,SettingsActivity.class);
            startActivity(setting_intent);
            return true;
        }


        return super.onOptionsItemSelected(item);
    }
}