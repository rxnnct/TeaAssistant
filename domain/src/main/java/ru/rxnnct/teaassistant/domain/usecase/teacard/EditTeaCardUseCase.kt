package ru.rxnnct.teaassistant.domain.usecase.teacard

import ru.rxnnct.teaassistant.domain.models.teacard.TeaCard
import ru.rxnnct.teaassistant.domain.repository.TeaCardRepository

class EditTeaCardUseCase(private val teaCardRepository: TeaCardRepository) {

    fun execute(teaCard: TeaCard) : Boolean {
        return teaCardRepository.editTeaCard(teaCard)
    }
}