package com.project.astranomapp.presentation.menu_feature.viewmodel.intents

import com.project.astranomapp.data.StaticDate
import org.example.project.presentation.future_starfall_feature.screen.FutureStarfallScreen
import com.project.astranomapp.presentation.menu_feature.viewmodel.MenuViewModel

object FutureStarfallIntent {
    fun execute(){
        MenuViewModel(StaticDate).date.isUsedFuture = true
        StaticDate.navigator.push(FutureStarfallScreen)
    }
}