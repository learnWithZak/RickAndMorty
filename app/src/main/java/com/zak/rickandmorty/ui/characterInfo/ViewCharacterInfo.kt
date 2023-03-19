package com.zak.rickandmorty.ui.characterInfo

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.zak.rickandmorty.model.Character
import com.zak.rickandmorty.ui.character.CharacterImage

@Composable
fun ViewCharacterInfo(character: Character) {
	val scrollState = rememberScrollState()
	Box(
		modifier = Modifier
			.fillMaxSize()
			.background(Color.Black)
	) {
	Card(
		modifier = Modifier.padding(10.dp),
		elevation = 10.dp,
		shape = RoundedCornerShape(corner = CornerSize(10.dp))
	) {
		Column(
			modifier = Modifier
				.fillMaxWidth()
				.verticalScroll(scrollState)
				.padding(10.dp)
		) {
			CharacterImage(character.image)
			Spacer(modifier = Modifier.height(16.dp))
			Text(
				text = character.name,
				style = MaterialTheme.typography.h3
			)
			Spacer(modifier = Modifier.height(16.dp))
			Text(
				text = "id: ${character.id}",
				style = MaterialTheme.typography.h5
			)
			Spacer(modifier = Modifier.height(16.dp))
			Text(
				text = "name: ${character.name}",
				style = MaterialTheme.typography.h5
			)
			Spacer(modifier = Modifier.height(16.dp))
			Text(
				text = "status: ${character.status}",
				style = MaterialTheme.typography.h5
			)
			Spacer(modifier = Modifier.height(16.dp))
			Text(
				text = "species: ${character.species}",
				style = MaterialTheme.typography.h5
			)
			Spacer(modifier = Modifier.height(16.dp))
			Text(
				text = "type: ${character.type.ifEmpty { "UNKNOWN" }}",
				style = MaterialTheme.typography.h5
			)
			Spacer(modifier = Modifier.height(16.dp))
			Text(
				text = "gender: ${character.gender}",
				style = MaterialTheme.typography.h5
			)
			Spacer(modifier = Modifier.height(16.dp))

		}
	}
	}
}
