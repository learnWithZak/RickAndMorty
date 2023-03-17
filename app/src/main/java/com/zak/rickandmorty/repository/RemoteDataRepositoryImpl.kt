package com.zak.rickandmorty.repository

import com.zak.rickandmorty.model.Character
import com.zak.rickandmorty.model.CharactersResponse
import com.zak.rickandmorty.model.EpisodesResponse
import com.zak.rickandmorty.model.LocationsResponse
import com.zak.rickandmorty.service.ApiResponse
import com.zak.rickandmorty.service.RickMortyApiService
import com.zak.rickandmorty.service.handleApiResponse

class RemoteDataRepositoryImpl(private val rickAndMortyApi: RickMortyApiService): RemoteDataRepository {

	override suspend fun getAllCharacters(): ApiResponse<CharactersResponse> =
		handleApiResponse {
			rickAndMortyApi.getAllCharacters()
		}

	override suspend fun getCharacterById(id: Int): ApiResponse<Character> =
		handleApiResponse {
			rickAndMortyApi.getCharacterById(id)
		}

	override suspend fun getAllLocations(): ApiResponse<LocationsResponse> =
		handleApiResponse {
			rickAndMortyApi.getAllLocations()
		}

	override suspend fun getAllEpisodes(): ApiResponse<EpisodesResponse> =
		handleApiResponse {
			rickAndMortyApi.getAllEpisodes()
		}

}