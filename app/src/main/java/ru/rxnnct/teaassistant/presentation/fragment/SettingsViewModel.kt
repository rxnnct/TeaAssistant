package ru.rxnnct.teaassistant.presentation.fragment

import android.util.Log
import androidx.lifecycle.ViewModel

class SettingsViewModel : ViewModel() {
    init {
        Log.d("RXN", "VM CRTD")
    }

    override fun onCleared() {
        Log.d("RXN", "VM CLRD")
        super.onCleared()
    }
}