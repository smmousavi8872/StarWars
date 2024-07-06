package com.github.smmousavi

import com.github.smmousavi.database.entity.CharacterEntity
import com.github.smmousavi.model.Character
import com.github.smmousavi.network.AllPeopleQuery
import com.github.smmousavi.network.PersonQuery


fun AllPeopleQuery.Person?.asEntity() = CharacterEntity(
    id = this?.id ?: "",
    name = this?.name ?: "",
    birthYear = this?.birthYear ?: "",
    eyeColor = this?.eyeColor ?: "",
    gender = this?.gender ?: "",
    hairColor = this?.hairColor ?: "",
    height = this?.height ?: 0,
    mass = this?.mass ?: 0.0,
    skinColor = this?.skinColor ?: ""
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
    skinColor = skinColor
)

fun AllPeopleQuery.Person.asExternalModel() = Character(
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



