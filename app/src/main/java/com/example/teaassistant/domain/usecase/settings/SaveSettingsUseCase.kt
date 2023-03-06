package com.example.teaassistant.domain.usecase.settings

import com.example.teaassistant.domain.models.SettingsSaveParam
import com.example.teaassistant.domain.repository.SettingsRepository

class SaveSettingsUseCase(private val settingsRepository: SettingsRepository) {
     fun execute(param: SettingsSaveParam) : Boolean {
         val result: Boolean = settingsRepository.saveSettings(saveParam = param)
         return result
     }
}