package com.project.astranomapp.presentation.future_starfall_feature.viewmodel.intents

import androidx.compose.runtime.mutableStateOf
import com.project.astranomapp.presentation.future_starfall_feature.viewmodel.ViewModelFutureStarfall

object OpenCloseMonthIntent {
    fun execute(){
        if(ViewModelFutureStarfall.futureStarfallState.alphaMonth.value == 0f) {
            ViewModelFutureStarfall.futureStarfallState =
                ViewModelFutureStarfall.futureStarfallState.copy(
                    alphaMonth = mutableStateOf(1f)
                )
        }
        else if (ViewModelFutureStarfall.futureStarfallState.alphaMonth.value == 1f){
            ViewModelFutureStarfall.futureStarfallState =
                ViewModelFutureStarfall.futureStarfallState.copy(
                    alphaMonth = mutableStateOf(0f)
                )
        }
    }
}