package com.example.teaassistant.domain.usecase.settings

import com.example.teaassistant.domain.models.settings.Settings
import com.example.teaassistant.domain.repository.SettingsRepository

class GetSettingsUseCase(private val settingsRepository: SettingsRepository) {
    fun execute(): Settings {
        return settingsRepository.getSettings()
    }
}