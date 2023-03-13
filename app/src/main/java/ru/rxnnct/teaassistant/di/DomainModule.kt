package ru.rxnnct.teaassistant.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import ru.rxnnct.teaassistant.domain.repository.SettingsRepository
import ru.rxnnct.teaassistant.domain.usecase.settings.GetSettingsUseCase
import ru.rxnnct.teaassistant.domain.usecase.settings.SaveSettingsUseCase

@Module
@InstallIn(ViewModelComponent::class)
class DomainModule {

    @Provides
    fun provideGetSettingsUseCase(settingsRepository: SettingsRepository): GetSettingsUseCase {
        return GetSettingsUseCase(settingsRepository = settingsRepository)
    }

    @Provides
    fun provideSaveSettingsUseCase(settingsRepository: SettingsRepository): SaveSettingsUseCase {
        return SaveSettingsUseCase(settingsRepository = settingsRepository)
    }
}