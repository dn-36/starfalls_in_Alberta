package com.project.astranomapp.presentation.menu_feature.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.project.astranomapp.data.StaticDateApi
import com.project.astranomapp.presentation.menu_feature.viewmodel.intents.AddStarfallIntent
import com.project.astranomapp.presentation.menu_feature.viewmodel.intents.FutureStarfallIntent
import com.project.astranomapp.presentation.menu_feature.viewmodel.intents.GalleryIntent
import com.project.astranomapp.presentation.menu_feature.viewmodel.intents.SetMenuIntent
import com.project.astranomapp.presentation.menu_feature.viewmodel.intents.ThemesIntent
import org.example.project.presentation.menu_feature.viewmodel.intents.ManualIntent

class MenuViewModel(val date: StaticDateApi):ViewModel() {
    companion object{
        var menuState by mutableStateOf(MenuState())
    }
    fun processIntent(intents: MeniIntents){
        when(intents) {
            is MeniIntents.AddStarfall -> {AddStarfallIntent.execute()}
            is MeniIntents.FutureStarfall -> {FutureStarfallIntent.execute()}
            is MeniIntents.Gallery -> {GalleryIntent.execute()}
            is MeniIntents.Themes -> {ThemesIntent.execute()}
            is MeniIntents.SetScreen -> {SetMenuIntent.execute()}
            is MeniIntents.ManualScreen -> {ManualIntent.execute()}
        }
    }
}