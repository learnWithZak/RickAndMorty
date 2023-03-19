package com.zak.rickandmorty.ui.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.zak.rickandmorty.model.Character
import com.zak.rickandmorty.ui.characterInfo.ViewCharacterInfo

class InfoActivity : ComponentActivity() {

	companion object {
		const val infoId = "infoId"

		fun intent(context: Context, character: Character) =
			Intent(context, InfoActivity::class.java).apply {
				putExtra(infoId, character)
			}
	}

	private val character: Character by lazy {
		intent?.getSerializableExtra(infoId) as Character
	}


	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContent {
			ViewCharacterInfo(character = character)
		}
	}
}














