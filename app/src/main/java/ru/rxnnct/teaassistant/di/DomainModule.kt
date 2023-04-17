package ru.rxnnct.teaassistant.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import ru.rxnnct.teaassistant.domain.repository.SettingsRepository
import ru.rxnnct.teaassistant.domain.repository.TeaCardRepository
import ru.rxnnct.teaassistant.domain.usecase.settings.GetSettingsUseCase
import ru.rxnnct.teaassistant.domain.usecase.settings.SaveSettingsUseCase
import ru.rxnnct.teaassistant.domain.usecase.teacard.CreateTeaCardUseCase
import ru.rxnnct.teaassistant.domain.usecase.teacard.EditTeaCardUseCase
import ru.rxnnct.teaassistant.domain.usecase.teacard.GetAllTeaCardsUseCase
import ru.rxnnct.teaassistant.domain.usecase.teacard.GetTeaCardUseCase

@Module
@InstallIn(ViewModelComponent::class)
class DomainModule {

    //settings:
    @Provides
    fun provideGetSettingsUseCase(settingsRepository: SettingsRepository): GetSettingsUseCase {
        return GetSettingsUseCase(settingsRepository = settingsRepository)
    }

    @Provides
    fun provideSaveSettingsUseCase(settingsRepository: SettingsRepository): SaveSettingsUseCase {
        return SaveSettingsUseCase(settingsRepository = settingsRepository)
    }

    //tea card:
    @Provides
    fun provideGetTeaCardUseCase(teaCardRepository: TeaCardRepository): GetTeaCardUseCase {
        return GetTeaCardUseCase(teaCardRepository = teaCardRepository)
    }

    @Provides
    fun provideGetAllTeaCardUseCase(teaCardRepository: TeaCardRepository): GetAllTeaCardsUseCase {
        return GetAllTeaCardsUseCase(teaCardRepository = teaCardRepository)
    }

    @Provides
    fun provideCreateTeaCardUseCase(teaCardRepository: TeaCardRepository): CreateTeaCardUseCase {
        return CreateTeaCardUseCase(teaCardRepository = teaCardRepository)
    }

    @Provides
    fun provideEditTeaCardUseCase(teaCardRepository: TeaCardRepository): EditTeaCardUseCase {
        return EditTeaCardUseCase(teaCardRepository = teaCardRepository)
    }
}