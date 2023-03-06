package com.example.teaassistant.presentation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.teaassistant.data.repository.SettingsRepositoryImpl
import com.example.teaassistant.databinding.FragmentSettingsBinding
import com.example.teaassistant.domain.models.settings.Language
import com.example.teaassistant.domain.models.settings.Settings
import com.example.teaassistant.domain.models.settings.SettingsSaveParam
import com.example.teaassistant.domain.usecase.settings.GetSettingsUseCase
import com.example.teaassistant.domain.usecase.settings.SaveSettingsUseCase

class SettingsFragment : Fragment() {

    private lateinit var binding: FragmentSettingsBinding

    private val settingsRepository by lazy(LazyThreadSafetyMode.NONE) { SettingsRepositoryImpl(context = requireActivity()) }
    private val getSettingsUseCase by lazy(LazyThreadSafetyMode.NONE) { GetSettingsUseCase(settingsRepository = settingsRepository) }
    private val setSettingsUseCase by lazy(LazyThreadSafetyMode.NONE) { SaveSettingsUseCase(settingsRepository = settingsRepository) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSettingsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.bSet.setOnClickListener {
            val language = binding.etLanguage.text.toString()
            val params = SettingsSaveParam(language = Language.valueOf(language))
            val result: Boolean = setSettingsUseCase.execute(params)
            binding.tvRes.text = result.toString()
        }

        binding.bGet.setOnClickListener {
            val settings: Settings = getSettingsUseCase.execute()
            binding.tvLanguage.text = settings.language.toString()
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = SettingsFragment()
    }
}