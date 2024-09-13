package com.project.astranomapp.presentation.select_theme_feature.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.project.astranomapp.data.StaticDateApi
import com.project.astranomapp.presentation.select_theme_feature.viewmodel.intents.BackIntent
import com.project.astranomapp.presentation.select_theme_feature.viewmodel.intents.ChoosingThemeIntent
import org.example.project.presentation.select_theme_feature.viewmodel.SelectThemeState

class ViewModelSelectTheme(val date: StaticDateApi):ViewModel() {
    companion object{
        var selectedThemeState by mutableStateOf(SelectThemeState())
    }
    fun processIntent(intents: SelectThemeIntents){
        when(intents){
            is SelectThemeIntents.ChoosingTheme -> {ChoosingThemeIntent.execute(intents.indexTheme)}
            is SelectThemeIntents.Back -> {BackIntent.execute()}
        }
    }
}