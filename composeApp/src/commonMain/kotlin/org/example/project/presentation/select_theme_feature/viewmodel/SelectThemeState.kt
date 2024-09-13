package org.example.project.presentation.select_theme_feature.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

import org.jetbrains.compose.resources.DrawableResource
import starfallsinalberta.composeapp.generated.resources.Res
import starfallsinalberta.composeapp.generated.resources.one_backgraund

data class SelectThemeState(
    val theme:MutableState<DrawableResource> = mutableStateOf(Res.drawable.one_backgraund),
    val alphaSelectedThem:MutableList<Float> = mutableListOf(1f,0f,0f,0f)
)
