package com.zak.rickandmorty.repository

import com.zak.rickandmorty.model.CharactersResponse
import com.zak.rickandmorty.model.EpisodesResponse
import com.zak.rickandmorty.model.LocationsResponse
import com.zak.rickandmorty.service.ApiResponse

interface RemoteDataRepository {

	suspend fun getAllCharacters(): ApiResponse<CharactersResponse>
	suspend fun getAllLocations(): ApiResponse<LocationsResponse>
	suspend fun getAllEpisodes(): ApiResponse<EpisodesResponse>

}