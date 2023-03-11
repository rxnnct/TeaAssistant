package ru.rxnnct.teaassistant.presentation.fragment

import android.content.Context
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ru.rxnnct.teaassistant.data.repository.SettingsRepositoryImpl
import ru.rxnnct.teaassistant.data.storage.SharedPreferencesSettingsStorage
import ru.rxnnct.teaassistant.domain.models.settings.Language
import ru.rxnnct.teaassistant.domain.models.settings.Settings
import ru.rxnnct.teaassistant.domain.models.settings.SettingsSaveParam
import ru.rxnnct.teaassistant.domain.usecase.settings.GetSettingsUseCase
import ru.rxnnct.teaassistant.domain.usecase.settings.SaveSettingsUseCase

class SettingsViewModel(
    private val getSettingsUseCase: GetSettingsUseCase,
    private val saveSettingsUseCase: SaveSettingsUseCase
) : ViewModel() {

    init {
        Log.d("RXN", "VM CRTD")
    }

    override fun onCleared() {
        Log.d("RXN", "VM CLRD")
        super.onCleared()
    }

    fun save(language: String): String {
        val params = SettingsSaveParam(
            language = Language.valueOf(language)
        )
        val result: Boolean = saveSettingsUseCase.execute(param = params)
        return result.toString()
    }

    fun get(): String {
        val settings: Settings = getSettingsUseCase.execute()
        return settings.language.toString()
    }
}

class SettingsViewModelFactory(context: Context) : ViewModelProvider.Factory {

    private val settingsRepository by lazy(LazyThreadSafetyMode.NONE) {
        SettingsRepositoryImpl(
            settingsStorage = SharedPreferencesSettingsStorage(context = context)
        )
    }
    private val getSettingsUseCase by lazy(LazyThreadSafetyMode.NONE) {
        GetSettingsUseCase(
            settingsRepository = settingsRepository
        )
    }
    private val saveSettingsUseCase by lazy(LazyThreadSafetyMode.NONE) {
        SaveSettingsUseCase(
            settingsRepository = settingsRepository
        )
    }

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return SettingsViewModel(
            getSettingsUseCase = getSettingsUseCase,
            saveSettingsUseCase = saveSettingsUseCase
        ) as T
    }
}