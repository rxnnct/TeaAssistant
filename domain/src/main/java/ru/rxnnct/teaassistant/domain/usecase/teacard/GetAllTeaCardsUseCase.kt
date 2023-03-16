package ru.rxnnct.teaassistant.domain.usecase.teacard

import ru.rxnnct.teaassistant.domain.models.teacard.TeaCard
import ru.rxnnct.teaassistant.domain.repository.TeaCardRepository

class GetAllTeaCardsUseCase(private val teaCardRepository: TeaCardRepository) {

    fun execute(): ArrayList<TeaCard> {
        return teaCardRepository.getAllTeaCards()
    }
}