package com.github.smmousavi.test_doubles.entity

import com.github.smmousavi.database.entity.CharacterEntity
import com.github.smmousavi.database.entity.PlanetEntity
import com.github.smmousavi.database.entity.SpeciesEntity

object EntityFaker {
    fun characterEntity() = CharacterEntity(
        id = "1",
        name = "Mohsen",
        birthYear = "1993",
        height = 175,
        gender = "male",
        skinColor = "White",
        hairColor = "Black",
        eyeColor = "Brown",
        mass = 70.3,
        searched = false,
        species = SpeciesEntity(
            "1", "Human", "Human", PlanetEntity("1", "Earth", 1000000000.0)
        ),
    )

    fun characterEntityList() = listOf(
        CharacterEntity(
            id = "1",
            name = "Mohsen",
            birthYear = "1993",
            height = 175,
            gender = "male",
            skinColor = "White",
            hairColor = "Black",
            eyeColor = "Brown",
            mass = 70.3,
            searched = false,
            species = SpeciesEntity(
                "1", "Human", "Human", PlanetEntity("1", "Earth", 1000000000.0)
            ),
        ),
        CharacterEntity(
            id = "1",
            name = "Mohsen",
            birthYear = "1993",
            height = 175,
            gender = "male",
            skinColor = "White",
            hairColor = "Black",
            eyeColor = "Brown",
            mass = 70.3,
            searched = false,
            species = SpeciesEntity(
                "1", "Human", "Human", PlanetEntity("1", "Earth", 1000000000.0)
            ),
        ),
        CharacterEntity(
            id = "1",
            name = "Mohsen",
            birthYear = "1993",
            height = 175,
            gender = "male",
            skinColor = "White",
            hairColor = "Black",
            eyeColor = "Brown",
            mass = 70.3,
            searched = false,
            species = SpeciesEntity(
                "1", "Human", "Human", PlanetEntity("1", "Earth", 1000000000.0)
            ),
        ),
        CharacterEntity(
            id = "1",
            name = "Mohsen",
            birthYear = "1993",
            height = 175,
            gender = "male",
            skinColor = "White",
            hairColor = "Black",
            eyeColor = "Brown",
            mass = 70.3,
            searched = false,
            species = SpeciesEntity(
                "1", "Human", "Human", PlanetEntity("1", "Earth", 1000000000.0)
            ),
        ),
        CharacterEntity(
            id = "1",
            name = "Mohsen",
            birthYear = "1993",
            height = 175,
            gender = "male",
            skinColor = "White",
            hairColor = "Black",
            eyeColor = "Brown",
            mass = 70.3,
            searched = false,
            species = SpeciesEntity(
                "1", "Human", "Human", PlanetEntity("1", "Earth", 1000000000.0)
            ),
        )
    )
}