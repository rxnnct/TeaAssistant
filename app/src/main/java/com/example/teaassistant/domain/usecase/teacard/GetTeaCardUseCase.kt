package com.example.teaassistant.domain.usecase.teacard

import com.example.teaassistant.domain.models.teacard.TeaCard

class GetTeaCardUseCase {

    fun execute(): TeaCard {
        return TeaCard(
            1,
            "Tieguanyin",
            "Oolong",
            "Fujian"
        )
    }
}