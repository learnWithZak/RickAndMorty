package com.zak.rickandmorty.model

data class CharactersResponse(
	val info: Info,
	val results: List<Character>
)

data class Info(
	val count: Int,
	val pages: Int,
	val next: String?,
	val prev: String?
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
)