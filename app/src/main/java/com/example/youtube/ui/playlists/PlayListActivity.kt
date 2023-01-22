package com.example.youtube.ui.playlists

import android.content.Intent
import android.net.ConnectivityManager
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import com.example.youtube.core.network.ui.BaseActivity
import com.example.youtube.core.network.utils.CheckInternetConnection
import com.example.youtube.databinding.ActivityPlaylistBinding
import com.example.youtube.ui.playlists.detailplaylist.DetailPlayListActivity

class PlayListActivity : BaseActivity<ActivityPlaylistBinding>() {
    private lateinit var viewModel: PlayListViewModel
    private var adapter=PlaylistsAdapter(this::onItemClick)


    override fun inflateViewBinding(): ActivityPlaylistBinding {
        return ActivityPlaylistBinding.inflate(layoutInflater)
    }

    override fun initAdapter() {
        binding.rvPlaylists.adapter=adapter
//        adapter.onItemClick = {
//            val intent = Intent(this,DetailPlayListActivity::class.java)
//            intent.putExtra("key", it)
//            startActivity(intent)}

    }

    override fun initListener() {


    }

    override fun setUI() {
        viewModel = ViewModelProvider(this)[PlayListViewModel::class.java]
    }

    override fun setupLiveData() {
        viewModel.getPlayList().observe(this) { playList ->
            if (playList != null) {
                adapter?.setList(playList.items)
            }
            if (playList != null) {
                Toast.makeText(this, playList.kind.toString(), Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun checkInternet() {
            CheckInternetConnection((getSystemService(CONNECTIVITY_SERVICE) as
                    ConnectivityManager)).observe(this){
                        binding.includedInternet.relativeParent.isVisible = !it
                binding.rvPlaylists.isVisible = it
                setupLiveData()

            }
    }

    fun onItemClick(id:String) {
        val intent = Intent(this,DetailPlayListActivity::class.java)
        intent.putExtra("key",id)
        startActivity(intent)
    }


}















