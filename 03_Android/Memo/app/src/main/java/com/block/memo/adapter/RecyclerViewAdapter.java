package com.block.memo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.block.memo.R;
import com.block.memo.model.Memo;

import java.util.ArrayList;


public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    Context context;
    ArrayList<Memo> memoList;

    public RecyclerViewAdapter(Context context, ArrayList<Memo> memoList){
        this.context = context;
        this.memoList = memoList;
    }

    @NonNull
    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // 첫번째 파라미터인, parent로 부터 뷰(화면:하나의 셀)를 생성한다.
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.memo_row, parent, false);
        // 리턴에, 위에서 생성한 뷰를, 뷰홀더에 담아서 리턴한다.
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.ViewHolder holder, int position) {
        Memo memo = memoList.get(position);
        String title = memo.getTitle();
        String content = memo.getContent();
        // 뷰홀더에 표시하라.
        holder.txtTitle.setText(title);
        holder.txtContent.setText(content);
    }

    @Override
    public int getItemCount() {
        return memoList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView txtTitle;
        public TextView txtContent;
        public ImageView imgDelete;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtTitle = itemView.findViewById(R.id.txtTitle);
            txtContent = itemView.findViewById(R.id.txtContent);
            imgDelete = itemView.findViewById(R.id.imgDelete);
        }
    }

}
