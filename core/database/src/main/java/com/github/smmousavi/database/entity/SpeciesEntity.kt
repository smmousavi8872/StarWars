package com.github.smmousavi.database.entity

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity

@Entity
data class SpeciesEntity(
    @ColumnInfo(name = "speciesId")
    val id: String,
    @ColumnInfo(name = "speciesName")
    val name: String,
    @ColumnInfo(name = "speciesLanguage")
    val language: String,
    @Embedded
    val homeWorld: PlanetEntity,
)