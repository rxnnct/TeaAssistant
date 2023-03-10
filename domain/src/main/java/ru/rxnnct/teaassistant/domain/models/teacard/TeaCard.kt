package ru.rxnnct.teaassistant.domain.models.teacard

data class TeaCard(
    val id: Long,
    val name: String,
    val type: String,
    val origin: String
)