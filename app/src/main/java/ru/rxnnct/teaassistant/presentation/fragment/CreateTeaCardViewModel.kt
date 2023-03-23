package ru.rxnnct.teaassistant.presentation.fragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import ru.rxnnct.teaassistant.domain.models.teacard.TeaCardSaveParam
import ru.rxnnct.teaassistant.domain.usecase.teacard.CreateTeaCardUseCase
import javax.inject.Inject

@HiltViewModel
class CreateTeaCardViewModel @Inject constructor(
    private val createTeaCardUseCase: CreateTeaCardUseCase
) : ViewModel() {

    private val _teaCardLiveData = MutableLiveData<TeaCardSaveParam>()
    private val _resultLiveData = MutableLiveData<String>()
    val teaCardLiveData: LiveData<TeaCardSaveParam> = _teaCardLiveData
    val resultLiveData: LiveData<String> = _resultLiveData


    fun createTeaCard(name: String, type: String, origin: String) {
        val teaCardSaveParam = TeaCardSaveParam(
            name = name,
            type = type,
            origin = origin
        )
        val result: Boolean = createTeaCardUseCase.execute(teaCardSaveParam = teaCardSaveParam)
        if (result) {
            _teaCardLiveData.value = TeaCardSaveParam("", "", "")
            _resultLiveData.value = "Saved"
        } else _resultLiveData.value = "Error"
    }
}