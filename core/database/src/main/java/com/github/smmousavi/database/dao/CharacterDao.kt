package com.github.smmousavi.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.github.smmousavi.database.entity.CharacterEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface CharacterDao {

     @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllCharacters(products: List<CharacterEntity>)

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