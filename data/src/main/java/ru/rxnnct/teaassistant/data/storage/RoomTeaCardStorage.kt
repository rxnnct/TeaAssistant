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
            val teaCardDao = database.teaCardDataDao()
            teaCardDao.insert(teaCardSaveParamData)
            true
        } else {
            false
        }
    }

    override fun update(teaCardData: TeaCardData): Boolean {
        return if (teaCardData.name != ""
            && teaCardData.type != ""
            && teaCardData.origin != ""
        ) {
            val teaCardDao = database.teaCardDataDao()
            teaCardDao.update(teaCardData)
            true
        } else {
            false
        }
    }

    override fun delete(id: Long): Boolean {
        TODO("Not yet implemented")
    }

    override fun getById(id: Long): TeaCardData {
        val teaCardDao = database.teaCardDataDao()
        return teaCardDao.getById(id)
    }

    override fun getAll(): List<TeaCardData> {
        val teaCardDao = database.teaCardDataDao()
        return teaCardDao.getAll()
    }
}