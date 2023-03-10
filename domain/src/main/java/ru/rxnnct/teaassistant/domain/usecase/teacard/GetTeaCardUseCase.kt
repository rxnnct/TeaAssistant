package ru.rxnnct.teaassistant.domain.usecase.teacard

import ru.rxnnct.teaassistant.domain.models.teacard.TeaCard

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