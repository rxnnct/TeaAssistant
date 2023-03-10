package ru.rxnnct.teaassistant.data.storage

import ru.rxnnct.teaassistant.data.storage.models.Settings

interface SettingsStorage {

    fun save(settings: Settings): Boolean

    fun get(): Settings
}