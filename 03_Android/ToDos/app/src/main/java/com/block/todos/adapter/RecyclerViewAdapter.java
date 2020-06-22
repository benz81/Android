package com.block.todos.adapter;

import android.content.Context;
import android.media.TimedText;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.block.todos.R;
import com.block.todos.model.Todo;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{

    Context context;
    ArrayList<Todo> todoArrayList;

    public RecyclerViewAdapter(Context context, ArrayList<Todo> todoArrayList) {
        this.context = context;
        this.todoArrayList = todoArrayList;
    }

    @NonNull
    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.todo_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.ViewHolder holder, int position) {
        Todo todo = todoArrayList.get(position);
        String title = todo.getTitle();
        int userId = todo.getUserId();
        boolean completed = todo.isCompleted();

        holder.txtTitle.setText(title);
        holder.txtUserId.setText("User Id : "+userId);

        if(completed){
            holder.txtCompleted.setText("completed : 성공");
        }else{
            holder.txtCompleted.setText("completed : 실패");
        }

    }

    @Override
    public int getItemCount() {
        return todoArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView txtTitle;
        public TextView txtUserId;
        public TextView txtCompleted;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtTitle = itemView.findViewById(R.id.txtTitle);
            txtUserId = itemView.findViewById(R.id.txtUserId);
            txtCompleted = itemView.findViewById(R.id.txtCompleted);
        }
    }

}
