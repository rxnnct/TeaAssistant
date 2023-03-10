package com.example.teaassistant.data.storage

import com.example.teaassistant.data.storage.models.Settings

interface SettingsStorage {

    fun save(settings: Settings): Boolean

    fun get(): Settings
}