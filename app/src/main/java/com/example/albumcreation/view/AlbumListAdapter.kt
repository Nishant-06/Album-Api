package com.example.albumcreation.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.albumcreation.R
import com.example.albumcreation.model.Album
import kotlinx.android.synthetic.main.list_item.view.*

class AlbumListAdapter(var album: ArrayList<Album>):RecyclerView.Adapter<AlbumListAdapter.AlbumViewHolder>() {

    fun updateAlbum(newAlbum: List<Album>){
        album.clear()
        album.addAll(newAlbum)
        notifyDataSetChanged()

    }

    class AlbumViewHolder(view: View):RecyclerView.ViewHolder(view){
        private val albumUserId = view.item_title
        private val albTitle = view.albumTitle
        private val albId = view.albumId

        fun bind(album: Album){
            albumUserId.text = album.UserId
            albId.text = album.Id
            albTitle.text = album.title
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = AlbumViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
    )


    override fun onBindViewHolder(holder: AlbumViewHolder, position: Int) {
        holder.bind(album[position])
    }

    override fun getItemCount()=album.size
}