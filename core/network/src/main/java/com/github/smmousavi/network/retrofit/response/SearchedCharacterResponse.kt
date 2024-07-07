package com.github.smmousavi.network.retrofit.response

import com.google.gson.annotations.SerializedName

data class SearchedCharactersResponse(
    val count: Int,
    val next: String?,
    val previous: String?,
    val results: List<CharacterResponse>,
)

data class CharacterResponse(
    @SerializedName("id")
    val id: String?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("height")
    val height: String?,
    @SerializedName("mass")
    val mass: String?,
    @SerializedName("hair_color")
    val hairColor: String?,
    @SerializedName("skin_color")
    val skinColor: String?,
    @SerializedName("eye_color")
    val eyeColor: String?,
    @SerializedName("birth_year")
    val birthYear: String?,
    @SerializedName("gender")
    val gender: String?,
)