package com.zak.rickandmorty.ui.listItem

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun DefaultListItem(title: String, otherInfo: List<String>) {
	Card(
		modifier = Modifier
			.padding(10.dp)
			.fillMaxWidth(),
		elevation = 10.dp,
		shape = RoundedCornerShape(corner = CornerSize(10.dp))
	) {
		Row(
			modifier = Modifier
				.padding(5.dp)
				.fillMaxWidth(),
			verticalAlignment = Alignment.CenterVertically
		) {
			Column {
				Text(text = title, style = MaterialTheme.typography.h4)
				Spacer(modifier = Modifier.height(4.dp))
				Row(
					modifier = Modifier.fillMaxWidth(),
					horizontalArrangement = Arrangement.SpaceBetween
				) {
					for (info in otherInfo) {
						Text(text = info, style = MaterialTheme.typography.h6)
					}
				}
			}
		}
	}
}