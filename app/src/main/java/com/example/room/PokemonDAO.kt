package com.example.test

import androidx.lifecycle.MutableLiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface PokemonDAO {

    @Insert
    suspend fun insert(pokemon: Pokemon): Long

    @Query("SELECT * FROM Pokemon WHERE id = :id")
    suspend fun getById(id: Long): Pokemon?

//    @Update
//    suspend fun update(pokemon: Pokemon)
//
//    @Delete
//    suspend fun delete(pokemon: Pokemon)
}

