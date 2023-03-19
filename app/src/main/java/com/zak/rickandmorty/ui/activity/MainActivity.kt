package com.zak.rickandmorty.ui.activity

import androidx.appcompat.app.AppCompatActivity
import com.zak.rickandmorty.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.*
import androidx.activity.compose.setContent
import android.os.Bundle
import androidx.compose.material.Scaffold
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.navigation.compose.rememberNavController
import com.zak.rickandmorty.R
import com.zak.rickandmorty.ui.bar.BottomNavigationBar
import com.zak.rickandmorty.ui.navigation.Navigation
import com.zak.rickandmorty.ui.bar.TopBar

class MainActivity : AppCompatActivity() {

	private val viewModel by viewModel<MainViewModel>()

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)

		setContent {
			val context = LocalContext.current
			val navController = rememberNavController()
			Scaffold(
				topBar = { TopBar() },
				bottomBar = { BottomNavigationBar(navController) },
				content = { padding ->
					Box(modifier = Modifier.padding(padding)) {
						Navigation(navController = navController, viewModel) {
							startActivity(InfoActivity.intent(context, it))
						}
					}
				},
				backgroundColor = colorResource(R.color.purple_200)
			)
		}
	}
}