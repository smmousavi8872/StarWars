package com.github.smmousavi.repository

import com.github.smmousavi.database.entity.CharacterEntity
import com.github.smmousavi.model.Character
import com.github.smmousavi.network.PeopleQuery
import com.github.smmousavi.network.PersonQuery

fun PeopleQuery.Person.asEntity() = CharacterEntity(
    id = id,
    name = name ?: "",
    birthYear = birthYear ?: "",
    eyeColor = eyeColor ?: "",
    gender = gender ?: "",
    hairColor = hairColor ?: "",
    height = height ?: 0,
    mass = mass ?: 0.0,
    skinColor = skinColor ?: ""
)

fun PeopleQuery.Person.asExternalModel() = Character(
    id = id,
    name = name ?: "",
    birthYear = birthYear ?: "",
    eyeColor = eyeColor ?: "",
    gender = gender ?: "",
    hairColor = hairColor ?: "",
    height = height ?: 0,
    mass = mass ?: 0.0,
    skinColor = skinColor ?: ""
)

fun PersonQuery.Person.asEntity(): CharacterEntity = CharacterEntity(
    id = id,
    name = name ?: "",
    birthYear = birthYear ?: "",
    eyeColor = eyeColor ?: "",
    gender = gender ?: "",
    hairColor = hairColor ?: "",
    height = height ?: 0,
    mass = mass ?: 0.0,
    skinColor = skinColor ?: ""
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
    skinColor = skinColor ?: ""
)






