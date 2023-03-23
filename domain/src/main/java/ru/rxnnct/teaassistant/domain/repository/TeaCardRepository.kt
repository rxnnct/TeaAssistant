package ru.rxnnct.teaassistant.domain.repository

import ru.rxnnct.teaassistant.domain.models.teacard.TeaCard
import ru.rxnnct.teaassistant.domain.models.teacard.TeaCardSaveParam

interface TeaCardRepository {

    fun createTeaCard(teaCardSaveParam: TeaCardSaveParam): Boolean

    fun editTeaCard(teaCard: TeaCard): Boolean

    fun deleteTeaCard(id: Long): Boolean

    fun getTeaCard(id: Long): TeaCard

    fun getAllTeaCards(): ArrayList<TeaCard>
}