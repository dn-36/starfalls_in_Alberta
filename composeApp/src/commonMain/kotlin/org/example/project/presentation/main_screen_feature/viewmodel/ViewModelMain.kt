package com.project.astranomapp.presentation.main_screen_feature.viewmodel

import androidx.lifecycle.ViewModel
import com.project.astranomapp.data.StaticDateApi
import org.example.project.presentation.main_screen_feature.viewmodel.intents.GoToScreenIntent

class ViewModelMain(val date: StaticDateApi):ViewModel() {
fun processIntents(intents: MainIntents){
    when(intents){
        is MainIntents.GoToScreen -> {
            GoToScreenIntent.execute()}
    }
}
}