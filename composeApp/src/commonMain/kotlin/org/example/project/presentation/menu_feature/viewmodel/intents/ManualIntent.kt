package org.example.project.presentation.menu_feature.viewmodel.intents

import com.project.astranomapp.data.StaticDate
import org.example.project.presentation.manual_feature.screen.ManualScreen
import org.example.project.presentation.select_theme_feature.screen.SelectThemeScreen

object ManualIntent {
    fun execute(){
        StaticDate.navigator.push(ManualScreen)
    }
}