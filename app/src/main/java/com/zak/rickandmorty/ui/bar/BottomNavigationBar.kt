package com.zak.rickandmorty.ui.bar

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.zak.rickandmorty.R

@Composable
fun BottomNavigationBar(navController: NavController) {
	val items = listOf(
		NavigationItem.Character,
		NavigationItem.Location,
		NavigationItem.Episode
	)
	BottomNavigation(
		backgroundColor = colorResource(id = R.color.color_pink_navigation_bottom),
		contentColor = Color.White
	) {
		val navBackStackEntry by navController.currentBackStackEntryAsState()
		val currentRoute = navBackStackEntry?.destination?.route
		items.forEach { item ->
			BottomNavigationItem(
				icon = { Icon(painterResource(id = item.icon), contentDescription = item.title) },
				label = { Text(text = item.title) },
				selectedContentColor = Color.White,
				unselectedContentColor = Color.White.copy(0.4f),
				alwaysShowLabel = true,
				selected = currentRoute == item.title,
				onClick = {
					navController.navigate(item.title) {
						// Pop up to the start destination of the graph to
						// avoid building up a large stack of destinations
						// on the back stack as users select items
						navController.graph.startDestinationRoute?.let { route ->
							popUpTo(route) {
								saveState = true
							}
						}
						// Avoid multiple copies of the same destination when
						// reselecting the same item
						launchSingleTop = true
						// Restore state when reselecting a previously selected item
						restoreState = true
					}
				}
			)
		}
	}
}

sealed class NavigationItem(val icon: Int, val title: String) {
	object Character : NavigationItem(R.drawable.ic_character, "Character")
	object Location : NavigationItem(R.drawable.ic_location, "Location")
	object Episode : NavigationItem(R.drawable.ic_episode, "Episode")
}