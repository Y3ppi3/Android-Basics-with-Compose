package com.example.app.data

import com.example.app.R
import com.example.app.model.Hero

object HeroRepository {
    val heroes = listOf(
        Hero(
            nameRes = R.string.hero1_name,
            descriptionRes = R.string.hero1_description,
            imageRes = R.drawable.android_superhero1
        ),
        Hero(
            nameRes = R.string.hero2_name,
            descriptionRes = R.string.hero2_description,
            imageRes = R.drawable.android_superhero2
        ),
        Hero(
            nameRes = R.string.hero3_name,
            descriptionRes = R.string.hero3_description,
            imageRes = R.drawable.android_superhero3
        ),
        Hero(
            nameRes = R.string.hero4_name,
            descriptionRes = R.string.hero4_description,
            imageRes = R.drawable.android_superhero4
        ),
        Hero(
            nameRes = R.string.hero5_name,
            descriptionRes = R.string.hero5_description,
            imageRes = R.drawable.android_superhero5
        ),
        Hero(
            nameRes = R.string.hero6_name,
            descriptionRes = R.string.hero6_description,
            imageRes = R.drawable.android_superhero6
        )
    )
}