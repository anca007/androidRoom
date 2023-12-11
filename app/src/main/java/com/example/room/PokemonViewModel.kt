package com.example.test

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import com.example.room.AppDatabase
import kotlinx.coroutines.launch


class PokemonViewModel(private val pokemonDAO: PokemonDAO) : ViewModel() {

    var pokemon = MutableLiveData<Pokemon>()

    fun addPokemon(pokemon: Pokemon): MutableLiveData<Long> {
        var id = MutableLiveData<Long>()

        viewModelScope.launch {
            id.value = pokemonDAO.insert(pokemon)
        }
        return id
    }

    fun getPokemon(id : Long){
        viewModelScope.launch {
            pokemon.value = pokemonDAO.getById(id)
        }
    }



    companion object {

        val Factory: ViewModelProvider.Factory = object : ViewModelProvider.Factory {

            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(
                modelClass: Class<T>,
                extras: CreationExtras
            ): T {
                val application = checkNotNull(extras[APPLICATION_KEY])

                return PokemonViewModel(
                    AppDatabase.getInstance(application.applicationContext).pokemonDAO()
                ) as T
            }


        }
    }
}