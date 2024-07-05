package com.github.smmousavi.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "films")
data class FilmEntity(
    @PrimaryKey
    @ColumnInfo(name = "filmId")
    val id: String,
    @ColumnInfo(name = "filmTitle")
    val title: String,
)
