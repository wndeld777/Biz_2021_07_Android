package com.wndeld777.todolist.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.wndeld777.todolist.model.todoDTO;

import java.util.List;

public class TodoAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<todoDTO> todoList;

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static class TodoViewHolder extends RecyclerView.ViewHolder{

        public TextView item_date;
        public TextView item_msg;

        public TodoViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
