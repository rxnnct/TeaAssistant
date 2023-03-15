package ru.rxnnct.teaassistant.domain.usecase.teacard

import ru.rxnnct.teaassistant.domain.models.teacard.TeaCard

class GetTeaCardUseCase {

    fun execute(id: Long): TeaCard {
        return TeaCard(
            id,
            "Tieguanyin",
            "Oolong",
            "Fujian"
        )
    }
}