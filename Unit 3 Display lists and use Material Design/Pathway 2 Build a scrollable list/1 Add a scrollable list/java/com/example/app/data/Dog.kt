package com.example.app.data

import androidx.annotation.DrawableRes
import com.example.app.R

/**
 * A data class to represent the information presented in the dog card
 */
data class Dog(
    @DrawableRes val imageResourceId: Int,
    val name: String,
    val age: Int,
    val hobbies: String
)

val dogs = listOf(
    Dog(R.drawable.koda, "Koda", 2, "Eating treats on the terrace"),
    Dog(R.drawable.lola, "Lola", 16, "Barking at squirrels, sleeping in dangerous places"),
    Dog(R.drawable.frankie, "Frankie", 2, "Stealing socks, getting belly rubs"),
    Dog(R.drawable.nox, "Nox", 8, "Meeting new animals, playing fetch"),
    Dog(R.drawable.faye, "Faye", 8, "Digging in the garden, chasing birds"),
    Dog(R.drawable.bella, "Bella", 14, "Sleeping all day, demanding attention"),
    Dog(R.drawable.moby, "Moby", 5, "Drooling, playing with toys"),
    Dog(R.drawable.tzeitel, "Tzeitel", 7, "Going on walks, sniffing new things"),
    Dog(R.drawable.leroy, "Leroy", 4, "Stealing food from the table, requesting pets")
)