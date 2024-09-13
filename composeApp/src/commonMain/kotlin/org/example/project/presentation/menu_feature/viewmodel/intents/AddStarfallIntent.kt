package com.project.astranomapp.presentation.menu_feature.viewmodel.intents

import com.project.astranomapp.data.StaticDate
import org.example.project.presentation.add_starfall_feature.screen.AddStarfallScreen
import com.project.astranomapp.presentation.menu_feature.viewmodel.MenuViewModel

object AddStarfallIntent {
    fun execute(){
        MenuViewModel(StaticDate).date.isUsedAddStarfall = true
        StaticDate.navigator.push(AddStarfallScreen)
    }
}