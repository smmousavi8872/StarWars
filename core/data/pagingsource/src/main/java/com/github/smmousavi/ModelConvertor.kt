package com.github.smmousavi

import com.github.smmousavi.database.entity.CharacterEntity
import com.github.smmousavi.database.entity.PlanetEntity
import com.github.smmousavi.database.entity.SpeciesEntity
import com.github.smmousavi.model.Character
import com.github.smmousavi.model.Planet
import com.github.smmousavi.model.Species
import com.github.smmousavi.network.AllPeopleQuery
import com.github.smmousavi.network.PersonQuery
import com.github.smmousavi.network.retrofit.response.CharacterResponse


fun AllPeopleQuery.Person?.asEntity() = CharacterEntity(
    id = this?.id ?: "",
    name = this?.name ?: "",
    birthYear = this?.birthYear ?: "",
    eyeColor = this?.eyeColor ?: "",
    gender = this?.gender ?: "",
    hairColor = this?.hairColor ?: "",
    height = this?.height ?: 0,
    mass = this?.mass ?: 0.0,
    skinColor = this?.skinColor ?: "",
    searched = false,
    species = SpeciesEntity(
        this?.species?.id ?: "",
        this?.species?.name ?: "",
        "English",
        PlanetEntity(
            id = this?.species?.homeworld?.id ?: "",
            name = this?.species?.homeworld?.name ?: "",
            population = this?.species?.homeworld?.population ?: 0.0
        )
    )
)

fun CharacterEntity.asExternalModel() = Character(
    id = id,
    name = name,
    birthYear = birthYear,
    eyeColor = eyeColor,
    gender = gender,
    hairColor = hairColor,
    height = height,
    mass = mass,
    skinColor = skinColor,
    species = Species(
        species.id,
        species.name,
        species.language,
        Planet(species.homeWorld.id, species.homeWorld.name, species.homeWorld.population)
    ),
    films = listOf()
)

fun AllPeopleQuery.Person?.asExternalModel(): Character {
    val character = Character(
        id = this?.id ?: "",
        name = this?.name ?: "",
        birthYear = this?.birthYear ?: "",
        eyeColor = this?.eyeColor ?: "",
        gender = this?.gender ?: "",
        hairColor = this?.hairColor ?: "",
        height = this?.height ?: 0,
        mass = this?.mass ?: 0.0,
        skinColor = this?.skinColor ?: "",
        species = Species(
            id = this?.species?.id ?: "",
            name = this?.species?.name ?: "",
            language = this?.species?.language ?: "",
            Planet(
                this?.species?.homeworld?.id ?: "",
                this?.species?.homeworld?.name ?: "",
                this?.species?.homeworld?.population ?: 0.0
            )
        ),
        films = listOf()
    )
    return character
}

fun PersonQuery.Person.asEntity(): CharacterEntity = CharacterEntity(
    id = id,
    name = name ?: "",
    birthYear = birthYear ?: "",
    eyeColor = eyeColor ?: "",
    gender = gender ?: "",
    hairColor = hairColor ?: "",
    height = height ?: 0,
    mass = mass ?: 0.0,
    skinColor = skinColor ?: "",
    searched = false,
    species = SpeciesEntity(
        id = species?.id ?: "",
        name = species?.name ?: "",
        language = species?.language ?: "",
        PlanetEntity(
            id = this.species?.homeworld?.id ?: "",
            name = this.species?.homeworld?.name ?: "",
            population = this.species?.homeworld?.population ?: 0.0
        )
    )
)

fun PersonQuery.Person.asExternalModel(): Character = Character(
    id = id,
    name = name ?: "",
    birthYear = birthYear ?: "",
    eyeColor = eyeColor ?: "",
    gender = gender ?: "",
    hairColor = hairColor ?: "",
    height = height ?: 0,
    mass = mass ?: 0.0,
    skinColor = skinColor ?: "",
    species = Species(
        id = species?.id ?: "",
        name = species?.name ?: "",
        language = species?.language ?: "",
        Planet(
            species?.homeworld?.id ?: "",
            species?.homeworld?.name ?: "",
            species?.homeworld?.population ?: 0.0
        )
    ),
    films = listOf()
)

fun CharacterResponse.asEntity(): CharacterEntity = CharacterEntity(
    id = id ?: "",
    name = name ?: "",
    birthYear = birthYear ?: "",
    eyeColor = eyeColor ?: "",
    gender = gender ?: "",
    hairColor = hairColor ?: "",
    height = height ?: 0,
    mass = mass ?: 0.0,
    skinColor = skinColor ?: "",
    searched = true,
    species = SpeciesEntity(
        id = "",
        name = "",
        language = "",
        PlanetEntity(
            id = "",
            name = "",
            population = 0.0
        )
    )
)

fun CharacterResponse.asExternalModel(): Character = Character(
    id = id ?: "",
    name = name ?: "",
    birthYear = birthYear ?: "",
    eyeColor = eyeColor ?: "",
    gender = gender ?: "",
    hairColor = hairColor ?: "",
    height = height ?: 0,
    mass = mass ?: 0.0,
    skinColor = skinColor ?: "",
    species = Species(
        id = "",
        name = "",
        language = "",
        Planet(
            "",
            "",
            0.0
        )
    ),
    films = listOf()
)


