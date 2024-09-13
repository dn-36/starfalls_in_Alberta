package org.example.project.presentation.future_starfall_feature.viewmodel.intents

import androidx.compose.runtime.mutableStateOf
import com.project.astranomapp.presentation.future_starfall_feature.viewmodel.ViewModelFutureStarfall

object OpenCloseYearIntent {
    fun execute(){
        if(ViewModelFutureStarfall.futureStarfallState.alphaYear.value == 0f) {
            ViewModelFutureStarfall.futureStarfallState =
                ViewModelFutureStarfall.futureStarfallState.copy(
                    alphaYear = mutableStateOf(1f)
                )
        }
        else if (ViewModelFutureStarfall.futureStarfallState.alphaYear.value == 1f){
            ViewModelFutureStarfall.futureStarfallState =
                ViewModelFutureStarfall.futureStarfallState.copy(
                    alphaYear = mutableStateOf(0f)
                )
        }
    }
}