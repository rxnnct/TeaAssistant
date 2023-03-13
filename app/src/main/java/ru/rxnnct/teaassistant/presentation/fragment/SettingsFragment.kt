package ru.rxnnct.teaassistant.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import ru.rxnnct.teaassistant.databinding.FragmentSettingsBinding
import ru.rxnnct.teaassistant.domain.models.settings.Language

@AndroidEntryPoint
class SettingsFragment : Fragment() {

    private lateinit var binding: FragmentSettingsBinding
    private val viewModel: SettingsViewModel by viewModels()

    private val languageSpinnerItems = enumValues<Language>().map { it.name }
    private lateinit var languageSpinner: Spinner
    private lateinit var languageSpinnerAdapter: ArrayAdapter<String>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSettingsBinding.inflate(inflater, container, false)
        languageSpinner = binding.sLanguage
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initLanguageSpinner()

        viewModel.languageLiveData.observe(viewLifecycleOwner) {
            binding.tvLanguage.text = it
            languageSpinner.setSelection(languageSpinnerAdapter.getPosition(it))
        }

        viewModel.resultLiveData.observe(viewLifecycleOwner) {
            val resultToast: Toast =
                Toast.makeText(requireContext(), viewModel.resultLiveData.value, Toast.LENGTH_LONG)
            resultToast.show()
        }

        binding.bSave.setOnClickListener {
            //val language = languageSpinner.selectedItem.toString()
            //viewModel.save(language)
            // TODO: save settings
        }
    }

    private fun initLanguageSpinner() {
        languageSpinnerAdapter = ArrayAdapter(
            requireContext(),
            android.R.layout.simple_spinner_item, languageSpinnerItems
        )
        languageSpinner.adapter = languageSpinnerAdapter

        languageSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                viewModel.save(languageSpinnerItems[position])
            }

            override fun onNothingSelected(adapterView: AdapterView<*>) {
                val resultToast: Toast =
                    Toast.makeText(requireContext(), "Not saved", Toast.LENGTH_LONG)
                resultToast.show()
            }
        }
    }

    // TODO: remove
    companion object {
        @JvmStatic
        fun newInstance() = SettingsFragment()
    }
}