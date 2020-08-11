package com.block.movieapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.block.movieapp.Login;
import com.block.movieapp.MainActivity;
import com.block.movieapp.R;
import com.block.movieapp.model.Movie;
import com.block.movieapp.util.Util;

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

        if(movie.getIs_favorite() == 1){
            holder.btn_star.setImageResource(android.R.drawable.btn_star_big_on);
        }else{
            holder.btn_star.setImageResource(android.R.drawable.btn_star_big_off);
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

            btn_star.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    Log.i("AAA", position+"");
                    // 로그인 상태인지 확인한다.
                    SharedPreferences sp = context.getSharedPreferences(Util.PREFERENCE_NAME,
                            Context.MODE_PRIVATE);
                    String token = sp.getString("token", null);
                    Log.i("AAA", "token : " + token);
                    if(token == null){
                        // 로그인 액티비티를 띄운다.
                        Intent i = new Intent(context, Login.class);
                        context.startActivity(i);
                    }else{
                        // 정상적으로 별표 표시를 서버로 보냅니다.
                        // 즐겨찾기 추가하는 API를 호출할건데,
                        // 호출하는 코드는 메인 액티비티에 메소드로 만들고,
                        // 여기에서는 position 값만 넘겨주도록 한다.

                        int is_favorite = movieArrayList.get(position).getIs_favorite();
                        if(is_favorite == 1){
                            // 별표 색이 이미 있으면, 즐겨찾기 삭제 함수 호출!
                        }else{
                            // 별표 색깔이 없으면, 즐겨찾기 추가 함수 호출!
                            ((MainActivity)context).addFavorite(position);
                        }
                    }
                }
            });
        }
    }

}









