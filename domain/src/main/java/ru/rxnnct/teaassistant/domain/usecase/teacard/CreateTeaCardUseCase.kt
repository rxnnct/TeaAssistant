package ru.rxnnct.teaassistant.domain.usecase.teacard

import ru.rxnnct.teaassistant.domain.models.teacard.TeaCardSaveParam

class CreateTeaCardUseCase {

    //stub
    fun execute(teaCardSaveParam: TeaCardSaveParam) : Boolean {
        if (teaCardSaveParam.name.isEmpty()) {
            return false
        } else {
            return true
        }
    }
}