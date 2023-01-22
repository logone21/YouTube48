package com.example.youtube.data.remote

import com.example.youtube.data.remote.remote.model.PlayList
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("playlists")
   suspend fun getPlayList(
        @Query("part") part:String,
        @Query("channelId") channelId:String,
        @Query("key") key:String,
    ):Response<PlayList>


}

