package com.block.photoapp.api;

import com.block.photoapp.model.PostRes;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface PostApi {

    @GET("/api/v1/posts")       // ?offset=0&limit=25
    Call<PostRes> getPosts(@Header("Authorization") String token,
                           @Query("offset") int offset,
                           @Query("limit") int limit);


}
