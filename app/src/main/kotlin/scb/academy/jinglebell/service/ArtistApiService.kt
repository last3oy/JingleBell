package scb.academy.jinglebell.service

import retrofit2.Call
import retrofit2.http.GET

interface ArtistApiService {

    @GET()
    fun songs(): Call<String>
}