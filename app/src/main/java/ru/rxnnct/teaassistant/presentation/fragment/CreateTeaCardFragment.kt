package ru.rxnnct.teaassistant.presentation.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import dagger.hilt.android.AndroidEntryPoint
import ru.rxnnct.teaassistant.R
import ru.rxnnct.teaassistant.databinding.FragmentCreateTeaCardBinding

@AndroidEntryPoint
class CreateTeaCardFragment : Fragment() {

    private lateinit var binding: FragmentCreateTeaCardBinding
    private val viewModel: CreateTeaCardViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCreateTeaCardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.resultLiveData.observe(viewLifecycleOwner) {
            var creationResult = "Error"
            if (it) {
                creationResult = "Saved"
                activity?.findNavController(R.id.fragmentContainerView)?.navigate(R.id.mainFragment)
            }
            val resultToast: Toast =
                Toast.makeText(requireContext(), creationResult, Toast.LENGTH_LONG)
            resultToast.show()
        }

        binding.bCreateTeaCard.setOnClickListener {
            viewModel.createTeaCard(
                name = binding.etCreateName.text.toString(),
                type = binding.etCreateType.text.toString(),
                origin = binding.etCreateOrigin.text.toString()
            )
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = CreateTeaCardFragment()
    }
}