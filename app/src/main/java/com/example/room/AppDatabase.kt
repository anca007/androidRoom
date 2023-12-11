package com.example.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.test.Pokemon
import com.example.test.PokemonDAO

@Database(entities = [Pokemon::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    //liste de nos DAOs
    abstract fun pokemonDAO() : PokemonDAO

    companion object{

        private var INSTANCE : AppDatabase? = null

        fun getInstance(context : Context) : AppDatabase{

            var instance = INSTANCE

            if (instance == null){

                instance = Room.databaseBuilder(
                    context,
                    AppDatabase::class.java,
                    "pokedex"
                ).fallbackToDestructiveMigration().build()

                INSTANCE = instance
            }
            return instance
        }
    }
}
