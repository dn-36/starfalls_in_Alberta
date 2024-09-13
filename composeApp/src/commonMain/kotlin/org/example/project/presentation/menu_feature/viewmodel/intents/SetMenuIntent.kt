package com.project.astranomapp.presentation.menu_feature.viewmodel.intents

import androidx.compose.runtime.mutableStateOf
import com.project.astranomapp.data.StaticDate
import com.project.astranomapp.presentation.menu_feature.viewmodel.MenuViewModel

object SetMenuIntent {
    fun execute(){
        if(MenuViewModel(StaticDate).date.isUsedMenu) {
            MenuViewModel(StaticDate).date.isUsedMenu = false
            MenuViewModel.menuState = MenuViewModel.menuState.copy(
                theme = mutableStateOf(MenuViewModel(StaticDate).date.theme)
            )
        }
    }
}