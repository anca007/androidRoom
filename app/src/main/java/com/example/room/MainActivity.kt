package com.example.room

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.example.test.Pokemon
import com.example.test.PokemonViewModel
import com.example.test.Type


private const val TAG = "MainActivity"
class MainActivity : AppCompatActivity() {

    val vm : PokemonViewModel by viewModels { PokemonViewModel.Factory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        vm.addPokemon(Pokemon(0, "Pikachu", 400, 4500, Type.ELEC)).observe(this){
            Log.i(TAG, "Id du pokemon ajoutée: " + it)

            vm.getPokemon(it)
            vm.pokemon.observe(this){
                Log.i(TAG, "Info du pokemon crée: " + it)
            }
        }

    }


}