package com.zak.rickandmorty.model

import java.io.Serializable

data class CharactersResponse(
	val results: List<Character> = emptyList()
)

data class Character(
	val id: Int,
	val name: String,
	val status: String,
	val species: String,
	val type: String,
	val gender: String,
	val image: String,
	val episode: List<String>,
	val url: String,
	val created: String
) : Serializable