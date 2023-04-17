package ru.rxnnct.teaassistant.data.repository

import ru.rxnnct.teaassistant.data.storage.TeaCardStorage
import ru.rxnnct.teaassistant.data.storage.models.TeaCardData
import ru.rxnnct.teaassistant.domain.models.teacard.TeaCard
import ru.rxnnct.teaassistant.domain.models.teacard.TeaCardSaveParam
import ru.rxnnct.teaassistant.domain.repository.TeaCardRepository

class TeaCardRepositoryImpl(private val teaCardStorage: TeaCardStorage) : TeaCardRepository {

    override fun createTeaCard(teaCardSaveParam: TeaCardSaveParam): Boolean {
        return teaCardStorage.create(mapModelToData(teaCardSaveParam))
    }

    override fun editTeaCard(teaCard: TeaCard): Boolean {
        return teaCardStorage.update(mapModelToData(teaCard))
    }

    override fun deleteTeaCard(id: Long): Boolean {
        TODO("Not yet implemented")
    }

    override fun getTeaCard(id: Long): TeaCard {
        val teaCard = teaCardStorage.getById(id)
        return mapDataToModel(teaCard)
    }

    override fun getAllTeaCards(): List<TeaCard> {
        val teaCardList = teaCardStorage.getAll()
        return teaCardList.map { mapDataToModel(it) }
    }

    private fun mapDataToModel(teaCardData: TeaCardData): TeaCard {
        return TeaCard(
            id = teaCardData.id,
            name = teaCardData.name,
            type = teaCardData.type,
            origin = teaCardData.origin
        )
    }

    private fun mapModelToData(teaCardSaveData: TeaCardSaveParam): TeaCardData {
        return TeaCardData(
            name = teaCardSaveData.name,
            type = teaCardSaveData.type,
            origin = teaCardSaveData.origin
        )
    }

    private fun mapModelToData(teaCard: TeaCard): TeaCardData {
        return TeaCardData(
            name = teaCard.name,
            type = teaCard.type,
            origin = teaCard.origin
        )
    }
}