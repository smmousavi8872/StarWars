package com.github.smmousavi.database.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Update
import com.github.smmousavi.database.entity.CharacterEntity

@Dao
interface SearchCharacterDao {

    @Update
    suspend fun updateSearchedCharacter(products: List<CharacterEntity>)

    @Query("SELECT * FROM characters WHERE searched = 1")
    fun getSearchedCharacters(): List<CharacterEntity>


}