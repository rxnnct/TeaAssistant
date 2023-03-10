package ru.rxnnct.teaassistant.data.storage

import android.content.Context
import ru.rxnnct.teaassistant.data.storage.models.Settings

private const val SHARED_PREFERENCES_NAME = "shared_preferences_name"
private const val KEY_LANGUAGE = "language"

class SharedPreferencesSettingsStorage(context: Context) : SettingsStorage {

    private val sharedPreferences = context.getSharedPreferences(SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE)

    override fun save(settings: Settings): Boolean {
        sharedPreferences.edit().putString(KEY_LANGUAGE, settings.language).apply()
        return true
    }

    override fun get(): Settings {
        val language = sharedPreferences.getString(KEY_LANGUAGE, "") ?: ""
        return Settings(language = language)
    }
}