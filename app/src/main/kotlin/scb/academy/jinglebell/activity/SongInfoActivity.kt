package scb.academy.jinglebell.activity

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.squareup.picasso.Picasso
import scb.academy.jinglebell.R
import scb.academy.jinglebell.vo.Song
import java.text.SimpleDateFormat

class SongInfoActivity : AppCompatActivity() {

    private lateinit var ivSongArtWork: ImageView
    private lateinit var tvSongName: TextView
    private lateinit var tvSongAlbum: TextView
    private lateinit var tvSongReleaseDate: TextView
    private lateinit var tvSongGenre: TextView
    private lateinit var tvSongTrackPrice: TextView
    private lateinit var tvSongCollectionPrice: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_song_info)

        ivSongArtWork = findViewById(R.id.iv_song_artwork)
        tvSongName = findViewById(R.id.tv_song_name)
        tvSongAlbum = findViewById(R.id.tv_song_album)
        tvSongReleaseDate = findViewById(R.id.tv_release_date)
        tvSongGenre = findViewById(R.id.tv_genre)
        tvSongTrackPrice = findViewById(R.id.tv_track_price)
        tvSongCollectionPrice = findViewById(R.id.tv_collection_price)

        val song = intent.getParcelableExtra<Song>("song")

        setTitle("${song.artistName}")

        Picasso.get()
                .load(song.artworkUrl)
                .into(ivSongArtWork)
        tvSongName.text = song.name
        tvSongAlbum.text = song.album
        val date = SimpleDateFormat("YYYY-MM-dd'T'HH:mm:ss'Z'").parse(song.releaseDate)
        val out = SimpleDateFormat("YYYY-MM-dd")
        tvSongReleaseDate.text = out.format(date).toString()
        tvSongGenre.text = song.genre
        tvSongTrackPrice.text = "${song.price} ${song.priceCurrency}"
        tvSongCollectionPrice.text = "${song.collectionPrice} ${song.priceCurrency}"
    }
}