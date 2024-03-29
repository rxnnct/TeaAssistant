package ru.rxnnct.teaassistant.domain.usecase.settings

import ru.rxnnct.teaassistant.domain.models.settings.SettingsSaveParam
import ru.rxnnct.teaassistant.domain.repository.SettingsRepository

class SaveSettingsUseCase(private val settingsRepository: SettingsRepository) {
    fun execute(param: SettingsSaveParam): Boolean {
        return settingsRepository.saveSettings(settingsSaveParam = param)
    }
}