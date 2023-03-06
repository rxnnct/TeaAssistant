package com.example.teaassistant.domain.usecase.teacard

import com.example.teaassistant.domain.models.teacard.TeaCard

class GetAllTeaCardsUseCase {

    fun execute(): ArrayList<TeaCard> {
        return arrayListOf(
            TeaCard(
                1,
                "Tieguanyin",
                "Oolong",
                "Fujian, China"
            ),
            TeaCard(
                2,
                "Huangshan Maofeng",
                "Green",
                "Anhui, China"
            )
        )
    }
}