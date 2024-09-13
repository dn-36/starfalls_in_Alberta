package com.project.astranomapp.presentation.menu_feature.viewmodel

sealed class MeniIntents{
    object AddStarfall:MeniIntents()
    object Gallery:MeniIntents()
    object Themes:MeniIntents()
    object FutureStarfall:MeniIntents()
    object SetScreen:MeniIntents()
    object ManualScreen:MeniIntents()
}
