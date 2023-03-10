package com.example.teaassistant.presentation.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.teaassistant.databinding.FragmentMainBinding
import ru.rxnnct.teaassistant.domain.models.teacard.TeaCardSaveParam
import ru.rxnnct.teaassistant.domain.models.teacard.TeaCard
import ru.rxnnct.teaassistant.domain.usecase.teacard.CreateTeaCardUseCase
import ru.rxnnct.teaassistant.domain.usecase.teacard.GetTeaCardUseCase

class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding

    private val getTeaCardUseCase =
        GetTeaCardUseCase()
    private val createTeaCardUseCase =
        CreateTeaCardUseCase()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.bGetResult.setOnClickListener {
            val teaCard: TeaCard = getTeaCardUseCase.execute()
            binding.tvResult.text = teaCard.name
        }

        binding.bSetResult.setOnClickListener {
            Log.d(
                "rxn", createTeaCardUseCase.execute(
                    TeaCardSaveParam(
                        name = "Tea1",
                        type = "tea",
                        origin = "India"
                    )
                ).toString()
            )
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = MainFragment()
    }
}