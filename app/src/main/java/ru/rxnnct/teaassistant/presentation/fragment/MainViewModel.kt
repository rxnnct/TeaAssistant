package ru.rxnnct.teaassistant.presentation.fragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import ru.rxnnct.teaassistant.domain.models.teacard.TeaCard
import ru.rxnnct.teaassistant.domain.usecase.teacard.GetAllTeaCardsUseCase
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getAllTeaCardsUseCase: GetAllTeaCardsUseCase
) : ViewModel() {

    private val _teaCardsListLiveData = MutableLiveData<ArrayList<TeaCard>>()
    val teaCardsListLiveData: LiveData<ArrayList<TeaCard>> = _teaCardsListLiveData

    init {
        getAllTeaCards()
    }

    fun getAllTeaCards() {
        _teaCardsListLiveData.value = getAllTeaCardsUseCase.execute()
    }
}