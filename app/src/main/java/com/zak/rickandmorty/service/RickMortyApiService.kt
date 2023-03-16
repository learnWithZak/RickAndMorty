package com.zak.rickandmorty.service

import retrofit2.http.GET
import com.zak.rickandmorty.data.CharactersResponse
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import com.zak.rickandmorty.data.Character
import com.zak.rickandmorty.data.EpisodesResponse
import com.zak.rickandmorty.data.LocationsResponse
import retrofit2.http.Path

interface RickMortyApiService {

    @GET("character")
    suspend fun getAllCharacters(): Response<CharactersResponse>

    @GET("character/{id}")
    suspend fun getCharacterById(@Path("id") id: Int): Response<Character>

    @GET("location")
    suspend fun getAllLocations(): Response<LocationsResponse>

    @GET("episode")
    suspend fun getAllEpisodes(): Response<EpisodesResponse>


    companion object {
        val instance: RickMortyApiService by lazy {
            val retrofit = Retrofit.Builder()
                .baseUrl("https://rickandmortyapi.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            retrofit.create(RickMortyApiService::class.java)
        }
    }
}
