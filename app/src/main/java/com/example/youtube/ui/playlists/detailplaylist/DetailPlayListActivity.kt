package com.example.youtube.ui.playlists.detailplaylist


import android.widget.Toast
import com.example.youtube.core.network.ui.BaseActivity
import com.example.youtube.databinding.ActivityDetailPlayListBinding

 class DetailPlayListActivity : BaseActivity<ActivityDetailPlayListBinding>() {
     override fun inflateViewBinding(): ActivityDetailPlayListBinding {
Toast.makeText(this,intent.getStringExtra("key"),Toast.LENGTH_SHORT).show()
       return  ActivityDetailPlayListBinding.inflate(layoutInflater)
     }

 }