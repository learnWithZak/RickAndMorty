package com.zak.rickandmorty.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.zak.rickandmorty.model.Character
import com.zak.rickandmorty.ui.bar.NavigationItem
import com.zak.rickandmorty.viewmodel.MainViewModel

@Composable
fun Navigation(navController: NavHostController, viewModel: MainViewModel, execute: (character: Character) -> Unit) {

	NavHost(navController, startDestination = NavigationItem.Character.title) {
		composable(NavigationItem.Character.title) {
			DisplayDetails(viewModel) {
				execute(it)
			}
		}
		composable(NavigationItem.Location.title) {
			DisplayLocations(viewModel)
		}
		composable(NavigationItem.Episode.title) {
			DisplayEpisodes(viewModel)
		}
	}
}