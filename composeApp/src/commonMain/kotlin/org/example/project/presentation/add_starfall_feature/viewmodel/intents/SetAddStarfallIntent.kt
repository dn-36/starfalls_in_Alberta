package com.project.astranomapp.presentation.add_starfall_feature.viewmodel.intents

import androidx.compose.runtime.mutableStateOf
import com.project.astranomapp.data.StaticDate
import com.project.astranomapp.presentation.add_starfall_feature.viewmodel.ViewModelAddStarfall

object SetAddStarfallIntent {
    fun execute(){
        if(ViewModelAddStarfall(StaticDate).date.isUsedAddStarfall) {
            ViewModelAddStarfall(StaticDate).date.isUsedAddStarfall = false
            ViewModelAddStarfall.addStarfallState = ViewModelAddStarfall.addStarfallState.copy(
                theme = mutableStateOf(ViewModelAddStarfall(StaticDate).date.theme)
            )
        }
    }
}