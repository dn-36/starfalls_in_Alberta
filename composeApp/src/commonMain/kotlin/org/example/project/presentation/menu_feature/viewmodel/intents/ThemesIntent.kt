package com.project.astranomapp.presentation.menu_feature.viewmodel.intents

import com.project.astranomapp.data.StaticDate
import org.example.project.presentation.select_theme_feature.screen.SelectThemeScreen

object ThemesIntent {
    fun execute(){
        StaticDate.navigator.push(SelectThemeScreen)
    }
}