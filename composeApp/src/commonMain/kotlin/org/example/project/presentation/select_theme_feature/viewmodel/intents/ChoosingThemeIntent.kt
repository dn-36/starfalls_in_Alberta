package com.project.astranomapp.presentation.select_theme_feature.viewmodel.intents

import androidx.compose.runtime.mutableStateOf
import com.project.astranomapp.data.StaticDate
import com.project.astranomapp.presentation.select_theme_feature.viewmodel.ViewModelSelectTheme
import starfallsinalberta.composeapp.generated.resources.Res
import starfallsinalberta.composeapp.generated.resources.four_backgraund
import starfallsinalberta.composeapp.generated.resources.one_backgraund
import starfallsinalberta.composeapp.generated.resources.three_backgraund
import starfallsinalberta.composeapp.generated.resources.two_backgraund


object ChoosingThemeIntent {
    fun execute(indexThemes: Int) {
        when (indexThemes) {
            0 -> {
                ViewModelSelectTheme(StaticDate).date.theme = Res.drawable.one_backgraund
                ViewModelSelectTheme.selectedThemeState =
                    ViewModelSelectTheme.selectedThemeState.copy(
                        alphaSelectedThem = mutableListOf(1f, 0f, 0f, 0f),
                        theme = mutableStateOf(ViewModelSelectTheme(StaticDate).date.theme)
                    )
            }

            1 -> {
                ViewModelSelectTheme(StaticDate).date.theme = Res.drawable.two_backgraund
                ViewModelSelectTheme.selectedThemeState =
                    ViewModelSelectTheme.selectedThemeState.copy(
                        alphaSelectedThem = mutableListOf(0f, 1f, 0f, 0f),
                        theme = mutableStateOf( ViewModelSelectTheme(StaticDate).date.theme)
                    )
            }

            2 -> {
                ViewModelSelectTheme(StaticDate).date.theme = Res.drawable.three_backgraund
                ViewModelSelectTheme.selectedThemeState =
                    ViewModelSelectTheme.selectedThemeState.copy(
                        alphaSelectedThem = mutableListOf(0f, 0f, 1f, 0f),
                        theme = mutableStateOf(ViewModelSelectTheme(StaticDate).date.theme)
                    )
            }

            3 -> {
                ViewModelSelectTheme(StaticDate).date.theme = Res.drawable.four_backgraund
                ViewModelSelectTheme.selectedThemeState =
                    ViewModelSelectTheme.selectedThemeState.copy(
                        alphaSelectedThem = mutableListOf(0f, 0f, 0f, 1f),
                        theme = mutableStateOf(ViewModelSelectTheme(StaticDate).date.theme)
                    )
            }
        }
        ViewModelSelectTheme(StaticDate).date.isUsedMenu = true
    }
}