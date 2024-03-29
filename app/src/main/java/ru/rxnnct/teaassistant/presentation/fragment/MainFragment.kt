package ru.rxnnct.teaassistant.presentation.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import ru.rxnnct.teaassistant.databinding.FragmentMainBinding
import ru.rxnnct.teaassistant.presentation.utils.TeaCardsRecyclerViewAdapter

@AndroidEntryPoint
class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding
    private val viewModel: MainViewModel by viewModels()

    private lateinit var teaCardsRecyclerViewAdapter: TeaCardsRecyclerViewAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initTeaCardsRecyclerView()
    }

    fun initTeaCardsRecyclerView() = with(binding) {
        rvTeaCardList.layoutManager = LinearLayoutManager(activity)
        teaCardsRecyclerViewAdapter = TeaCardsRecyclerViewAdapter()
        rvTeaCardList.adapter = teaCardsRecyclerViewAdapter
        teaCardsRecyclerViewAdapter.submitList(viewModel.teaCardsListLiveData.value)
    }

    companion object {
        @JvmStatic
        fun newInstance() = MainFragment()
    }
}