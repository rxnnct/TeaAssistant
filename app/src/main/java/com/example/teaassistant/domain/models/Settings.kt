package com.example.teaassistant.domain.models

data class Settings(
    val language: Language
)

enum class Language {
    ENGLISH,
    RUSSIAN
}