package com.github.smmousavi.test_doubles.character

import com.github.smmousavi.model.Character
import com.github.smmousavi.model.Film
import com.github.smmousavi.model.Planet
import com.github.smmousavi.model.Species

object Faker {

    fun character() = Character(
        id = "1",
        name = "Mohsen",
        birthYear = "1993",
        height = 175,
        gender = "male",
        skinColor = "White",
        hairColor = "Black",
        eyeColor = "Brown",
        mass = 70.3,
        species = Species(
            "1", "Human", "Farsi", Planet("1", "Earth", 10000000.0)
        ),
        films = listOf(Film("1", "A New Hope", "1977-05-25"))
    )

    fun characterList() = listOf(
        Character(
            id = "1",
            name = "Mohsen",
            birthYear = "1993",
            height = 175,
            gender = "male",
            skinColor = "White",
            hairColor = "Black",
            eyeColor = "Brown",
            mass = 70.3,
            species = Species(
                "1", "Human", "Farsi", Planet("1", "Earth", 1000000000.0)
            ),
            films = listOf(Film("1", "A New Hope", "1977-05-25"))
        ),
        Character(
            id = "1",
            name = "Mohsen",
            birthYear = "1993",
            height = 175,
            gender = "male",
            skinColor = "White",
            hairColor = "Black",
            eyeColor = "Brown",
            mass = 70.3,
            species = Species(
                "1", "Human", "Farsi", Planet("1", "Earth", 1000000000.0)
            ),
            films = listOf(Film("1", "A New Hope", "1977-05-25"))
        ),
        Character(
            id = "1",
            name = "Mohsen",
            birthYear = "1993",
            height = 175,
            gender = "male",
            skinColor = "White",
            hairColor = "Black",
            eyeColor = "Brown",
            mass = 70.3,
            species = Species(
                "1", "Human", "Farsi", Planet("1", "Earth", 1000000000.0)
            ),
            films = listOf(Film("1", "A New Hope", "1977-05-25"))
        ),
        Character(
            id = "1",
            name = "Mohsen",
            birthYear = "1993",
            height = 175,
            gender = "male",
            skinColor = "White",
            hairColor = "Black",
            eyeColor = "Brown",
            mass = 70.3,
            species = Species(
                "1", "Human", "Farsi", Planet("1", "Earth", 1000000000.0)
            ),
            films = listOf(Film("1", "A New Hope", "1977-05-25"))
        ),
        Character(
            id = "1",
            name = "Mohsen",
            birthYear = "1993",
            height = 175,
            gender = "male",
            skinColor = "White",
            hairColor = "Black",
            eyeColor = "Brown",
            mass = 70.3,
            species = Species(
                "1", "Human", "Farsi", Planet("1", "Earth", 1000000000.0)
            ),
            films = listOf(Film("1", "A New Hope", "1977-05-25"))
        )
    )
}