package com.zak.rickandmorty.ui.bar

import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.sp
import com.zak.rickandmorty.R

@Composable
fun TopBar() {
	TopAppBar(
		title = { Text(text = stringResource(R.string.app_name), fontSize = 18.sp) },
		backgroundColor = colorResource(id = R.color.purple_700),
		contentColor = Color.White
	)
}