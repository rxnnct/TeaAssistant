package ru.rxnnct.teaassistant.domain.usecase.teacard

import ru.rxnnct.teaassistant.domain.models.teacard.TeaCard
import ru.rxnnct.teaassistant.domain.repository.TeaCardRepository

class GetTeaCardUseCase(private val teaCardRepository: TeaCardRepository) {

    fun execute(id: Long): TeaCard {
        return TeaCard(
            id,
            "Tieguanyin",
            "Oolong",
            "Fujian"
        )
    }
}