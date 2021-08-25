package com.wndeld777.todolist.adapter;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.wndeld777.todolist.R;
import com.wndeld777.todolist.model.todoDTO;

import java.util.List;

public class TodoAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<todoDTO> todoList;
    private String date;

    public void addTodoList(todoDTO todo){
        todoList.add(todo);
        notifyItemInserted(todoList.size() -1);
    }

    public TodoAdapter(List<todoDTO> todoList) {
        // this.todoList = todoList;
        this(todoList,"0000");
    }

    public TodoAdapter(List<todoDTO> todoList, String date) {
        this.todoList = todoList;
        this.date = date;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View item_layout  = LayoutInflater.from(parent.getContext()).inflate(R.layout.todo_item_view,parent,false);

        TodoViewHolder viewHolder = new TodoViewHolder(item_layout);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        todoDTO todoDTO = todoList.get(position);
        TodoViewHolder todoViewHolder = (TodoViewHolder) holder;
        todoViewHolder.item_date.setText(todoDTO.getDate());
        todoViewHolder.item_msg.setText(todoDTO.getMsg());

        if(this.date.equals(todoDTO.getDate())){
            todoViewHolder.item_date.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_START);
            todoViewHolder.item_msg.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_START);
            todoViewHolder.todoLinear.setGravity(Gravity.END);
        }

    }

    @Override
    public int getItemCount() {
        return todoList == null ? 0 : todoList.size();
    }

    public static class TodoViewHolder extends RecyclerView.ViewHolder{

        public TextView item_date;
        public TextView item_msg;
        public LinearLayout todoLinear;

        public TodoViewHolder(@NonNull View itemView) {
            super(itemView);
            item_date = itemView.findViewById(R.id.item_date);
            item_msg = itemView.findViewById(R.id.item_msg);
            todoLinear = itemView.findViewById(R.id.todo_linear);
        }
    }
}
