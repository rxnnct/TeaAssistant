package ru.rxnnct.teaassistant.data.storage

import androidx.room.Database
import androidx.room.RoomDatabase
import ru.rxnnct.teaassistant.data.storage.dao.TeaCardDataDao
import ru.rxnnct.teaassistant.data.storage.models.TeaCardData

@Database(entities = [TeaCardData::class], version = 1)
abstract class RoomTeaCardDatabase : RoomDatabase() {
    abstract fun teaCardDataDao(): TeaCardDataDao
}