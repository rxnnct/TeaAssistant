package ru.rxnnct.teaassistant.domain.usecase.teacard

import ru.rxnnct.teaassistant.domain.models.teacard.TeaCard

class EditTeaCardUseCase {

    fun execute(teaCard: TeaCard) : Boolean {
        if (teaCard.name.isEmpty()) {
            return false
        } else {
            return true
        }
    }
}