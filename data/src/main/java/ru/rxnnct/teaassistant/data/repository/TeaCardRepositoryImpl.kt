package ru.rxnnct.teaassistant.data.repository

import ru.rxnnct.teaassistant.data.storage.TeaCardStorage
import ru.rxnnct.teaassistant.data.storage.models.TeaCardData
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
        val teaCardList = teaCardStorage.getAll()
        return teaCardList.mapTo(ArrayList()) { mapDataToModel(it) }
    }

    private fun mapDataToModel(teaCardData: TeaCardData): TeaCard {
        return TeaCard(
            id = teaCardData.id,
            name = teaCardData.name,
            type = teaCardData.type,
            origin = teaCardData.origin
        )
    }
}