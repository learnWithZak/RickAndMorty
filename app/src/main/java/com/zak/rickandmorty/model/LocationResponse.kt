package com.zak.rickandmorty.model

data class LocationsResponse(
	val results: List<Location> = emptyList()
)

data class Location(
	val id: Int,
	val name: String,
	val type: String,
	val dimension: String,
	val residents: List<String>,
	val url: String,
	val created: String
)