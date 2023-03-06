package com.example.teaassistant.domain.repository

import com.example.teaassistant.domain.models.Settings
import com.example.teaassistant.domain.models.SettingsSaveParam

interface SettingsRepository {

    fun saveSettings(saveParam: SettingsSaveParam): Boolean

    fun getSettings(): Settings
}