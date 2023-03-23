package ru.rxnnct.teaassistant.data.storage

import ru.rxnnct.teaassistant.data.storage.models.TeaCardData
import ru.rxnnct.teaassistant.data.storage.models.TeaCardSaveParamData

//class RoomTeaCardStorage(context: Context) : TeaCardStorage {
class RoomTeaCardStorage : TeaCardStorage {
    override fun create(teaCardSaveParamData: TeaCardSaveParamData): Boolean {
        //stub
        if (teaCardSaveParamData.name == "test") {
            return true
        } else {
            return false
        }

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