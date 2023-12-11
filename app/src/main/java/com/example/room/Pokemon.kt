package com.example.test

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

enum class Type {
    AIR, FEU, PLANTE, ELEC
}

@Entity
data class Pokemon(
    @PrimaryKey(autoGenerate = true)
    val id : Long = 0,
    val name : String,
    val hp : Int,
    @ColumnInfo("power_attack")
    val pa : Int,
    val type : Type
)


