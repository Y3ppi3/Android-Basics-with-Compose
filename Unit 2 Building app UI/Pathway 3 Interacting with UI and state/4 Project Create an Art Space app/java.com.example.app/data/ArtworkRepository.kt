package com.example.testapp.data

import com.example.app.R
import com.example.testapp.model.Artwork

object ArtworkRepository {
    fun getArtworks(): List<Artwork> {
        return listOf(
            Artwork(
                title = "Звёздная ночь",
                artist = "Винсент Ван Гог",
                year = "1889",
                description = "«Звёздная ночь» — одна из наиболее известных картин нидерландского художника-постимпрессиониста Винсента Ван Гога. Представляет вид из восточного окна его спальни в Сен-Реми-де-Прованс на предрассветное небо и воображаемую деревню.",
                imageResId = R.drawable.starry_night
            ),
            Artwork(
                title = "Мона Лиза",
                artist = "Леонардо да Винчи",
                year = "1503-1519",
                description = "«Мона Лиза» или «Джоконда» — картина Леонардо да Винчи, одно из самых известных произведений живописи. Точная дата написания неизвестна. Многие исследователи считают, что на картине изображена Лиза Герардини, жена флорентийского торговца Франческо дель Джокондо.",
                imageResId = R.drawable.mona_lisa
            ),
            Artwork(
                title = "Постоянство памяти",
                artist = "Сальвадор Дали",
                year = "1931",
                description = "«Постоянство памяти» — одна из самых известных картин испанского сюрреалиста Сальвадора Дали. На картине изображены мягкие, «стекающие» часы на фоне пейзажа Каталонии. Это произведение является ярким примером параноидально-критического метода в искусстве.",
                imageResId = R.drawable.persistence_of_memory
            ),
            Artwork(
                title = "Девочка с персиками",
                artist = "Валентин Серов",
                year = "1887",
                description = "«Девочка с персиками» — портрет Веры Мамонтовой, выполненный Валентином Серовым. Картина написана в усадьбе Абрамцево, расположенной в Московской губернии, принадлежавшей С. И. Мамонтову. Девочка, изображённая на картине — дочь Саввы Мамонтова, Вера.",
                imageResId = R.drawable.girl_with_peaches
            ),
            Artwork(
                title = "Крик",
                artist = "Эдвард Мунк",
                year = "1893",
                description = "«Крик» — экспрессионистская картина норвежского художника Эдварда Мунка, на которой изображена кричащая в отчаянии человеческая фигура на фоне кроваво-красного неба. Считается визуальным воплощением тревоги и экзистенциального ужаса человека XX века.",
                imageResId = R.drawable.the_scream
            ),
            Artwork(
                title = "Утро в сосновом лесу",
                artist = "Иван Шишкин",
                year = "1889",
                description = "«Утро в сосновом лесу» — картина русских художников Ивана Шишкина и Константина Савицкого. Шишкин является автором пейзажа, а фигуры медведей были написаны Савицким. Одна из самых известных картин русской живописи, часто воспроизводимая на различных предметах, включая конфетные обертки.",
                imageResId = R.drawable.morning_in_pine_forest
            )
        )
    }
}