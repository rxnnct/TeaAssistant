package ru.rxnnct.teaassistant.domain.usecase.settings

import ru.rxnnct.teaassistant.domain.models.settings.Settings
import ru.rxnnct.teaassistant.domain.repository.SettingsRepository

class GetSettingsUseCase(private val settingsRepository: SettingsRepository) {
    fun execute(): Settings {
        return settingsRepository.getSettings()
    }
}