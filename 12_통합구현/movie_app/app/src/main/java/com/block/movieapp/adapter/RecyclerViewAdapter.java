package com.block.movieapp.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.block.movieapp.R;
import com.block.movieapp.model.Movie;

import org.w3c.dom.Text;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    Context context;
    ArrayList<Movie> movieArrayList;

    public RecyclerViewAdapter(Context context, ArrayList<Movie> movieArrayList) {
        this.context = context;
        this.movieArrayList = movieArrayList;
    }

    @NonNull
    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.movie_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.ViewHolder holder, int position) {
        Movie movie = movieArrayList.get(position);
        holder.txt_title.setText(movie.getTitle());
        holder.txt_genre.setText(movie.getGenre());

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        df.setTimeZone(TimeZone.getTimeZone("UTC")); // 위의 시간을 utc 로 맞추는것.
        try {
            Date date = df.parse(movie.getYear());
            df.setTimeZone(TimeZone.getDefault());  // 내 폰의 로컬 타임존
            String strDate = df.format(date);
            holder.txt_year.setText( "관객수:" + movie.getAttendance() + " / " + strDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return movieArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView txt_title;
        TextView txt_genre;
        TextView txt_year;
        ImageView btn_star;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txt_title = itemView.findViewById(R.id.txt_title);
            txt_genre = itemView.findViewById(R.id.txt_genre);
            txt_year = itemView.findViewById(R.id.txt_year);
            btn_star = itemView.findViewById(R.id.btn_star);
        }
    }

}









