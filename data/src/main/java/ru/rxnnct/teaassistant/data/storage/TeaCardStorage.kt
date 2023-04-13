package ru.rxnnct.teaassistant.data.storage

import ru.rxnnct.teaassistant.data.storage.models.TeaCardData

interface TeaCardStorage {

    fun create(teaCardSaveParamData: TeaCardData): Boolean

    fun update(teaCardData: TeaCardData): Boolean

    fun delete(id: Long): Boolean

    fun get(id: Long): TeaCardData

    fun getAll(): List<TeaCardData>
}