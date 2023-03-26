package ru.rxnnct.teaassistant.data.storage

import android.content.Context
import ru.rxnnct.teaassistant.data.storage.models.SettingsData

private const val SHARED_PREFERENCES_NAME = "shared_preferences_name"
private const val KEY_LANGUAGE = "language"

class SharedPreferencesSettingsStorage(context: Context) : SettingsStorage {

    private val sharedPreferences = context.getSharedPreferences(SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE)

    override fun save(settingsData: SettingsData): Boolean {
        sharedPreferences.edit().putString(KEY_LANGUAGE, settingsData.language).apply()
        return true
    }

    override fun get(): SettingsData {
        val language = sharedPreferences.getString(KEY_LANGUAGE, "") ?: ""
        return SettingsData(language = language)
    }
}