package com.project.astranomapp.presentation.future_starfall_feature.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.project.astranomapp.data.StaticDateApi
import com.project.astranomapp.presentation.future_starfall_feature.viewmodel.intents.BackIntent
import com.project.astranomapp.presentation.future_starfall_feature.viewmodel.intents.ChooseDateIntent
import com.project.astranomapp.presentation.future_starfall_feature.viewmodel.intents.OpenCloseMonthIntent
import org.example.project.presentation.future_starfall_feature.viewmodel.intents.OpenCloseYearIntent
import org.example.project.presentation.future_starfall_feature.viewmodel.intents.SetFutureStarfallIntent

class ViewModelFutureStarfall(val date: StaticDateApi):ViewModel() {
    companion object{
        var futureStarfallState by mutableStateOf(FutureStarfallState())
    }
    fun processIntent(intents: FutureStarfallIntents){
        when(intents){
            is FutureStarfallIntents.SetScreen -> {
                SetFutureStarfallIntent.execute()}
            is FutureStarfallIntents.Back -> {BackIntent.execute()}
            is FutureStarfallIntents.OpenCloseMonth -> { OpenCloseMonthIntent.execute()}
            is FutureStarfallIntents.OpenCloseYear -> { OpenCloseYearIntent.execute()}
            is FutureStarfallIntents.ChooseDate -> { ChooseDateIntent.execute(intents.month,intents.year)}
        }
    }
}