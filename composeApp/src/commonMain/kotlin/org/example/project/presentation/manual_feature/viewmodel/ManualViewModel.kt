package org.example.project.presentation.manual_feature.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.project.astranomapp.data.StaticDateApi
import com.project.astranomapp.presentation.menu_feature.viewmodel.MenuState
import org.example.project.presentation.manual_feature.viewmodel.intents.BackIntent
import org.example.project.presentation.manual_feature.viewmodel.intents.SetManualIntent

class ManualViewModel(val date: StaticDateApi
):ViewModel(){
    companion object{
        var manualState by mutableStateOf(ManualState())
    }
    fun processIntent(intents: ManualIntents){
        when(intents){
            is ManualIntents.SetScreen -> {SetManualIntent.execute()}
            is ManualIntents.Back -> {BackIntent.execute()}
        }
    }
}