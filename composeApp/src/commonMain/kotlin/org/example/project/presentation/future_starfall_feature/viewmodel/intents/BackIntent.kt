package com.project.astranomapp.presentation.future_starfall_feature.viewmodel.intents

import com.project.astranomapp.data.StaticDate
import com.project.astranomapp.presentation.menu_feature.screen.MenuScreen

object BackIntent {
    fun execute(){
        StaticDate.navigator.push(MenuScreen)
    }
}