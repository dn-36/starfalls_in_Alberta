package com.project.astranomapp.presentation.add_starfall_feature.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.project.astranomapp.data.StaticDateApi
import org.example.project.presentation.add_starfall_feature.viewmodel.intents.BackIntent
import com.project.astranomapp.presentation.add_starfall_feature.viewmodel.intents.SetAddStarfallIntent
import org.example.project.presentation.add_starfall_feature.viewmodel.intents.SaveIntent
import org.example.project.presentation.add_starfall_feature.viewmodel.intents.ToastIntent

class ViewModelAddStarfall(val date: StaticDateApi):ViewModel() {
    companion object{
        var addStarfallState by mutableStateOf(AddStarfallState())
    }
    fun processIntents(intents: AddStarfallIntents){
        when(intents){
            is AddStarfallIntents.SetScreen -> {
                SetAddStarfallIntent.execute()}
            is AddStarfallIntents.Toast-> {
                ToastIntent.execute()}
            is AddStarfallIntents.Back -> {
                BackIntent.execute()}
            is AddStarfallIntents.Save -> {
                SaveIntent.execute(intents.images,intents.date,intents.location)}
        }
    }
}