package com.block.youtube.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.block.youtube.R;
import com.block.youtube.model.Video;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class RecyclerViewAdapter extends  RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    Context context;
    ArrayList<Video> videoArrayList;

    public RecyclerViewAdapter(Context context, ArrayList<Video> videoArrayList) {
        this.context = context;
        this.videoArrayList = videoArrayList;
    }

    @NonNull
    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.video_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.ViewHolder holder, int position) {
        Video video = videoArrayList.get(position);
        String title = video.getTitle();
        String desc = video.getDesc();
        String imgUrl = video.getImgUrl();

        holder.txtTitle.setText(title);
        holder.txtDesc.setText(desc);
        // 이미지는 글라이드가 처리한다.
        Glide.with(context).load(imgUrl).into(holder.img);
    }

    @Override
    public int getItemCount() {
        return videoArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView txtTitle;
        public TextView txtDesc;
        public ImageView img;
        public CardView cardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txtTitle = itemView.findViewById(R.id.txtTitle);
            txtDesc = itemView.findViewById(R.id.txtDesc);
            img = itemView.findViewById(R.id.img);
            cardView = itemView.findViewById(R.id.cardView);
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int index = getAdapterPosition();
                    Video video = videoArrayList.get(index);
                    String videoId = video.getVideoId();
                    // 유투브 영상을 웹페이지에서 시청 가능하도록 하는 url 주소
                    String url = "https://www.youtube.com/watch?v=" + videoId;
                    openWebPage(url);
                }
            });

        }

        public void openWebPage(String url){
            Uri webpage = Uri.parse(url);
            Intent i = new Intent(Intent.ACTION_VIEW, webpage);
            if(i.resolveActivity(context.getPackageManager()) != null){
                context.startActivity(i);
            }
        }
    }
}
