package scb.academy.jinglebell.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import scb.academy.jinglebell.R
import scb.academy.jinglebell.vo.Song

class SongAdapter(
        songs: List<Song> = listOf(),
        private val onClick: (Song) -> Unit = {}
) : ListAdapter<Song, SongItemViewHolder>(SongItemCallback()) {

    init {
        submitList(songs)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = SongItemViewHolder(parent)

    override fun onBindViewHolder(holder: SongItemViewHolder, position: Int) {
        holder.bind(getItem(position), onClick)
    }

}

class SongItemCallback : DiffUtil.ItemCallback<Song>() {

    override fun areItemsTheSame(oldItem: Song, newItem: Song): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: Song, newItem: Song): Boolean {
        return oldItem == newItem
    }

}

class SongItemViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_song, parent, false)
) {

    private val ivSongArtwork: ImageView = itemView.findViewById(R.id.iv_song_artwork)
    private val tvSongName: TextView = itemView.findViewById(R.id.tv_song_name)
    private val tvSongArtist: TextView = itemView.findViewById(R.id.tv_song_artist)
    private val tvSongPrice: TextView = itemView.findViewById(R.id.tv_song_price)

    fun bind(song: Song, onClick: (Song) -> Unit = {}) {
        Picasso.get()
                .load(song.artworkUrl)
                .into(ivSongArtwork)

        tvSongName.text = song.name
        tvSongArtist.text = song.artistName
        tvSongPrice.text = "${song.price} ${song.priceCurrency}"

        itemView.setOnClickListener { onClick(song) }
    }

}