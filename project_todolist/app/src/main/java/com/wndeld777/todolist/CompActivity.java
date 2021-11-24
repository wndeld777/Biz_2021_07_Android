package com.wndeld777.todolist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.preference.Preference;
import androidx.preference.PreferenceManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.wndeld777.todolist.adapter.TodoAdapter;
import com.wndeld777.todolist.model.todoDTO;

import java.util.List;

public class CompActivity extends AppCompatActivity {

    private EditText txt_msg;
    private AppCompatButton btn_send;
    private RecyclerView todo_list_view;
    private TodoAdapter todoAdapter;
    private List<todoDTO> todoList;
    private DatabaseReference dbRef;
    private String msgDate = "0000";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comp);

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);

        msgDate = preferences.getString("msg_date","0000");
        String alarm = preferences.getString("alarm","ON");

    }
}