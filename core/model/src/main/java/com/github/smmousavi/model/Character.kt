package com.github.smmousavi.model

data class Character(
    val id: String,
    val name: String,
    val birthYear: String?,
    val eyeColor: String?,
    val gender: String?,
    val hairColor: String?,
    val height: Int?,
    val mass: Float?,
    val skinColor: String?,
    val homeworld: Planet?,
    val films: List<Film>
)



