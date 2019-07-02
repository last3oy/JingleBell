package scb.academy.jinglebell.service

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import scb.academy.jinglebell.vo.SongSearchResult

interface ArtistApiService {

    @GET("search?entity=song")
    fun songs(@Query("term") artistName: String): Call<SongSearchResult>
}