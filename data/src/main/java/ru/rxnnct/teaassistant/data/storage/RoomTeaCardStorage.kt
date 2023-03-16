package ru.rxnnct.teaassistant.data.storage

import android.content.Context
import ru.rxnnct.teaassistant.data.storage.models.TeaCardData
import ru.rxnnct.teaassistant.domain.models.teacard.TeaCard

//class RoomTeaCardStorage(context: Context) : TeaCardStorage {
class RoomTeaCardStorage() : TeaCardStorage {
    override fun create(teaCardData: TeaCardData): Boolean {
        TODO("Not yet implemented")
    }

    override fun edit(teaCardData: TeaCardData): Boolean {
        TODO("Not yet implemented")
    }

    override fun delete(id: Long): Boolean {
        TODO("Not yet implemented")
    }

    override fun get(id: Long): TeaCardData {
        TODO("Not yet implemented")
    }

    override fun getAll(): ArrayList<TeaCardData> {
        //stub
        return arrayListOf(
            TeaCardData(
                1,
                "Tieguanyin",
                "Oolong",
                "Fujian, China"
            ),
            TeaCardData(
                2,
                "Huangshan Maofeng",
                "Green",
                "Anhui, China"
            )
        )
    }
}