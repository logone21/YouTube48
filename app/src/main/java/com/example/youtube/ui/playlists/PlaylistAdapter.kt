package com.example.youtube.ui.playlists

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.youtube.databinding.ItemPlaylistBinding
import com.example.youtube.data.remote.remote.model.Item
import kotlin.reflect.KFunction0

  class PlaylistsAdapter (var onItemClick:(id:String)-> Unit)
    : RecyclerView.Adapter<PlaylistsAdapter.PlaylistsViewHolder>() {

    private var playLists = ArrayList<Item>()


     override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlaylistsViewHolder {
        return PlaylistsViewHolder(
            ItemPlaylistBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: PlaylistsViewHolder, position: Int) {
        playLists[position].let { holder.bind(it) }
    }

    override fun getItemCount(): Int {
        return playLists.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setList(playLists: ArrayList<Item>) {
        this.playLists = playLists
        notifyDataSetChanged()
    }

    inner class PlaylistsViewHolder(private val binding: ItemPlaylistBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Item) {
            binding.image.load(item.snippet.thumbnails.default.url)
            binding.tvTitle.text = item.snippet.title
            itemView.setOnClickListener {
                item.id?.let{
                    onItemClick(it)
                }
            }

        }
    }
}
