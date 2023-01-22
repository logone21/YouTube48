package com.example.youtube.ui.playlists

import androidx.lifecycle.LiveData
import com.example.youtube.data.remote.remote.model.PlayList
import com.example.youtube.core.network.ui.BaseViewModel
import com.example.youtube.repository.Repository


class PlayListViewModel : BaseViewModel() {

    private val repository = Repository()

    fun getPlayList(): LiveData<PlayList?> {
        return repository.getPlayList()
    }


}