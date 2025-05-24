package com.example.testapp.data

import com.example.app.R
import com.example.testapp.model.Affirmation

class Datasource {
    fun loadAffirmations(): List<Affirmation> {
        return listOf(
            Affirmation("text_0_debug", R.drawable.ic_launcher_background),
            Affirmation("text_1_debug", R.drawable.ic_launcher_background),
            Affirmation("text_2_debug", R.drawable.ic_launcher_foreground),
            Affirmation("text_3_debug", R.drawable.ic_launcher_foreground),
            Affirmation("text_4_debug", R.drawable.ic_launcher_background),
            Affirmation("text_5_debug", R.drawable.ic_launcher_background),
            Affirmation("text_6_debug", R.drawable.ic_launcher_foreground),
            Affirmation("text_7_debug", R.drawable.ic_launcher_foreground),
            Affirmation("text_8_debug", R.drawable.ic_launcher_background),
            Affirmation("text_9_debug", R.drawable.ic_launcher_background)
        )
    }
}