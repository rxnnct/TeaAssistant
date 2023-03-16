package ru.rxnnct.teaassistant.data.storage

import ru.rxnnct.teaassistant.data.storage.models.TeaCardData

class RoomTeaCardStorage : TeaCardStorage {
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
        TODO("Not yet implemented")
    }
}