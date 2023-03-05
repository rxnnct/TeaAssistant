package com.example.teaassistant.domain.models

data class TeaCard(
    val id: Long,
    val name: String,
    val type: String,
    val origin: String
)