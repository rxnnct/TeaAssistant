package ru.rxnnct.teaassistant.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import ru.rxnnct.teaassistant.data.repository.SettingsRepositoryImpl
import ru.rxnnct.teaassistant.data.repository.TeaCardRepositoryImpl
import ru.rxnnct.teaassistant.data.storage.RoomTeaCardStorage
import ru.rxnnct.teaassistant.data.storage.SettingsStorage
import ru.rxnnct.teaassistant.data.storage.SharedPreferencesSettingsStorage
import ru.rxnnct.teaassistant.data.storage.TeaCardStorage
import ru.rxnnct.teaassistant.domain.repository.SettingsRepository
import ru.rxnnct.teaassistant.domain.repository.TeaCardRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    //settings:
    @Provides
    @Singleton
    fun provideSettingsStorage(@ApplicationContext context: Context): SettingsStorage {
        return SharedPreferencesSettingsStorage(context = context)
    }

    @Provides
    @Singleton
    fun provideSettingsRepository(settingsStorage: SettingsStorage): SettingsRepository {
        return SettingsRepositoryImpl(settingsStorage = settingsStorage)
    }

    //tea card:
    @Provides
    @Singleton
    fun provideTeaCardStorage(@ApplicationContext context: Context): TeaCardStorage {
        return RoomTeaCardStorage(context = context)
    }

    @Provides
    @Singleton
    fun provideTeaCardRepository(teaCardStorage: TeaCardStorage): TeaCardRepository {
        return TeaCardRepositoryImpl(teaCardStorage = teaCardStorage)
    }
}