package scb.academy.jinglebell.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object CountryApiManager {

    val service: CountryApiService by lazy {
        Retrofit.Builder()
            .baseUrl("https://restcountries.eu/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .run { create(CountryApiService::class.java) }
    }

}