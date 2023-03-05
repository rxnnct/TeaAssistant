package com.example.teaassistant.domain.usecase

import com.example.teaassistant.domain.models.TeaCard

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