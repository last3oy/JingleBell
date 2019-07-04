package scb.academy.jinglebell.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiManager {

    val countryService by lazy { createService<CountryApiService>("https://restcountries.eu/") }

    val artistService by lazy { createService<ArtistApiService>("https://itunes.apple.com") }

    private inline fun <reified T> createService(baseUrl: String): T =
            Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .run { create(T::class.java) }

}