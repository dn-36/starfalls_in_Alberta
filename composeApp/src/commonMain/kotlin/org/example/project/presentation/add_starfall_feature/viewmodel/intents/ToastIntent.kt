package org.example.project.presentation.add_starfall_feature.viewmodel.intents

import androidx.compose.runtime.mutableStateOf
import com.project.astranomapp.data.StaticDate
import com.project.astranomapp.presentation.add_starfall_feature.viewmodel.ViewModelAddStarfall

object ToastIntent {
    fun execute(){
            ViewModelAddStarfall.addStarfallState = ViewModelAddStarfall.addStarfallState.copy(
                toast = mutableStateOf(false))
    }
}