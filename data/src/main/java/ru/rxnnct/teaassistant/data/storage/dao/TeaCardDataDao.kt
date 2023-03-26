package ru.rxnnct.teaassistant.data.storage.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import ru.rxnnct.teaassistant.data.storage.models.TeaCardData

@Dao
interface TeaCardDataDao {

    @Query("SELECT * FROM tea_card_table")
    fun getAll(): List<TeaCardData>

    @Insert
    fun insert(teaCardSaveParamData: TeaCardData)

}