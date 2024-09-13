package org.example.project.presentation.manual_feature.viewmodel.intents

import androidx.compose.runtime.mutableStateOf
import com.project.astranomapp.data.StaticDate
import com.project.astranomapp.presentation.menu_feature.viewmodel.MenuViewModel
import org.example.project.presentation.manual_feature.viewmodel.ManualViewModel

object SetManualIntent {
    fun execute(){
        ManualViewModel.manualState = ManualViewModel.manualState.copy(
            theme = mutableStateOf(MenuViewModel(StaticDate).date.theme)
        )
    }
}