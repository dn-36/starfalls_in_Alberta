package org.example.project.presentation.future_starfall_feature.viewmodel.intents

import androidx.compose.runtime.mutableStateOf
import com.project.astranomapp.data.StaticDate
import com.project.astranomapp.presentation.future_starfall_feature.viewmodel.ViewModelFutureStarfall

object SetFutureStarfallIntent {
    fun execute() {
        if (ViewModelFutureStarfall(StaticDate).date.isUsedFuture) {
            ViewModelFutureStarfall(StaticDate).date.isUsedFuture = false
            ViewModelFutureStarfall.futureStarfallState =
                ViewModelFutureStarfall.futureStarfallState.copy(
                    theme = mutableStateOf(ViewModelFutureStarfall(StaticDate).date.theme)
                )
        }
    }
}