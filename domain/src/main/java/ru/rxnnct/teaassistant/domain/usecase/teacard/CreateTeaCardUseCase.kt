package ru.rxnnct.teaassistant.domain.usecase.teacard

import ru.rxnnct.teaassistant.domain.models.teacard.TeaCardSaveParam

class CreateTeaCardUseCase {

    //stub
    fun execute(param: TeaCardSaveParam) : Boolean {
        if (param.name.isEmpty()) {
            return false
        } else {
            return true
        }
    }
}