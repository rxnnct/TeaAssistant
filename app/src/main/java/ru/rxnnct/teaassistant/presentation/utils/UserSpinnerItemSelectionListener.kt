package ru.rxnnct.teaassistant.presentation.utils

import android.view.View
import android.widget.AdapterView

abstract class UserSpinnerItemSelectionListener : AdapterView.OnItemSelectedListener {

    private var check = false

    abstract fun onUserItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long)

    override fun onItemSelected(
        parent: AdapterView<*>?,
        view: View,
        position: Int,
        id: Long
    ) {
        if (check) {
            onUserItemSelected(parent, view, position, id)
        }
        check = true
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {}
}