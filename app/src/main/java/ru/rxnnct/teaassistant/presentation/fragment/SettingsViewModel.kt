package ru.rxnnct.teaassistant.presentation.fragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import ru.rxnnct.teaassistant.domain.models.settings.Language
import ru.rxnnct.teaassistant.domain.models.settings.Settings
import ru.rxnnct.teaassistant.domain.models.settings.SettingsSaveParam
import ru.rxnnct.teaassistant.domain.usecase.settings.GetSettingsUseCase
import ru.rxnnct.teaassistant.domain.usecase.settings.SaveSettingsUseCase
import javax.inject.Inject

@HiltViewModel
class SettingsViewModel @Inject constructor(
    private val getSettingsUseCase: GetSettingsUseCase,
    private val saveSettingsUseCase: SaveSettingsUseCase
) : ViewModel() {

    private val _languageLiveData = MutableLiveData<String>()
    private val _resultLiveData = MutableLiveData<String>()
    val languageLiveData: LiveData<String> = _languageLiveData
    val resultLiveData: LiveData<String> = _resultLiveData

    init {
        get()
    }

    fun save(language: String) {
        val params = SettingsSaveParam(
            language = Language.valueOf(language)
        )
        val result: Boolean = saveSettingsUseCase.execute(param = params)
        if (result) {
            _languageLiveData.value = language
            _resultLiveData.value = "Saved"
        } else _resultLiveData.value = "Error"
    }

    fun get() {
        val settings: Settings = getSettingsUseCase.execute()
        _languageLiveData.value = settings.language.toString()
    }
}