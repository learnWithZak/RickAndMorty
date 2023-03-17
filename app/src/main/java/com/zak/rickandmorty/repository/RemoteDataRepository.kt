package com.zak.rickandmorty.repository

import com.zak.rickandmorty.model.Character
import com.zak.rickandmorty.model.CharactersResponse
import com.zak.rickandmorty.model.EpisodesResponse
import com.zak.rickandmorty.model.LocationsResponse
import com.zak.rickandmorty.service.ApiResponse
import com.zak.rickandmorty.service.RickMortyApiService
import com.zak.rickandmorty.service.handleApiResponse

interface RemoteDataRepository {

	suspend fun getAllCharacters(): ApiResponse<CharactersResponse>
	suspend fun getCharacterById(id: Int): ApiResponse<Character>
	suspend fun getAllLocations(): ApiResponse<LocationsResponse>
	suspend fun getAllEpisodes(): ApiResponse<EpisodesResponse>

}