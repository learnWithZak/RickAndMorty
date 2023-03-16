package com.zak.rickandmorty.service

interface RickMortyApiService {

    fun getAllCharacters()
    fun getASingleCharacter()

    fun getAllLocations()
    fun getASingleLocation()
    fun getMultipleLocation()

    fun getAllEpisodes()
    fun getASingleEpisode()
    fun getMultipleEpisodes()
}
