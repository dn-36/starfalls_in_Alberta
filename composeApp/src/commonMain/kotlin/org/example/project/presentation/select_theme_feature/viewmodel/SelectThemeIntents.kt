package com.project.astranomapp.presentation.select_theme_feature.viewmodel

sealed class SelectThemeIntents{
    data class ChoosingTheme(var indexTheme:Int):SelectThemeIntents()
    object Back:SelectThemeIntents()
}
