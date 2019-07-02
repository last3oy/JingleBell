package scb.academy.jinglebell.activity

import android.app.Activity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import scb.academy.jinglebell.R
import scb.academy.jinglebell.vo.Song

class SongInfoActivity : Activity() {

    private lateinit var ivSognArtWork: ImageView
    private lateinit var tvSongName: TextView
    private lateinit var tvSongAlbum: TextView
    private lateinit var tvSongReleaseDate: TextView
    private lateinit var tvSongGenre: TextView
    private lateinit var tvSongTrackPrice: TextView
    private lateinit var tvSongCollectionPrice: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_song_info)

        ivSognArtWork = findViewById(R.id.iv_song_artwork)
        tvSongName = findViewById(R.id.tv_song_name)
        tvSongAlbum = findViewById(R.id.tv_song_album)
        tvSongReleaseDate = findViewById(R.id.tv_release_date)
        tvSongGenre = findViewById(R.id.tv_genre)
        tvSongTrackPrice = findViewById(R.id.tv_track_price)
        tvSongCollectionPrice = findViewById(R.id.tv_collection_price)

        val song = intent.getParcelableExtra<Song>("song")

        tvSongName.text = song.name
    }
}