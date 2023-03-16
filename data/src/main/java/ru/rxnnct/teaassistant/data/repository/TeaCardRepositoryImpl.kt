package ru.rxnnct.teaassistant.data.repository

import ru.rxnnct.teaassistant.data.storage.TeaCardStorage
import ru.rxnnct.teaassistant.domain.models.teacard.TeaCard
import ru.rxnnct.teaassistant.domain.models.teacard.TeaCardSaveParam
import ru.rxnnct.teaassistant.domain.repository.TeaCardRepository

class TeaCardRepositoryImpl(private val teaCardStorage: TeaCardStorage) : TeaCardRepository {
    override fun createTeaCard(teaCardSaveParam: TeaCardSaveParam): Boolean {
        TODO("Not yet implemented")
    }

    override fun editTeaCard(teaCardSaveParam: TeaCardSaveParam): Boolean {
        TODO("Not yet implemented")
    }

    override fun deleteTeaCard(id: Long): Boolean {
        TODO("Not yet implemented")
    }

    override fun getTeaCard(id: Long): TeaCard {
        TODO("Not yet implemented")
    }

    override fun getAllTeaCards(): ArrayList<TeaCard> {
        TODO("Not yet implemented")
    }
}