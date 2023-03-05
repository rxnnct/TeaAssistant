package com.example.teaassistant.domain.usecase

import com.example.teaassistant.domain.models.CreateTeaCardParam

class CreateTeaCardUseCase {

    //stub
    fun execute(param: CreateTeaCardParam) : Boolean {
        if (param.name.isEmpty()) {
            return false
        } else {
            return true
        }
    }
}