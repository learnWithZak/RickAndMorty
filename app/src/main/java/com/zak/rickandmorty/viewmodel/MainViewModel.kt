package com.zak.rickandmorty.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zak.rickandmorty.service.ApiResponse
import com.zak.rickandmorty.repository.RemoteDataRepository
import com.zak.rickandmorty.model.CharactersResponse
import com.zak.rickandmorty.model.EpisodesResponse
import com.zak.rickandmorty.model.LocationsResponse
import kotlinx.coroutines.launch
import com.zak.rickandmorty.service.ApiResponse.Status.LOADING
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class MainViewModel(private val repository: RemoteDataRepository) : ViewModel() {

	private val _charactersState = MutableStateFlow(ApiResponse<CharactersResponse>(LOADING, null))
	val charactersState: StateFlow<ApiResponse<CharactersResponse>>
		get() = _charactersState

	private val _locationsState = MutableStateFlow(ApiResponse<LocationsResponse>(LOADING, null))
	val locationsState: StateFlow<ApiResponse<LocationsResponse>>
		get() = _locationsState

	private val _episodesState = MutableStateFlow(ApiResponse<EpisodesResponse>(LOADING, null))
	val episodesState: StateFlow<ApiResponse<EpisodesResponse>>
		get() = _episodesState


	init {
		getAllCharacters()
		getAllLocations()
		getAllEpisodes()
	}

	private fun getAllCharacters() {
		_charactersState.value = ApiResponse(LOADING, null)
		viewModelScope.launch {
			_charactersState.value = repository.getAllCharacters()
		}
	}

	private fun getAllLocations() {
		_locationsState.value = ApiResponse(LOADING, null)
		viewModelScope.launch {
			_locationsState.value = repository.getAllLocations()
		}
	}

	private fun getAllEpisodes() {
		_episodesState.value = ApiResponse(LOADING, null)
		viewModelScope.launch {
			_episodesState.value = repository.getAllEpisodes()
		}
	}
}