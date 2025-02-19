package com.github.smmousavi.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "planets")
data class PlanetEntity(
    @PrimaryKey
    @ColumnInfo(name = "planetId")
    val id: String,
    @ColumnInfo(name = "planetName")
    val name: String,
    @ColumnInfo(name = "planetPopulation")
    val population: Double,
)