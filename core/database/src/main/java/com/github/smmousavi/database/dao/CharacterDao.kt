package com.github.smmousavi.database.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.github.smmousavi.database.entity.CharacterEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface CharacterDao {

    // update or insert a products under the primary key
    @Upsert
    suspend fun upsertCharacters(products: List<CharacterEntity>)

    @Query("SELECT * FROM characters")
    fun getAllCharacters(): List<CharacterEntity>

    @Query("SELECT * FROM characters WHERE id = :id")
    fun getCharacterById(id: Int): CharacterEntity

    @Query(value = "DELETE FROM characters WHERE id in (:ids)")
    suspend fun deleteCharacter(ids: List<Int>)

    @Query("SELECT * FROM characters WHERE name LIKE '%' || :query || '%'")
    fun searchCharacters(query: String): Flow<List<CharacterEntity>>

    @Query("SELECT COUNT(*) FROM characters")
    fun charactersCount(): Int
}