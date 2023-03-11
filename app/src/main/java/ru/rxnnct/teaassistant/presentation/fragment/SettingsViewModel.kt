package ru.rxnnct.teaassistant.presentation.fragment

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
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

    private val _languageLiveData = MutableLiveData<String>()
    private val _resultLiveData = MutableLiveData<String>()
    val languageLiveData: LiveData<String> = _languageLiveData
    val resultLiveData: LiveData<String> = _languageLiveData

    fun save(language: String) {
        val params = SettingsSaveParam(
            language = Language.valueOf(language)
        )
        val result: Boolean = saveSettingsUseCase.execute(param = params)
        _resultLiveData.value = "OK? - $result"
    }

    fun get() {
        val settings: Settings = getSettingsUseCase.execute()
        _languageLiveData.value = settings.language.toString()
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