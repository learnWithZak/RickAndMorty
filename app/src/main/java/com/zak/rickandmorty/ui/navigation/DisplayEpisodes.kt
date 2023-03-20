package com.zak.rickandmorty.ui.navigation

import android.widget.Toast
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.zak.rickandmorty.model.Episode
import com.zak.rickandmorty.model.EpisodesResponse
import com.zak.rickandmorty.service.ApiResponse
import com.zak.rickandmorty.ui.listItem.DefaultListItem
import com.zak.rickandmorty.viewmodel.MainViewModel

@Composable
fun DisplayEpisodes(viewModel: MainViewModel) {

	val state by viewModel.episodesState.collectAsState()
	val context = LocalContext.current

	LazyColumn {
		when (state.status) {
			ApiResponse.Status.LOADING -> {
				item {
					CircularProgressIndicator(
						modifier = Modifier
							.fillMaxSize()
							.wrapContentSize(align = Alignment.Center)
					)
				}

			}
			ApiResponse.Status.ERROR -> {
				Toast.makeText(context, "ERROR CODE: ${state.errorCode} - MESSAGE: ${state.errorMessage}", Toast.LENGTH_LONG).show()
			}

			ApiResponse.Status.SUCCESS -> {
				state.data?.results?.let { episodes ->
					items(episodes) { episode: Episode ->
						DefaultListItem(episode.name, listOf(episode.episode, episode.air_date))
					}
				}
			}
		}
	}
}
