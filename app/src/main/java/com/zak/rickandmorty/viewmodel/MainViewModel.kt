package com.zak.rickandmorty.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zak.rickandmorty.service.ApiResponse
import com.zak.rickandmorty.repository.RemoteDataRepository
import com.zak.rickandmorty.model.Character
import com.zak.rickandmorty.model.CharactersResponse
import com.zak.rickandmorty.model.EpisodesResponse
import com.zak.rickandmorty.model.LocationsResponse
import kotlinx.coroutines.launch
import com.zak.rickandmorty.service.ApiResponse.Status.LOADING
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class MainViewModel(private val repository: RemoteDataRepository) : ViewModel() {

	private val _state = MutableStateFlow(ApiResponse<CharactersResponse>(LOADING, null))
	val state: StateFlow<ApiResponse<CharactersResponse>>
		get() = _state

	private val _uniqueCharacterLiveData = MutableLiveData<ApiResponse<Character>>()
	val uniqueCharacterLiveData: LiveData<ApiResponse<Character>> = _uniqueCharacterLiveData

	private val _locationsLiveData = MutableLiveData<ApiResponse<LocationsResponse>>()
	val locationsLiveData: LiveData<ApiResponse<LocationsResponse>> = _locationsLiveData

	private val _episodesLiveData = MutableLiveData<ApiResponse<EpisodesResponse>>()
	val episodesLiveData: LiveData<ApiResponse<EpisodesResponse>> = _episodesLiveData


	init {
		getAllCharacters()
		getCharacterById(1)
		getAllLocations()
		getAllEpisodes()
	}

	private fun getAllCharacters() {
		_state.value = ApiResponse(LOADING, null)
		viewModelScope.launch {
			_state.value = repository.getAllCharacters()
		}
	}

	private fun getCharacterById(id: Int) {
		_uniqueCharacterLiveData.value = ApiResponse(LOADING, null)
		viewModelScope.launch {
			_uniqueCharacterLiveData.value = repository.getCharacterById(id)
		}
	}

	private fun getAllLocations() {
		_locationsLiveData.value = ApiResponse(LOADING, null)
		viewModelScope.launch {
			_locationsLiveData.value = repository.getAllLocations()
		}
	}

	private fun getAllEpisodes() {
		_episodesLiveData.value = ApiResponse(LOADING, null)
		viewModelScope.launch {
			_episodesLiveData.value = repository.getAllEpisodes()
		}
	}
}