package scb.academy.jinglebell.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiManager {

    val countryService: CountryApiService by lazy {
        Retrofit.Builder()
                .baseUrl("https://restcountries.eu/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .run { create(CountryApiService::class.java) }
    }

    val artistSevice: ArtistApiService by lazy {
        Retrofit.Builder()
                .baseUrl("https://itunes.apple.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .run { create(ArtistApiService::class.java) }
    }

}