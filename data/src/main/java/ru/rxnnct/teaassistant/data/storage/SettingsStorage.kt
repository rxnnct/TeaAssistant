package ru.rxnnct.teaassistant.data.storage

import ru.rxnnct.teaassistant.data.storage.models.SettingsData

interface SettingsStorage {

    fun save(settingsData: SettingsData): Boolean

    fun get(): SettingsData
}