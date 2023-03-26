package ru.rxnnct.teaassistant.data.storage

import android.content.Context
import androidx.room.Room
import ru.rxnnct.teaassistant.data.storage.models.TeaCardData

class RoomTeaCardStorage(context: Context) : TeaCardStorage {

    private val database = Room.databaseBuilder(
        context,
        RoomTeaCardDatabase::class.java, "database-name"
    ).allowMainThreadQueries().build()


    override fun create(teaCardSaveParamData: TeaCardData): Boolean {
        return if (teaCardSaveParamData.name != ""
            && teaCardSaveParamData.type != ""
            && teaCardSaveParamData.origin != ""
        ) {
            val userDao = database.teaCardDataDao()
            userDao.insert(teaCardSaveParamData)
            true
        } else {
            false
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

    override fun getAll(): List<TeaCardData> {
        val userDao = database.teaCardDataDao()
        return userDao.getAll()
    }
}