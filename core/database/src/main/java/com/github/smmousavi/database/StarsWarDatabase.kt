package com.github.smmousavi.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.github.smmousavi.database.dao.CharacterDao
import com.github.smmousavi.database.dao.SearchCharacterDao
import com.github.smmousavi.database.entity.CharacterEntity

@Database(entities = [CharacterEntity::class], version = 1, exportSchema = true)
abstract class StarsWarDatabase : RoomDatabase() {

    abstract fun characterDao(): CharacterDao

    abstract fun searchCharacterDao(): SearchCharacterDao
}