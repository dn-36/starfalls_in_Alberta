package com.project.astranomapp.presentation.create_user_card_feature.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.project.astranomapp.data.StaticDateApi
import com.project.astranomapp.presentation.create_user_card_feature.viewmodel.intents.CreateIntent
import com.project.astranomapp.presentation.create_user_card_feature.viewmodel.intents.ToastIntent
import com.project.astranomapp.presentation.future_starfall_feature.viewmodel.FutureStarfallState

class ViewModelCreateUserCard(val date: StaticDateApi):ViewModel() {
    companion object{
        var createUserCardState by mutableStateOf(CreateUserCardState())
    }
    fun processIntent(intents: CreateUserCardIntents){
        when(intents){
            is CreateUserCardIntents.Create -> {CreateIntent.execute(intents.name,intents.age,
            intents.place,intents.experience)}
            is CreateUserCardIntents.Toast -> {ToastIntent.execute()}
        }
    }
}