package ru.rxnnct.teaassistant.presentation.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import ru.rxnnct.teaassistant.databinding.FragmentSettingsBinding

class SettingsFragment : Fragment() {

    private lateinit var binding: FragmentSettingsBinding
    private val viewModel: SettingsViewModel by viewModels { SettingsViewModelFactory(requireContext()) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSettingsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.languageLiveData.observe(viewLifecycleOwner) {
            binding.tvLanguage.text = it
        }

        viewModel.resultLiveData.observe(viewLifecycleOwner) {
            binding.tvRes.text = it
        }

        binding.bSet.setOnClickListener {
            val language = binding.etLanguage.text.toString()
            viewModel.save(language)
        }

        binding.bGet.setOnClickListener {
            viewModel.get()
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = SettingsFragment()
    }
}