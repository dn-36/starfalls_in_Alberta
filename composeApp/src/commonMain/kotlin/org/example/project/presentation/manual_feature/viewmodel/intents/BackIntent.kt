package org.example.project.presentation.manual_feature.viewmodel.intents

import com.project.astranomapp.data.StaticDate
import com.project.astranomapp.presentation.menu_feature.screen.MenuScreen
import org.example.project.presentation.add_starfall_feature.screen.AddStarfallScreen
import org.example.project.presentation.future_starfall_feature.screen.FutureStarfallScreen

object BackIntent {
    fun execute(){
        StaticDate.navigator.push(MenuScreen)

    }
}