package ru.rxnnct.teaassistant.presentation.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.rxnnct.teaassistant.databinding.FragmentCreateTeaCardBinding

class CreateTeaCardFragment : Fragment() {

    private lateinit var binding: FragmentCreateTeaCardBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCreateTeaCardBinding.inflate(inflater, container, false)
        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance() = CreateTeaCardFragment()
    }
}