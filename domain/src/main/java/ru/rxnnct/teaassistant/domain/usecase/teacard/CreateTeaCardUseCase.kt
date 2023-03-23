package ru.rxnnct.teaassistant.domain.usecase.teacard

import ru.rxnnct.teaassistant.domain.models.teacard.TeaCardSaveParam
import ru.rxnnct.teaassistant.domain.repository.TeaCardRepository

class CreateTeaCardUseCase(private val teaCardRepository: TeaCardRepository) {

    //stub
    fun execute(teaCardSaveParam: TeaCardSaveParam) : Boolean {
        return teaCardRepository.createTeaCard(teaCardSaveParam)
    }
}