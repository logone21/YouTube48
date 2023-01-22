package com.example.youtube.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.liveData
import com.example.youtube.BuildConfig
import com.example.youtube.data.remote.remote.model.PlayList
import com.example.youtube.core.network.RetrofitClient
import kotlinx.coroutines.Dispatchers
import okhttp3.Dispatcher
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Repository {

    private val apiService = RetrofitClient.create()


     fun getPlayList(): LiveData<PlayList?> {
         return liveData(Dispatchers.IO) {
             val response = apiService.getPlayList(
                 "snippet,contentDetails",
                 "UCWOA1ZGywLbqmigxE4Qlvuw", BuildConfig.API_KEY,)
             if (response.isSuccessful){
                 emit(response.body())
             }
         }
    }
}