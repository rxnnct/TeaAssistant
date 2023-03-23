package ru.rxnnct.teaassistant.data.storage

import ru.rxnnct.teaassistant.data.storage.models.TeaCardData
import ru.rxnnct.teaassistant.data.storage.models.TeaCardSaveParamData

interface TeaCardStorage {

    fun create(teaCardSaveParamData: TeaCardSaveParamData): Boolean

    fun edit(teaCardData: TeaCardData): Boolean

    fun delete(id: Long): Boolean

    fun get(id: Long): TeaCardData

    fun getAll(): ArrayList<TeaCardData>
}